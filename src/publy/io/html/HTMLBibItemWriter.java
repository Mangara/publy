/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publy.io.html;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import publy.Console;
import publy.data.PublicationType;
import publy.data.bibitem.Article;
import publy.data.bibitem.Author;
import publy.data.bibitem.BibItem;
import publy.data.bibitem.Book;
import publy.data.bibitem.InCollection;
import publy.data.bibitem.InProceedings;
import publy.data.bibitem.InvitedTalk;
import publy.data.bibitem.MastersThesis;
import publy.data.bibitem.PhDThesis;
import publy.data.bibitem.Unpublished;
import publy.data.settings.FormatSettings;
import publy.data.settings.HTMLSettings;
import publy.io.BibItemWriter;

/**
 *
 * @author Sander Verdonschot <sander.verdonschot at gmail.com>
 */
public class HTMLBibItemWriter extends BibItemWriter {

    private HTMLSettings htmlSettings;
    private static final String indent = "        ";

    public HTMLBibItemWriter(BufferedWriter out, FormatSettings settings, HTMLSettings htmlSettings) {
        super(out, settings);
        this.htmlSettings = htmlSettings;
    }

    @Override
    protected void writeArticle(Article item, int number) throws IOException {
        writeTitleAndAuthorsHTML(item, number);

        // Handle submitted / accepted
        if (item.anyNonEmpty("status")) {
            writeStatus(item, item.get("journal"));
        } else {
            output(indent + "<span class=\"booktitle\">", item.get("journal"), "</span>, ");

            if (item.anyNonEmpty("volume", "number")) {
                output(item.get("volume"));
                output("(", item.get("number"), ")");
                output(":", formatPages(item, false), "");
                out.write(", ");
            } else {
                output(formatPages(item, false), ", ");
            }

            output(item.get("year"), ".<br>", true);
        }

        output(indent, item.get("note"), ".<br>", true);

        writeLinks(item);
    }

    @Override
    protected void writeBook(Book item, int number) throws IOException {
        writeTitleAndAuthorsHTML(item, number);

        output(indent, item.get("publisher"), ", ");
        output(item.get("year"), ".<br>", true);

        output(indent, item.get("note"), ".<br>", true);
        writeLinks(item);
    }

    @Override
    protected void writeInProceedings(InProceedings item, int number) throws IOException {
        writePart(item, number);
    }

    @Override
    protected void writeInCollection(InCollection item, int number) throws IOException {
        writePart(item, number);
    }

    /**
     * Used for both InCollection, and InProceedings.
     *
     * @param item
     * @throws IOException
     */
    private void writePart(BibItem item, int number) throws IOException {
        writeTitleAndAuthorsHTML(item, number);

        if (item.anyNonEmpty("status")) {
            writeStatus(item, item.get("booktitle"));
        } else {
            output(indent + "In <span class=\"booktitle\">", item.get("booktitle"), "</span>, ");

            writeVolume(item, ", ");

            output(formatPages(item, true), ", ");
            output(item.get("year"), ".<br>", true);
        }

        output(indent, item.get("note"), ".<br>", true);

        writeLinks(item);
    }

    @Override
    protected void writeMastersThesis(MastersThesis item, int number) throws IOException {
        writeTitleAndAuthorsHTML(item, number);

        output(indent + "Master's thesis, ", item.get("school"), ", ");
        output(item.get("year"), ".<br>", true);

        output(indent, item.get("note"), ".<br>", true);

        writeLinks(item);
    }

    @Override
    protected void writePhDThesis(PhDThesis item, int number) throws IOException {
        writeTitleAndAuthorsHTML(item, number);

        output(indent + "PhD thesis, ", item.get("school"), ", ");
        output(item.get("year"), ".<br>", true);

        output(indent, item.get("note"), ".<br>", true);

        writeLinks(item);
    }

    @Override
    protected void writeInvitedTalk(InvitedTalk item, int number) throws IOException {
        writeNumber(number);
        writeTitleAndAbstractHTML(item);

        output(indent, item.get("address"), ", ", false);
        output(formatDate(item), ".<br>", true);

        output(indent, item.get("note"), ".<br>", true);

        // links (no bibtex for talks)
        writeLinks(item, false, false);
    }

    @Override
    protected void writeUnpublished(Unpublished item, int number) throws IOException {
        writeTitleAndAuthorsHTML(item, number);

        output(indent, item.get("note"), ".<br>", true);

        // links (bibtex only if it's on the arXiv)
        writeLinks(item, false, item.anyNonEmpty("arxiv") && includeBibtex(item));
    }

    protected void writeTitleAndAuthorsHTML(BibItem item, int number) throws IOException {
        writeNumber(number);
        
        if (settings.isTitleFirst()) {
            writeTitleAndAbstractHTML(item);
        }

        // Don't add an authors line if it's just me and I just want to list co-authors
        if (settings.isListAllAuthors() || item.getAuthors().size() > 1) {
            output(indent, formatAuthors(item), ".<br>", true);
        }
        
        if (!settings.isTitleFirst()) {
            writeTitleAndAbstractHTML(item);
        }
    }

    private void writeNumber(int number) throws IOException {
        out.write(indent);

        // Number
        if (number >= 0) {
            output("<span class=\"number\">", Integer.toString(number), ".<span> ");
        }
    }
    
    protected void writeTitleAndAbstractHTML(BibItem item) throws IOException {
        // Title
        if (htmlSettings.getTitleTarget() == HTMLSettings.TitleLinkTarget.ABSTRACT && includeAbstract(item)) {
            output("<h2 id=\"" + item.getId() + "\" class=\"title link\">", formatTitle(item), "</h2>");
        } else if (htmlSettings.getTitleTarget() == HTMLSettings.TitleLinkTarget.PAPER && includePaper(item)) {
            try {
                String href = (new URI(null, null, item.get("paper"), null)).toString();

                out.write("<a href=\"" + href + "\">");
                output("<h2 id=\"" + item.getId() + "\" class=\"title\">", formatTitle(item), "</h2>");
                out.write("</a>");
                checkExistance(item.get("paper"), "paper", item);
            } catch (URISyntaxException ex) {
                Console.except(ex, "Paper link for entry \"%s\" is not formatted properly:", item.getId());
            }
        } else {
            output("<h2 id=\"" + item.getId() + "\" class=\"title\">", formatTitle(item), "</h2>");
        }

        // Add text if I presented this paper
        if ("yes".equals(item.get("presented"))) {
            output(" ", htmlSettings.getPresentedText(), "");
        }

        // Abstract if included
        if (includeAbstract(item)) {
            out.newLine();

            // Show \ hide link for the abstract
            if (htmlSettings.getTitleTarget() != HTMLSettings.TitleLinkTarget.ABSTRACT) {
                writeToggleLink(item.getId() + "_abstract", "Abstract");
            }

            out.write("<br>");
            out.newLine();

            // Actual abstract
            out.write(indent + "<div id=\"" + item.getId() + "_abstract\" class=\"collapsible\">");
            out.write("<div class=\"abstract\">");
            out.write("<span class=\"abstractword\">Abstract: </span>");
            output(item.get("abstract"));
            out.write("</div></div>");
            out.newLine();
        } else {
            out.write("<br>");
            out.newLine();
        }
    }

    @Override
    protected String formatAuthors(BibItem item) {
        String author = item.get("author");

        if (author == null) {
            Console.error("No authors found for %s.", item.getId());
            return "";
        } else {
            List<String> authorLinks = new ArrayList<>(item.getAuthors().size());

            for (Author a : item.getAuthors()) {
                if (a == null) {
                    Console.error("Null author found for %s.%n(Authors: %s)", item.getId(), item.getAuthors().toString());
                } else {
                    if (settings.isListAllAuthors() || !a.isMe()) {
                        authorLinks.add(a.getLinkedHtmlName());
                    }
                }
            }

            return formatNames(authorLinks);
        }
    }

    private void writeVolume(BibItem item, String connective) throws IOException {
        String volume = item.get("volume");
        String series = item.get("series");
        String number = item.get("number");

        if (volume != null && !volume.isEmpty()) {
            output("volume ", volume, "");
            output(" of <span class=\"series\">", series, "</span>");
            out.write(connective);
        } else if (number != null && !number.isEmpty()) {
            output("number ", number, "");
            output(" in <span class=\"series\">", series, "</span>");
            out.write(connective);
        } else {
            output("<span class=\"series\">", series, "</span>" + connective);
        }
    }

    protected void writeStatus(BibItem item, String booktitle) throws IOException {
        String title = booktitle;

        if (title.startsWith("Proceedings of ")) {
            title = title.substring("Proceedings of ".length());
        }

        out.write(indent);

        switch (item.get("status")) {
            case "submitted":
                output("Submitted to <span class=\"booktitle\">", title, "</span>.<br>", true);
                break;
            case "accepted":
                output("Accepted to <span class=\"booktitle\">", title, "</span>.<br>", true);
                break;
            case "acceptedrev":
                output("Accepted, pending minor revisions, to <span class=\"booktitle\">", title, "</span>.<br>", true);
                break;
            default:
                throw new AssertionError("Unrecognized status: \"" + item.get("status") + "\"");
        }
    }

    protected String formatPages(BibItem item, boolean verbose) {
        String pages = (verbose ? super.formatPages(item) : item.get("pages"));

        if (pages == null) {
            pages = "";
        }

        return pages.replaceAll("-+", "&ndash;");
    }

    private void writeLinks(BibItem item) throws IOException {
        if (includeBibtex(item)) {
            if (PublicationType.ACCEPTED.matches(item)) {
                writeLinks(item, true, false);
            } else if (item.anyNonEmpty("arxiv")) {
                writeLinks(item, false, true);
            } else {
                // Just in case.
                writeLinks(item, false, false);
            }
        } else {
            writeLinks(item, false, false);
        }
    }

    private void writeLinks(BibItem item, boolean includeBibtex, boolean includeArxivBibtex) throws IOException {
        // Paper link
        if (includePaper(item) && htmlSettings.getTitleTarget() != HTMLSettings.TitleLinkTarget.PAPER) {
            try {
                String link = (new URI(null, null, item.get("paper"), null)).toString();
                String text;

                // Use the extension as link text, or "Paper" if no extension is found
                int dot = link.lastIndexOf('.');

                if (dot != -1) {
                    text = link.substring(dot + 1);

                    // Convert *.ps.gz to ps
                    if ("gz".equals(text) && link.lastIndexOf('.', dot - 1) != -1) {
                        text = link.substring(link.lastIndexOf('.', dot - 1) + 1, dot);
                    }
                } else {
                    text = "Paper";
                }

                out.write(indent + "[<a href=\"" + link + "\">" + text + "</a>]");
                out.newLine();

                checkExistance(item.get("paper"), "paper", item);
            } catch (URISyntaxException ex) {
                Console.except(ex, "Paper link for entry \"%s\" is not formatted properly:", item.getId());
            }
        }

        // arXiv link
        if (item.anyNonEmpty("arxiv")) {
            out.write(indent + "[<a href=\"http://arxiv.org/abs/" + item.get("arxiv") + "\">arXiv</a>]");
            out.newLine();
        }

        // DOI link
        if (item.anyNonEmpty("doi")) {
            out.write(indent + "[<a href=\"http://dx.doi.org/" + item.get("doi") + "\">DOI</a>]");
            out.newLine();
        }

        // Other user-specified links
        writeCustomLink(item, -1); // link

        for (int i = 0; i < 20; i++) {
            writeCustomLink(item, i); // link<i>
        }

        // BibTeX link
        if (includeBibtex) {
            writeBibTeXHTML(item);
        } else if (includeArxivBibtex) {
            writeArXivBibTeXHTML(item);
        }
    }

    private void writeCustomLink(BibItem item, int i) throws IOException {
        String attribute = (i == -1 ? "link" : "link" + i);

        if (item.anyNonEmpty(attribute)) {
            String link = item.get(attribute);
            int divider = link.indexOf('|');

            if (divider == -1) {
                Console.error("No divider \"|\" found in %s of item \"%s\". Links should be formatted as%n  %s={<Link text>|<Link target>}", attribute, item.getId(), attribute);
            } else {
                String text = link.substring(0, divider);
                String target = link.substring(divider + 1);

                if (target.startsWith("#")) {
                    // Link to another paper, good as-is
                } else if (target.contains(":")) {
                    // Most file systems prohibit colons in file names, so
                    // it seems safe to assume that this indicates an
                    // absolute URI and as such, should be fine.
                } else {
                    // Most likely link to a file on disk. Encode correctly.
                    try {
                        target = (new URI(null, null, target, null)).toString();
                        checkExistance(target, attribute, item);
                    } catch (URISyntaxException ex) {
                        Console.except(ex, "Could not parse the target of %s of item \"%s\":", attribute, item.getId());
                    }
                }

                out.write(indent + "[<a href=\"" + target + "\">" + text + "</a>]");
                out.newLine();
            }
        }
    }

    private void writeBibTeXHTML(BibItem item) throws IOException {
        // Show / hide links
        writeToggleLink(item.getId() + "_bibtex", "BibTeX");

        // Actual bibtex
        out.write(indent + "<div id=\"" + item.getId() + "_bibtex\" class=\"collapsible\">");
        out.write("<pre class=\"bibtex\">");
        out.newLine();

        // Item type
        out.write("@" + item.getType() + "{" + item.getId() + ",");
        out.newLine();

        // The first field should omit the connecting ",".
        boolean first = true;

        // Get the proper format for authors
        if (item.anyNonEmpty("author")) {
            out.write("  author={");

            for (int i = 0; i < item.getAuthors().size(); i++) {
                out.write(item.getAuthors().get(i).getLatexName());

                if (i < item.getAuthors().size() - 1) {
                    out.write(" and ");
                }
            }

            out.write("}");

            first = false;
        }

        for (String field : item.getMandatoryFields()) {
            if (!field.equals("author")) {
                if (first) {
                    first = false;
                } else {
                    out.write(",");
                    out.newLine();
                }

                out.write("  " + field + "={" + item.get(field) + "}");
            }
        }

        for (String field : item.getOptionalFields()) {
            String v = item.get(field);

            if (!field.equals("author") && v != null && !v.isEmpty()) {
                if (first) {
                    first = false;
                } else {
                    out.write(",");
                    out.newLine();
                }

                out.write("  " + field + "={" + item.get(field) + "}");
            }
        }

        out.newLine(); // No comma after the last element
        out.write("}</pre></div>");
        out.newLine();
    }

    private void writeArXivBibTeXHTML(BibItem item) throws IOException {
        // Show / hide links
        writeToggleLink(item.getId() + "_bibtex", "BibTeX");

        // Actual bibtex
        out.write(indent + "<div id=\"" + item.getId() + "_bibtex\" class=\"collapsible\">");
        out.write("<pre class=\"bibtex\">");
        out.newLine();

        // Item type
        out.write("@article{" + item.getId() + ",");
        out.newLine();

        // The first field should omit the connecting ",".
        boolean first = true;

        // Get the proper format for authors
        if (item.anyNonEmpty("author")) {
            out.write("  author={");

            for (int i = 0; i < item.getAuthors().size(); i++) {
                out.write(item.getAuthors().get(i).getLatexName());

                if (i < item.getAuthors().size() - 1) {
                    out.write(" and ");
                }
            }

            out.write("}");

            first = false;
        }

        for (String field : new String[]{"title", "year"}) {
            if (first) {
                first = false;
            } else {
                out.write(",");
                out.newLine();
            }

            out.write("  " + field + "={" + item.get(field) + "}");
        }

        out.write(",");
        out.newLine();
        out.write("  journal={CoRR},");
        out.newLine();
        out.write("  volume={abs/" + item.get("arxiv") + "},");
        out.newLine();
        out.write("  ee={http://arxiv.org/abs/" + item.get("arxiv") + "}");

        out.newLine(); // No comma after the last element
        out.write("}</pre></div>");
        out.newLine();
    }

    private void writeToggleLink(String id, String linkText) throws IOException {
        // Mark as interactive so users with JS disabled do not see links that do nothing
        out.write(indent);
        out.write("<span class=\"interactive\">");

        // Link to reveal
        out.write("[<a href=\"javascript:toggle('" + id + "');\" id=\"" + id + "_plus\" class=\"shown\">");
        out.write(linkText);
        out.write("</a>");

        // Link to hide
        out.write("<a href=\"javascript:toggle('" + id + "');\" id=\"" + id + "_minus\" class=\"hidden\">");
        out.write("Hide " + linkText);
        out.write("</a>]");

        out.write("</span>");

        // Disabled link for users without JS
        out.write("<noscript><div>[");
        out.write(linkText);
        out.write("]</div></noscript>");
        out.newLine();
    }

    private boolean includeAbstract(BibItem item) {
        return item.anyNonEmpty("abstract") && htmlSettings.getIncludeAbstract().matches(item);
    }

    private boolean includeBibtex(BibItem item) {
        return htmlSettings.getIncludeBibtex().matches(item);
    }

    private boolean includePaper(BibItem item) {
        return item.anyNonEmpty("paper") && htmlSettings.getIncludePaper().matches(item);
    }

    private void checkExistance(String path, String attr, BibItem item) {
        Path file = settings.getTarget().resolveSibling(path);

        if (Files.notExists(file)) {
            Console.log("Warning: the file \"%s\" that is linked in attribute \"%s\" of publication \"%s\" cannot be found at \"%s\".", path, attr, item.getId(), file);
        }
    }
}
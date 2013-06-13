/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publistgenerator.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import publistgenerator.Console;
import publistgenerator.data.bibitem.Article;
import publistgenerator.data.bibitem.Author;
import publistgenerator.data.bibitem.BibItem;
import publistgenerator.data.bibitem.Book;
import publistgenerator.data.bibitem.InCollection;
import publistgenerator.data.bibitem.InProceedings;
import publistgenerator.data.bibitem.InvitedTalk;
import publistgenerator.data.bibitem.MastersThesis;
import publistgenerator.data.bibitem.PhDThesis;
import publistgenerator.data.bibitem.Unpublished;
import publistgenerator.data.settings.FormatSettings;

/**
 *
 * @author Sander Verdonschot <sander.verdonschot at gmail.com>
 */
public abstract class BibItemWriter {

    protected BufferedWriter out;
    protected FormatSettings settings;

    public BibItemWriter(BufferedWriter out, FormatSettings settings) {
        this.out = out;
        this.settings = settings;
    }

    public void write(BibItem item, int number) throws IOException {
        switch (item.getType()) {
            case "article":
                writeArticle((Article) item, number);
                break;
            case "book":
                writeBook((Book) item, number);
                break;
            case "inproceedings":
                writeInProceedings((InProceedings) item, number);
                break;
            case "mastersthesis":
                writeMastersThesis((MastersThesis) item, number);
                break;
            case "phdthesis":
                writePhDThesis((PhDThesis) item, number);
                break;
            case "incollection":
                writeInCollection((InCollection) item, number);
                break;
            case "talk":
                writeInvitedTalk((InvitedTalk) item, number);
                break;
            case "unpublished":
                writeUnpublished((Unpublished) item, number);
                break;
            default:
                throw new AssertionError("Unrecognized BibItem type: " + item.getType());
        }
    }

    protected abstract void writeArticle(Article item, int number) throws IOException;

    protected abstract void writeBook(Book item, int number) throws IOException;

    protected abstract void writeInProceedings(InProceedings item, int number) throws IOException;

    protected abstract void writeMastersThesis(MastersThesis item, int number) throws IOException;

    protected abstract void writePhDThesis(PhDThesis item, int number) throws IOException;

    protected abstract void writeInCollection(InCollection item, int number) throws IOException;

    protected abstract void writeInvitedTalk(InvitedTalk item, int number) throws IOException;

    protected abstract void writeUnpublished(Unpublished item, int number) throws IOException;

    protected String formatTitle(BibItem item) {
        String title = item.get("title");

        if (title == null || title.isEmpty()) {
            return "";
        } else {
            return changeCaseT(title);
        }
    }

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
                        authorLinks.add(a.getFormattedHtmlName());
                    }
                }
            }

            return formatNames(authorLinks);
        }
    }

    protected String formatNames(List<String> names) {
        StringBuilder result = new StringBuilder();

        if (!settings.isListAllAuthors()) {
            result.append("With ");
        }

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);

            if (i == 0) {
                // First author
                result.append(name);
            } else if (i < names.size() - 1) {
                // Middle author
                result.append(", ");
                result.append(name);
            } else {
                // Last author
                if (names.size() > 2) {
                    result.append(",");
                }

                if (name.equals("others")) {
                    result.append(" et~al.");
                } else {
                    result.append(" and ");
                    result.append(name);
                }
            }
        }

        return result.toString();
    }

    protected String formatPages(BibItem item) {
        String pages = item.get("pages");

        if (pages == null || pages.isEmpty()) {
            return "";
        } else {
            if (pages.contains("-") || pages.contains("+") || pages.contains(",")) {
                return "pages " + pages;
            } else {
                return "page " + pages;
            }
        }
    }

    protected String formatDate(BibItem item) {
        String year = item.get("year");
        String month = item.get("month");

        if (year == null || year.isEmpty()) {
            if (month == null || month.isEmpty()) {
                return "";
            } else {
                return month;
            }
        } else {
            if (month == null || month.isEmpty()) {
                return year;
            } else {
                return month + " " + year;
            }
        }
    }

    protected void output(String string) throws IOException {
        if (string != null) {
            out.write(string);
        }
    }

    protected void output(String string, String connective) throws IOException {
        output(string, connective, false);
    }

    protected void output(String string, String connective, boolean newLine) throws IOException {
        if (string != null && !string.isEmpty()) {
            out.write(string);
            out.write(connective);

            if (newLine) {
                out.newLine();
            }
        }
    }

    protected void output(String prefix, String string, String connective, boolean newLine) throws IOException {
        if (string != null && !string.isEmpty()) {
            out.write(prefix);
            out.write(string);
            out.write(connective);

            if (newLine) {
                out.newLine();
            }
        }
    }

    protected String convertToUnicode(String s) {
        StringBuilder sb = new StringBuilder();
        boolean command = false;

        for (char c : s.toCharArray()) {
            if (command) {
                // TODO
                
                command = false;
            } else {
                if (c == '\\') {
                    command = true;
                } else {
                    // TODO
                }
            }
            
            // FIXME
            sb.append(c);
        }

        return sb.toString();
    }

    protected String changeCaseT(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        boolean first = true;
        boolean escape = false;

        for (char c : s.toCharArray()) {
            if (escape) {
                sb.append(c);
                escape = false;
            } else {
                switch (c) {
                    case '{':
                        level++;
                        break;
                    case '}':
                        level--;
                        break;
                    case '\\':
                        if (level == 0) {
                            escape = true;
                        } else {
                            sb.append(c);
                        }
                        break;
                    default:
                        if (level == 0) {
                            if (first) {
                                sb.append(Character.toUpperCase(c));
                                first = false;
                            } else {
                                sb.append(Character.toLowerCase(c));
                            }
                        } else {
                            sb.append(c);
                            first = false;
                        }

                        break;
                }
            }
        }

        return sb.toString();
    }
}

/*
 * Copyright 2015 Sander Verdonschot <sander.verdonschot at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package publy.io.settings.legacy;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import publy.Console;
import publy.data.PublicationStatus;
import publy.data.category.OutputCategory;
import publy.data.category.conditions.Condition;
import publy.data.category.conditions.FieldCondition;
import publy.data.category.conditions.FieldContainsCondition;
import publy.data.category.conditions.FieldEqualsCondition;
import publy.data.category.conditions.FieldExistsCondition;
import publy.data.category.conditions.TypeCondition;
import publy.data.settings.GeneralSettings;
import publy.data.settings.HTMLSettings;
import publy.data.settings.Settings;
import publy.io.ResourceLocator;
import publy.io.settings.SettingsReader;

public class SettingsReaderV0_8 extends DefaultHandler implements SettingsReader {

    private enum State {

        DEFAULT,
        // Main settings
        FILE_SETTINGS, CATEGORY_SETTINGS, GENERAL_SETTINGS, HTML_SETTINGS, CONSOLE_SETTINGS;
    }

    private StringBuilder textBuffer; // Contains the characters that are read between start and end elements (e.g. <item>Text</item>)
    private final Settings settings; // Contains the read settings after parsing.
    private State state = State.DEFAULT;
    private OutputCategory currentCategory = null;
    private Condition currentCondition;
    private String activeCategories;

    public SettingsReaderV0_8() {
        this.settings = new Settings();
    }

    @Override
    public Settings parseSettings(Path inputFile) throws IOException {
        // Use the default (non-validating) parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // Create a new instance of this class as handler
        SettingsReaderV0_8 handler = new SettingsReaderV0_8();

        // Parse the input
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(inputFile.toFile(), handler);
        } catch (ParserConfigurationException | SAXException ex) {
            throw new IOException(ex);
        }

        return handler.settings;
    }

    @Override
    public void startElement(String namespaceURI, String sName, String qName, Attributes attrs) throws SAXException {
        switch (state) {
            case DEFAULT:
                defaultStartElement(qName);
                break;
            case CATEGORY_SETTINGS:
                categorySettingsStartElement(qName, attrs);
                break;
            default:
                break;
        }
    }

    private void defaultStartElement(String qName) {
        switch (qName) {
            case "fileSettings":
                state = State.FILE_SETTINGS;
                break;
            case "categorySettings":
                state = State.CATEGORY_SETTINGS;
                break;
            case "generalSettings":
                state = State.GENERAL_SETTINGS;
                break;
            case "htmlSettings":
                state = State.HTML_SETTINGS;
                break;
            case "consoleSettings":
                state = State.CONSOLE_SETTINGS;
                break;
            default:
                break;
        }
    }

    private void categorySettingsStartElement(String qName, Attributes attrs) {
        Condition newCondition = null;

        switch (qName) {
            // Start of a category
            case "category":
                currentCategory = new OutputCategory(null, null, null);
                break;

            // Conditions
            case "TypeCondition":
                newCondition = new TypeCondition(false, (String) null);
                break;
            case "FieldExistsCondition":
                newCondition = new FieldExistsCondition(false, null);
                break;
            case "FieldEqualsCondition":
                newCondition = new FieldEqualsCondition(false, null, (String) null);
                break;
            case "FieldContainsCondition":
                newCondition = new FieldContainsCondition(false, null, (String) null);
                break;
        }

        if (newCondition != null) {
            if (attrs.getValue("inverted") != null) {
                newCondition.setInverted(Boolean.parseBoolean(attrs.getValue("inverted")));
            }

            if (newCondition instanceof FieldCondition && attrs.getValue("field") != null) {
                ((FieldCondition) newCondition).setField(attrs.getValue("field"));
            }

            currentCondition = newCondition;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Handle the characters that were recorded between the tags
        String text = "";

        if (textBuffer != null) {
            text = textBuffer.toString().trim();
            textBuffer = null;
        }

        switch (state) {
            case FILE_SETTINGS:
                fileSettingsEndElement(qName, text);
                break;
            case CATEGORY_SETTINGS:
                categorySettingsEndElement(qName, text);
                break;
            case GENERAL_SETTINGS:
                generalSettingsEndElement(qName, text);
                break;
            case HTML_SETTINGS:
                htmlSettingsEndElement(qName, text);
                break;
            case CONSOLE_SETTINGS:
                consoleSettingsEndElement(qName, text);
                break;
            default:
                break;
        }
    }

    private void fileSettingsEndElement(String qName, String text) {
        switch (qName) {
            case "fileSettings":
                state = State.DEFAULT;
                break;
            // File settings
            case "publications":
                settings.getFileSettings().setPublications(Paths.get(text));
                break;
            case "target":
                settings.getFileSettings().setTarget(Paths.get(text));
                break;
            case "header":
                settings.getFileSettings().setHeader(Paths.get(text));
                break;
            case "footer":
                settings.getFileSettings().setFooter(Paths.get(text));
                break;
            default:
                Console.warn(Console.WarningType.OTHER, "Unrecognized tag in File settings: \"%s\".", qName);
                break;
        }
    }

    private void categorySettingsEndElement(String qName, String text) {
        switch (qName) {
            case "categorySettings":
                // Finalize active categories
                if (activeCategories != null && !activeCategories.isEmpty()) {
                    for (String index : activeCategories.split(";")) {
                        int i = Integer.parseInt(index);
                        OutputCategory c = settings.getCategorySettings().getAllCategories().get(i);
                        settings.getCategorySettings().activate(c);
                    }
                }

                state = State.DEFAULT;
                break;
            case "allCategories":
                // No action required
                break;

            // End of a category description
            case "category":
                settings.getCategorySettings().addCategory(currentCategory);
                currentCategory = null;
                break;

            // Per-category settings
            case "shortName":
                currentCategory.setShortName(text);
                break;
            case "name":
                currentCategory.setName(text);
                break;
            case "htmlNote":
                currentCategory.setHtmlNote(text);
                break;
            case "ignoredFields":
                currentCategory.setIgnoredFields(Arrays.asList(text.split(";")));
                break;

            // Conditions
            case "TypeCondition":
                ((TypeCondition) currentCondition).setTypes(text.split(";"));
                currentCategory.setTypeCondition((TypeCondition) currentCondition);
                break;
            case "fieldConditions":
                // No action required
                break;
            case "FieldExistsCondition":
                currentCategory.getFieldConditions().add((FieldCondition) currentCondition);
                break;
            case "FieldEqualsCondition":
                ((FieldEqualsCondition) currentCondition).setValues(text.split(";"));
                currentCategory.getFieldConditions().add((FieldCondition) currentCondition);
                break;
            case "FieldContainsCondition":
                ((FieldContainsCondition) currentCondition).setValues(text.split(";"));
                currentCategory.getFieldConditions().add((FieldCondition) currentCondition);
                break;

            // Active categories
            case "activeCategories":
                activeCategories = text; // To be finalized later. This ensures that the order of allCategories and activeCategories does not matter.
                break;

            default:
                Console.warn(Console.WarningType.OTHER, "Unrecognized tag in Category settings: \"%s\".", qName);
                break;
        }
    }

    private void generalSettingsEndElement(String qName, String text) {
        switch (qName) {
            case "generalSettings":
                state = State.DEFAULT;
                break;
            // General settings
            case "myNames":
                settings.getGeneralSettings().setMyNames(Arrays.asList(text.split(";")));
                break;
            case "nameDisplay":
                if ("ABBREVIATED".equals(text)) {
                    settings.getGeneralSettings().setNameDisplay(GeneralSettings.FirstNameDisplay.INITIAL);
                } else {
                    settings.getGeneralSettings().setNameDisplay(GeneralSettings.FirstNameDisplay.valueOf(text));
                }
                break;
            case "reverseNames":
                settings.getGeneralSettings().setReverseNames(Boolean.parseBoolean(text));
                break;
            case "listAllAuthors":
                settings.getGeneralSettings().setListAllAuthors(Boolean.parseBoolean(text));
                break;
            case "titleFirst":
                settings.getGeneralSettings().setTitleFirst(Boolean.parseBoolean(text));
                break;
            case "useNewLines":
                settings.getGeneralSettings().setUseNewLines(Boolean.parseBoolean(text));
                break;
            case "numbering":
                if (text != null) {
                    switch (text) {
                        case "NONE":
                            settings.getGeneralSettings().setNumbering(GeneralSettings.Numbering.NO_NUMBERS);
                            break;
                        case "LOCAL":
                            settings.getGeneralSettings().setNumbering(GeneralSettings.Numbering.WITHIN_CATEGORIES);
                            break;
                        default:
                            settings.getGeneralSettings().setNumbering(GeneralSettings.Numbering.valueOf(text));
                            break;
                    }
                }
                break;
            case "reverseNumbering":
                settings.getGeneralSettings().setReverseNumbering(Boolean.parseBoolean(text));
                break;
            default:
                Console.warn(Console.WarningType.OTHER, "Unrecognized tag in General settings: \"%s\".", qName);
                break;
        }
    }

    private void htmlSettingsEndElement(String qName, String text) {
        switch (qName) {
            case "htmlSettings":
                state = State.DEFAULT;
                break;
            // HTML-specific settings
            case "generateTextVersion":
                settings.getHtmlSettings().setGenerateTextVersion(Boolean.parseBoolean(text));
                break;
            case "generateBibtexVersion":
                settings.getHtmlSettings().setGenerateBibtexVersion(Boolean.parseBoolean(text));
                break;
            case "linkToAlternateVersions":
                settings.getHtmlSettings().setLinkToAlternateVersions(Boolean.parseBoolean(text));
                break;
            case "navPlacement":
                settings.getHtmlSettings().setNavPlacement(HTMLSettings.NavigationPlacement.valueOf(text));
                break;
            case "includeAbstract":
                settings.getHtmlSettings().setIncludeAbstract(PublicationStatus.valueOf(text));
                break;
            case "includeBibtex":
                settings.getHtmlSettings().setIncludeBibtex(PublicationStatus.valueOf(text));
                break;
            case "includePaper":
                settings.getHtmlSettings().setIncludePaper(PublicationStatus.valueOf(text));
                break;
            case "titleTarget":
                settings.getHtmlSettings().setTitleTarget(HTMLSettings.TitleLinkTarget.valueOf(text));
                break;
            case "presentedText":
                settings.getHtmlSettings().setPresentedText(text);
                break;
            case "googleAnalyticsUser":
                settings.getHtmlSettings().setGoogleAnalyticsUser(text);
                break;
            default:
                Console.warn(Console.WarningType.OTHER, "Unrecognized tag in HTML settings: \"%s\".", qName);
                break;
        }
    }

    private void consoleSettingsEndElement(String qName, String text) {
        switch (qName) {
            case "consoleSettings":
                state = State.DEFAULT;
                break;
            // Console settings
            case "showWarnings":
                settings.getConsoleSettings().setShowWarnings(Boolean.parseBoolean(text));
                break;
            case "warnMissingReferences":
                settings.getConsoleSettings().setWarnMissingReferences(Boolean.parseBoolean(text));
                break;
            case "warnNotAuthor":
                settings.getConsoleSettings().setWarnNotAuthor(Boolean.parseBoolean(text));
                break;
            case "warnNoCategoryForItem":
                settings.getConsoleSettings().setWarnNoCategoryForItem(Boolean.parseBoolean(text));
                break;
            case "warnMandatoryFieldIgnored":
                settings.getConsoleSettings().setWarnMandatoryFieldIgnored(Boolean.parseBoolean(text));
                break;
            case "showLogs":
                settings.getConsoleSettings().setShowLogs(Boolean.parseBoolean(text));
                break;
            case "showStackTraces":
                settings.getConsoleSettings().setShowStackTraces(Boolean.parseBoolean(text));
                break;
            default:
                Console.warn(Console.WarningType.OTHER, "Unrecognized tag in Console settings: \"%s\".", qName);
                break;
        }
    }

    @Override
    public void characters(char buf[], int offset, int len) throws SAXException {
        String s = new String(buf, offset, len);

        if (textBuffer == null) {
            textBuffer = new StringBuilder(s);
        } else {
            textBuffer.append(s);
        }
    }
}

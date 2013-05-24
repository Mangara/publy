/*
 */
package publistgenerator;

import java.awt.Color;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import publistgenerator.gui.ConsoleFrame;

/**
 *
 * @author Sander Verdonschot <sander.verdonschot at gmail.com>
 */
public class Console {

    private static final SimpleAttributeSet logAttributes;
    private static final SimpleAttributeSet errorAttributes;
    private static final boolean PRINT_STACKTRACE = true;
    private static JTextPane textPane = null; // A styled text area to log to, if the program was invoked without an attached console

    // Static font initialization
    static {
        // Simple black mono-spaced log font
        logAttributes = new SimpleAttributeSet();
        StyleConstants.setFontFamily(logAttributes, "Monospaced");
        StyleConstants.setFontSize(logAttributes, 12);

        // The same font, but red for errors
        errorAttributes = new SimpleAttributeSet(logAttributes);
        StyleConstants.setForeground(errorAttributes, Color.red);
    }

    public static void log(String format, Object... args) {
        if (textPane == null) {
            if (System.console() == null) {
                createConsoleFrame();
            } else {
                System.console().format(format + "%n", args);
                System.console().flush();
            }
        }

        // Re-check, because textPane might have been set by createConsoleFrame()
        if (textPane != null) {
            try {
                textPane.getDocument().insertString(textPane.getDocument().getLength(), String.format(format + "%n", args), logAttributes);
            } catch (BadLocationException ex) {
                // This should never happen
                throw new AssertionError(ex);
            }
        }
    }

    public static void error(String format, Object... args) {
        if (textPane == null) {
            if (System.console() == null) {
                createConsoleFrame();
            } else {
                System.console().format("ERROR: " + format + "%n", args);
                System.console().flush();
            }
        }

        // Re-check, because textPane might have been set by createConsoleFrame()
        if (textPane != null) {
            try {
                textPane.getDocument().insertString(textPane.getDocument().getLength(), String.format(format + "%n", args), errorAttributes);
            } catch (BadLocationException ex) {
                // This should never happen
                throw new AssertionError(ex);
            }
        }
    }

    public static void exception(Throwable exception, String format, Object... args) {
        if (textPane == null) {
            if (System.console() == null) {
                createConsoleFrame();
            } else {
                System.console().format("ERROR: " + format + "%n", args);

                if (PRINT_STACKTRACE) {
                    System.console().format("%s", exception.toString());
                    exception.printStackTrace(System.console().writer());
                }

                System.console().flush();
            }
        }

        // Re-check, because textPane might have been set by createConsoleFrame()
        if (textPane != null) {
            try {
                textPane.getDocument().insertString(textPane.getDocument().getLength(), String.format(format + "%n", args), errorAttributes);
                
                if (PRINT_STACKTRACE) {
                    textPane.getDocument().insertString(textPane.getDocument().getLength(), exception.toString(), errorAttributes);

                    // Extract the stack trace as a String
                    StringWriter stackTrace = new StringWriter();
                    exception.printStackTrace(new PrintWriter(stackTrace));
                    
                    textPane.getDocument().insertString(textPane.getDocument().getLength(), stackTrace.toString(), errorAttributes);
                }
            } catch (BadLocationException ex) {
                // This should never happen
                throw new AssertionError(ex);
            }
        }
    }

    public static void setOutputTarget(JTextPane textPane) {
        Console.textPane = textPane;
    }

    private static void createConsoleFrame() {
        ConsoleFrame consoleFrame = new ConsoleFrame();
        // The ConsoleFrame() constructor calls setOutputTarget()
        consoleFrame.setVisible(true);
    }
}
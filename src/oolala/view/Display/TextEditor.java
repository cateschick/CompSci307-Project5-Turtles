package oolala.view.Display;

import javafx.scene.layout.BorderPane;
import javafx.scene.web.HTMLEditor;
import oolala.model.Parser;
import oolala.model.ReadWrite;
import oolala.view.Error;
import oolala.view.View;

public class TextEditor extends Display {

  /**
   * Text editor containing user input.
   */
  private static HTMLEditor editor;

  /**
   * Number of files user has created this session.
   */
  private static int counter = 0;

  /**
   * Returns the current text file containing user input.
   *
   * @return An HTMLEditor with input.
   */
  public static HTMLEditor getEditor() {
    return editor;
  }

  /**
   * Creates a Text Editing interface for users to write files.
   *
   * @return a BorderPane with the Text Editor.
   */
  public static BorderPane createInputField() {
    if (parserCheck()) {
      Error.parserError();
      // Return main display instead of text editor until user selects a parser
      return MainDisplay.getDisplay();
    }

    BorderPane b = new BorderPane();
    editor = new HTMLEditor();
    editor.setPrefHeight(View.getSize()[1]);
    b.setCenter(editor);
    return b;
  }

  /**
   * When a user saves a file, this method converts the file
   * from HTML to plain text and communicates with the model
   * to save the file to the proper directory.
   *
   * @param h an HTML editor.
   */
  public static void handleSave(final HTMLEditor h) {
    if (parserCheck()) {
      Error.parserError();
      return;
    }

    String text = h.getHtmlText();
    String input = removeHTMLTags(text);
    ReadWrite.writeFile(Parser.getParser(), "userFile"
        + counter + ".txt", input);
    counter++;
  }

  /**
   * Converts from HTML to plain text.
   *
   * @param html an HTML-encoded String.
   * @return A plain text String.
   */
  private static String removeHTMLTags(final String html) {
    String formatted = html.replaceAll("<.*?>", " ");
    return formatted.trim();
  }

  /**
   * Checks if a user has selected a parser option yet.
   *
   * @return if myParser is null.
   */
  private static boolean parserCheck() {
    return Parser.getParser() == null;
  }
}

package oolala.view.Display;


import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import oolala.model.ReadWrite;
import oolala.view.ButtonColorPicker;
import oolala.model.Parser;
import oolala.view.Error;
import oolala.view.Pen;
import oolala.view.Turtle;

public class OpenFileDisplay extends Display {

  /**
   * Current items in navigation display.
   */
  private static VBox displayContent;

  /**
   * Creates a navigation display with parser options to choose from.
   *
   * @return A BorderPane showing current Parser options.
   */
  public static BorderPane createFileDisplay() {
    BorderPane fileDisplay = new BorderPane();
    displayContent = new VBox();

    Display.addDisplayTitle(displayContent, resources.getString("filePage"));
    addFileContent(fileDisplay);
    return fileDisplay;
  }

  /**
   * Adds initial openFile display content with buttons. for each Parser option.
   *
   * @param b the display being added to.
   */
  private static void addFileContent(final BorderPane b) {
    displayContent.getStyleClass().addAll("vbox", "open-file-vbox");

    Button lFiles =
        ButtonColorPicker.makeButton(resources.getString("LFiles"),
            event -> openFiles("lsystem"));
    Button logoFiles =
        ButtonColorPicker.makeButton(resources.getString("logoFiles"),
            event -> openFiles("logo"));
    Button darwinFiles =
        ButtonColorPicker.makeButton(resources.getString("darwinFiles"),
            event -> openFiles("darwin"));

    Button[] array = {lFiles, logoFiles, darwinFiles};
    iterateButtons(array, displayContent);

    b.setCenter(displayContent);
  }

  /**
   * Sets Parser and gets file options for that Parser.
   *
   * @param parser selected parser option
   */
  private static void openFiles(final String parser) {
    Parser.setParser(parser);
    // Clear display to show file options
    displayContent.getChildren().clear();

    // Access files in selected parser directory
    String[] files = ReadWrite.openFile(parser);
    for (String file : files) {

      // Create a button for each file that reads it
      Button b = ButtonColorPicker.makeButton(file,
          event -> readFile(parser, file));

      b.getStyleClass().add("application");
      displayContent.getChildren().add(b);
    }
  }

  /**
   * Tries to call readFile from ReadWrite on file, but
   * throws FileNotFoundException if file does
   * not exist.
   *
   * @param parser the Parser option selected.
   * @param file   the name of the file to be read.
   */
  private static void readFile(final String parser,
      final String file) {
    Display.switchDisplay(DrawingDisplay.setupDisplay());
    Turtle t = DrawingDisplay.getTurtle();
    Pen pen = DrawingDisplay.getPen();
    try {
      String[] commands = ReadWrite.readFile(parser, file);
      new Parser().runProgram(commands, t, pen);
    } catch (FileNotFoundException e) {
      Error.fileNotFound();
    }
  }
}

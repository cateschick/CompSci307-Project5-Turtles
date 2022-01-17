package oolala.view;

import javafx.scene.control.Alert;

public final class Error {

  /**
   * Private constuctor for public utility class.
   */
  private Error() {
  }

  /**
   * Message when unrecognized command is found.
   */
  private static final String COMMANDERROR =
      "Unsupported command found. Please check the "
          + "selected file for syntax errors.";
  /**
   * Message when no parser is selected.
   */
  private static final String PARSERERROR =
      "Please select a Parser option before "
          + "writing or saving files.";
  /**
   * Message when no file is found.
   */
  private static final String NOFILEFOUND =
      "No file found.";

  /**
   * This method displays an error message to the user,
   * alerting them that the selected file
   * contains commands unsupported by the application.
   */
  public static void showError() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("ERROR: Invalid Command");
    alert.setContentText(COMMANDERROR);
    alert.showAndWait();
  }

  /**
   * This method displays an error message to the user
   * if they attempt to save or write a file
   * before any parser method is selected.
   */
  public static void parserError() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("ERROR: No Parser Selected");
    alert.setContentText(PARSERERROR);
    alert.showAndWait();
  }

  /**
   * This method displays an error message to the user
   * if they try to access a file that cannot be
   * found.
   */
  public static void fileNotFound() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("ERROR: No File Found.");
    alert.setContentText(NOFILEFOUND);
    alert.showAndWait();
  }
}

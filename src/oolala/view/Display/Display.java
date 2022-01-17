package oolala.view.Display;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import java.util.ResourceBundle;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import oolala.view.Resources;
import oolala.view.View;

public class Display {

  /**
   * Beginning of substring index containing hex code for
   * background color.
   */
  private static final int SUBSTART = 2;
  /**
   * End of substring index containing hex code for background color.
   */
  private static final int SUBEND = 8;
  /**
   * Access resources from proper resource file.
   */
  protected static ResourceBundle resources =
      Resources.getResources(Resources.getPath());

  /**
   * Protected constructor for public Display class.
   */
  protected Display() {
  }

  /**
   * Updates resource file path for all displays when language is changed.
   */
  public static void updateResources() {
    resources = Resources.getResources(Resources.getPath());
  }

  /**
   * Updates the display when interacting with application and
   * switching between several existing
   * displays.
   *
   * @param display Desired display to switch to.
   */
  public static void switchDisplay(final BorderPane display) {
    View.getRoot().setCenter(display);
  }

  /**
   * Clears the screen for a new drawing.
   *
   * @param display Display screen to be cleared.
   */
  public static void clearScreen(final BorderPane display) {
    display.getChildren().clear();
    MainDisplay.setDisplay(display);
  }

  /**
   * Change color of a display background to desired color.
   *
   * @param c the color the background will be changed to.
   */
  public static void changeBackgroundColor(final Color c) {
    String substring = c.toString().substring(SUBSTART, SUBEND);
    View.getRoot().setStyle(
        String.format("-fx-background-color: #%s;", substring));
  }

  /**
   * Adds a Title to a display.
   *
   * @param v VBox containing display content.
   * @param s String containing the text of the Title
   */
  protected static void addDisplayTitle(
      final VBox v, final String s) {
    Label displayTitle = new Label(s);
    displayTitle.getStyleClass().add("title");
    v.getChildren().add(displayTitle);
  }

  /**
   * Iterates through a set of Buttons, adds them
   * to desired VBox, and sets their style to
   * match those of all display buttons in
   * application.
   * @param array An array of buttons to be added.
   * @param v a VBox where the buttons are added to.
   */
  public static void iterateButtons(
      final Button[] array, final VBox v) {
    for (Button b : array) {
      v.getChildren().add(b);
      b.getStyleClass().add("application");
    }
  }
}

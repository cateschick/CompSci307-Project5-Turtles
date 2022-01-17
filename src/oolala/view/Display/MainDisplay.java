package oolala.view.Display;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import oolala.model.Parser;
import oolala.view.ButtonColorPicker;

public class MainDisplay extends Display {

  /**
   * Main display.
   */
  private static BorderPane myDisplay;

  /**
   * Returns myDisplay private variable.
   *
   * @return myDisplay, the main display screen.
   */
  public static BorderPane getDisplay() {
    return myDisplay;
  }


  /**
   * Sets a desired BorderPane as the main display.
   *
   * @param g the BorderPane to be set as myDisplay.
   */
  public static void setDisplay(final BorderPane g) {
    myDisplay = g;
  }

  /**
   * Creates the intro display with a welcome message and option
   * to choose parser.
   *
   * @return The main display.
   */
  public static BorderPane createMainDisplay() {
    VBox v = new VBox();
    v.getStyleClass().addAll("main-display", "display");

    myDisplay = new BorderPane();

    Display.addDisplayTitle(v, resources.getString("Hello"));
    v.getChildren().add(
        new Text(resources.getString("IntroMessage")));

    mainDisplayButtons(v);
    myDisplay.setCenter(v);
    return myDisplay;
  }

  /**
   * Creates buttons for main Display.
   *
   * @param v VBox buttons are being added to.
   */
  protected static void mainDisplayButtons(final VBox v) {
    String[] names = {"L", "Logo", "Darwin"};

    for (String name : names) {
      Button b = ButtonColorPicker.makeButton(resources.getString(name),
          event -> handleButtons(name));
      v.getChildren().add(b);
      b.getStyleClass().add("application");
    }
  }

  /**
   * This method sets the Parser equal to the selected parser language.
   *
   * @param name the selected language.
   */
  private static void handleButtons(final String name) {
    Parser.setParser(name);
    Display.switchDisplay(DrawingDisplay.setupDisplay());
  }
}

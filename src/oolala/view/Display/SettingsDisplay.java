package oolala.view.Display;

import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import oolala.view.ButtonColorPicker;
import oolala.view.Pen;
import oolala.view.Turtle;

public class SettingsDisplay extends Display {

  /**
   * Creates a BorderPane with the design settings.
   *
   * @return The design settings display.
   */
  public static BorderPane createDesignSettings() {
    BorderPane mySettings = new BorderPane();

    VBox v = new VBox();
    v.getStyleClass().addAll("vbox", "settings-vbox");

    Display.addDisplayTitle(v, resources.getString("DesignSettings"));

    makeSettingsContent(v);

    mySettings.setCenter(v);
    return mySettings;
  }

  /**
   * Creates the ColorPickers needed for design settings.
   *
   * @param v the VBox that the ColorPickers are a
   *          dded to within the design settings display.
   */
  private static void makeSettingsContent(final VBox v) {
    // Pen Color
    v.getChildren().add(new Text(resources.getString("PenColor")));
    ColorPicker pen = ButtonColorPicker.makeColorPicker();
    pen.setOnAction(
        event -> Pen.setPenColor(pen.getValue()));
    v.getChildren().add(pen);

    // Turtle Color
    v.getChildren().add(new Text(resources.getString("TurtleColor")));
    ColorPicker turtle = ButtonColorPicker.makeColorPicker();
    turtle.setOnAction(
        event -> Turtle.setColor(turtle.getValue()));
    v.getChildren().add(turtle);

    // Background Color
    v.getChildren().add(new Text(resources.getString("BackgroundColor")));
    ColorPicker display = ButtonColorPicker.makeColorPicker();
    display.setOnAction(
        event -> Display.changeBackgroundColor(display.getValue()));
    v.getChildren().add(display);
  }
}

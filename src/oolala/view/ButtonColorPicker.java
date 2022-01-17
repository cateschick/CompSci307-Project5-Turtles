package oolala.view;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;

public final class ButtonColorPicker {

  /**
   * Private constructor for public utility class.
   */
  private ButtonColorPicker() {
  }

  /**
   * Creates a javaFx Button.
   *
   * @param label the name of the Button.
   * @param handler what happens when the Button is pressed.
   * @return New Button.
   */
  public static Button makeButton(final String label,
      final EventHandler<ActionEvent> handler) {
    Button result = new Button();
    result.setText(label);
    result.setOnAction(handler);
    return result;
  }

  /**
   * Creates a new ColorPicker to be added to the display.
   *
   * @return A new ColorPicker.
   */
  public static ColorPicker makeColorPicker() {
    ColorPicker c = new ColorPicker();
    c.getStyleClass().add("application");
    return new ColorPicker();
  }
}

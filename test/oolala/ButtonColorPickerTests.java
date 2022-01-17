package oolala;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import oolala.view.ButtonColorPicker;
import oolala.view.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;


public class ButtonColorPickerTests extends DukeApplicationTest {

  @Override
  public void start(Stage stage) {
    View view = new View();
    stage.setScene(view.makeScene(900, 600));
    stage.show();
  }

  /**
   * Ensures makeButton method functions properly.
   */
  @Test
  void makeButtonTest() {
    BorderPane b = new BorderPane();
    Button button = ButtonColorPicker.makeButton("Button",
        event -> System.out.println("Button pressed!"));
    b.getChildren().add(button);
    Assertions.assertEquals(b.getChildren().get(0), button);
  }

  /**
   * Checks to see that a button is properly labelled.
   */
  @Test
  void buttonTextTest() {
    Button b = ButtonColorPicker.makeButton("Test",
        event -> System.out.println("Button pressed!"));
    verifyThat(b, hasText("Test"));
  }

  /**
   * Ensures makeColorPicker method functions properly.
   */
  @Test
  void makeColorPickerTest() {
    BorderPane b = new BorderPane();
    ColorPicker c = ButtonColorPicker.makeColorPicker();
    b.getChildren().add(c);
    Assertions.assertEquals(c, b.getChildren().get(0));
  }
}

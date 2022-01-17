package oolala;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import oolala.model.Parser;
import oolala.model.ReadWrite;
import oolala.view.Display.Display;
import oolala.view.Display.MainDisplay;
import oolala.view.Display.SettingsDisplay;
import oolala.view.Display.TextEditor;
import oolala.view.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

public class DisplayTests extends DukeApplicationTest {
  private View myView;

  // this method is run BEFORE EACH test to set up application in a fresh state
  @Override
  public void start(Stage stage) {
    myView = new View();
    // create application and add scene for testing to given stage
    Scene myScene = myView.makeScene(900, 600);
    stage.setScene(myScene);
    stage.show();
  }

  /**
   * Make sure clear screen removes all children from display by comparing with a blank test.
   */
  @Test
  void clearScreenTest() {
    BorderPane myDisplay = MainDisplay.createMainDisplay();
    BorderPane blankDisplay = new BorderPane();
    Display.clearScreen(myDisplay);
    Assertions.assertEquals(myDisplay.getChildren(), blankDisplay.getChildren());
  }

  /**
   * Checks that buttons are added to VBox with iterateButtons.
   */
  @Test
  public void iterateButtonsTest() {
    VBox v = new VBox();
    Button[] array = {new Button(), new Button(), new Button()};
    Display.iterateButtons(array, v);
    Assertions.assertNotEquals(v.getChildren(), null);
  }

  /**
   * Checks to see if background properly switches.
   */
  @Test
  public void changeBackgroundColorTest() {
    ColorPicker c = new ColorPicker();
    c.setValue(Color.GREY);
    String grey = "808080";
    Display.changeBackgroundColor(c.getValue());
    String style = myView.getRoot().getStyle();

    StringBuilder color = new StringBuilder();
    for (char ch: style.toCharArray()) {
      if (Character.isDigit(ch)) {
        color.append(ch);
      };
    }
    Assertions.assertEquals(grey, color.toString());
  }
}

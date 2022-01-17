package oolala;

import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oolala.view.Resources;
import oolala.view.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

public class ResourcesTests extends DukeApplicationTest {
  private View myView;
  private String myPath;

  @Override
  public void start(Stage stage) {
    myView = new View();
    myPath = Resources.getPath();
    // create application and add scene for testing to given stage
    Scene myScene = myView.makeScene(900, 600);
    stage.setScene(myScene);
    stage.show();
  }

  /**
   * Ensure default file path is being correctly retrieved.
   */
  @Test
  void getPathTest() {
    Assertions.assertEquals(Resources.getPath(), myPath);
  }

  /**
   * Ensures proper labels are retrieved from ENGLISH resource file.
   */
  @Test
  void getResourcesTestEnglish() {
    ResourceBundle resources = Resources.getResources("resources.english");
    Assertions.assertEquals("Home", resources.getString("Home"));
  }

  /**
   * Ensures proper labels are retrieved from SPANISH resource file.
   */
  @Test
  void getResourcesTestSpanish() {
    ResourceBundle resources = Resources.getResources("resources.spanish");
    Assertions.assertEquals("Hogar", resources.getString("Home"));
  }

  /**
   * Ensures proper labels are retrieved from DANISH resource file.
   */
  @Test
  void getResourcesTestDanish() {
    ResourceBundle resources = Resources.getResources("resources.danish");
    Assertions.assertEquals("Hjem", resources.getString("Home"));
  }

  /**
   * Ensures proper labels are retrieved from GERMAN resource file.
   */
  @Test
  void getResourcesTestGerman() {
    ResourceBundle resources = Resources.getResources("resources.german");
    Assertions.assertEquals("Zuhause", resources.getString("Home"));
  }

  /**
   * Checks setPath to ensure language path is properly switching
   */
  @Test
  void setPathTest() {
    // Switch from English to Danish
    myView.makeScene(900, 600);
    Resources.setPath("resources.danish");
    Assertions.assertEquals("resources.danish", Resources.getPath());
  }

  /**
   * Checks setPath to ensure language path is properly switching
   */
  @Test
  void setPathTest2() {
    // Switch to Spanish
    View view = new View();
    view.makeScene(900, 600);
    Resources.setPath("resources.spanish");
    Assertions.assertEquals("resources.spanish", Resources.getPath());
  }

}

package oolala.view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import oolala.view.Display.MainDisplay;

public class View {

  /**
   * Width of application.
   */
  private static int width;
  /**
   * Height of application.
   */
  private static int height;
  /**
   * Root node in main display.
   */
  private static BorderPane root;

  /**
   * Returns the measurements of the display.
   *
   * @return int[] of width and height.
   */
  public static int[] getSize() {
    return new int[]{width, height};
  }

  /**
   * Sets instance variables of width and height equal to display measurements.
   *
   * @param w the width of the display.
   * @param h the height of the display.
   */
  private static void setSize(final int w, final int h) {
    width = w;
    height = h;
  }

  /**
   * Returns the root node for other methods to access.
   *
   * @return root.
   */
  public static BorderPane getRoot() {
    return root;
  }

  /**
   * Sets the scene with Main display.
   *
   * @param w the width of the application.
   * @param h the height of the application.
   * @return Scene with main display contents.
   */
  public Scene makeScene(final int w, final int h) {
    setSize(width, height);

    root = new BorderPane();
    root.setTop(Toolbar.makeToolbar());
    root.setCenter(MainDisplay.createMainDisplay());
    // create scene to hold UI
    Scene myScene = new Scene(root, w, h);
    myScene.getStylesheets().add("resources/style.css");

    return myScene;
  }
}

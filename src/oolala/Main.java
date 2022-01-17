/*
  Contains source code for the application.
 */
package oolala;

import javafx.application.Application;
import javafx.stage.Stage;
import oolala.view.View;
import java.awt.Dimension;

/**
 * Feel free to completely change this code or delete it entirely.
 */

public final class Main extends Application {

  /**
   * Set Title.
   */
  private static final String TITLE = "OOLALA: Team 18";
  /**
   * Set Dimensions of application.
   */
  private static final Dimension DEFAULT_SIZE = new Dimension(900, 600);

  /**
   * Starts the application by building a view object and setting the Scene.
   * @param stage the stage being set.
   */
  @Override
  public void start(final Stage stage) {
    // Create model and view
    View view = new View();

    stage.setTitle(TITLE);
    // Show GUI
    stage.setScene(view.makeScene(DEFAULT_SIZE.width, DEFAULT_SIZE.height));

    stage.show();
  }

}


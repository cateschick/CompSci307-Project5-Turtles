package oolala.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Pen {

  /**
   * Color of Pen.
   */
  private static Color myColor;
  /**
   * Whether pen is up or down.
   */
  private boolean penDown;
  /**
   * If drawing is enabled.
   */
  private boolean draw;


  /**
   * Pen constructor with default color and penDown set to true
   */
  public Pen() {
    myColor = Color.BLACK;
    penDown = true;
  }

  /**
   *
   * @return penDown attribute of pen object
   */
  public boolean getPenDown() {
    return penDown;
  }

  /**
   * sets boolean attribute penDown to value of pd
   * @param pd
   */
  public void setPenDown(boolean pd) {
    penDown = pd;
  }

  /**
   * Retrieves information about the pen.
   *
   * @return Pen object.
   */
  public Pen getPen() {
    return this;
  }

  /**
   * Draws a line from two specified points.
   *
   * @param startX the starting x-coordinate.
   * @param startY the starting y-coordinate.
   * @param endX   the ending x-coordinate.
   * @param endY   the ending y-coordinate.
   */
  public static void draw(final double startX,
      final double startY, final double endX, final double endY) {
    Line line = new Line(startX, startY, endX, endY);
    line.setFill(myColor);
  }

  /**
   * Changes the color of the pen to desired color.
   *
   * @param c The new pen color.
   */
  public static void setPenColor(final Color c) {
    myColor = c;
  }
}

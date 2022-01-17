package oolala.view.Display;

import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import oolala.view.Pen;
import oolala.view.Turtle;
import oolala.view.View;

public class DrawingDisplay extends Display {

  /**
   * Current drawing.
   */
  private static BorderPane myDrawing;
  /**
   * Current Turtle object.
   */
  private static Turtle myTurtle;
  /**
   * Current Pen object.
   */
  private static Pen myPen;

  /**
   * Returns turtle object.
   * @return current Turtle object.
   */
  public static Turtle getTurtle() {
    return myTurtle;
  }

  /**
   * Returns pen object.
   * @return current Pen object.
   */
  public static Pen getPen() {
    return myPen;
  }

  /**
   * Returns the current drawing on the screen.
   *
   * @return myDrawing or a new BorderPane.
   */
  public static BorderPane getDrawing() {
    if (myDrawing != null) {
      return myDrawing;
    }
    myDrawing = new BorderPane();
    return setupDisplay();
  }

  /**
   * Sets up a display for the Turtle to take in instructions.
   *
   * @return a BorderPane showing the Turtle.
   */
  public static BorderPane setupDisplay() {
    myDrawing = new BorderPane();
    // Put turtle in center of screen
    final int[] size = View.getSize();
    final float width = size[0];
    final float height = size[1];
    myTurtle = new Turtle();
    myPen = new Pen();

    myDrawing.getStyleClass().add("display");
    placeTurtle(myDrawing, width, height);
    return myDrawing;
  }

  /**
   * Sets up the drawing display with the Turtle placed in
   * the center of the screen.
   *
   * @param b the BorderPane display the Turtle is displayed on.
   * @param w the width of the screen.
   * @param h the height of the screen.
   */
  private static void placeTurtle(final BorderPane b,
      final float w, final float h) {
    Turtle t = new Turtle();
    t.setX(w / 2);
    t.setY(h / 2);
    b.setCenter(Turtle.drawTurtle());
  }

  /**
   * Leaves a stamp of turtle outline.
   *
   * @param x x-value of stamp center.
   * @param y y-value of stamp center.
   */
  public static void drawStamp(final double x, final double y) {
    Circle stamp = new Circle(Turtle.getTurtleSize());
    stamp.setCenterX(x);
    stamp.setCenterY(y);
  }
}

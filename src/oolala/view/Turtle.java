package oolala.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import oolala.view.Display.DrawingDisplay;

public final class Turtle {

  /**
   * Turtle constructor.
   */
  public Turtle() {
    drawTurtle();
  }

  /**
   * Turtle x-coordinate.
   */
  private double myX;
  /**
   * Turtle y-coordinate.
   */
  private double myY;
  /**
   * Turtle angle.
   */
  private double myAngle;

  /**
   * Turtle temp color (can be clear).
   */
  private static Color myColor = Color.BLACK;
  /**
   * Permanent Turtle Color storage.
   */
  private static Color myPermaColor = Color.BLACK;
  /**
   * Default Turtle size.
   */
  private static final int TURTLESIZE = 15;

  /**
   * This method draws a Turtle and centers it.
   *
   * @return Circle representing a turtle.
   */
  public static Circle drawTurtle() {
    return new Circle(TURTLESIZE, myPermaColor);
  }

  /**
   * Returns the set turtle size.
   *
   * @return int Turtle size.
   */
  public static int getTurtleSize() {
    return TURTLESIZE;
  }

  /**
   * Returns the Turtle object.
   *
   * @return Turtle.
   */
  public Turtle getTurtle() {
    return this;
  }

  /**
   * Sets the Turtle's x-coordinate to given value.
   *
   * @param x new x-coordinate.
   */
  public void setX(final double x) {
    myX = x;
  }

  /**
   * Returns Turtle's x-value.
   *
   * @return x-value.
   */
  public double getX() {
    return myX;
  }

  /**
   * Sets Turtle's y-value to desired coordinate.
   *
   * @param y new y-value.
   */
  public void setY(final double y) {
    myY = y;
  }

  /**
   * Returns Turtle's y-coordinate.
   *
   * @return y-value.
   */
  public double getY() {
    return myY;
  }

  /**
   * Set's the Turtle's rotation to desired angle.
   *
   * @param a angle of rotation.
   */
  public void setAngle(final double a) {
    myAngle = a;
  }

  /**
   * Returns the Turtle's angle.
   *
   * @return angle
   */
  public double getAngle() {
    return myAngle;
  }

  /**
   * This method sets the Turtle color to a desired color and redraws the Turtle on a specified
   * display.
   *
   * @param c The desired color setting.
   */
  public static void setColor(final Color c) {
    // Avoid hide turtle command with transparent Color
    if (!c.equals(Color.TRANSPARENT)) {
      DrawingDisplay.getDrawing().getChildren().clear();
      myPermaColor = c;
    }
    myColor = c;
  }

  /**
   * sets Turtle's myColor to Color input
   * @param c
   */
  public void editTurtleColor(Color c) {
    myColor = c;
  }

  /**
   * This method returns the current Turtle color.
   *
   * @return the current Turtle color.
   */
  public Color getColor() {
    return myColor;
  }

  public Color getPermaColor() {return myPermaColor;}

}

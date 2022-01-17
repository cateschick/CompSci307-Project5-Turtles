package oolala.model.commands.logocommands;

import java.util.ArrayList;
import javafx.scene.shape.Circle;
import oolala.view.Pen;
import oolala.model.commands.LogoCommand;
import oolala.view.Turtle;

public class Back extends LogoCommand {

  public Back(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);
  }

  /**
   * moves Turtle backwards by specified number of pixels
   * @param commandParams
   * @param t
   * @param p
   */
  @Override
  public void commandFunc(ArrayList commandParams, Turtle t, Pen p) {
    super.commandFunc(commandParams, t, p);
    pixels = -1 * Integer.parseInt((String) commandParams.get(0));
    double currentX = t.getX();
    double currentY = t.getY();
    double angle = t.getAngle();
    move(p, t, currentX, currentY, angle, pixels);
  }
}

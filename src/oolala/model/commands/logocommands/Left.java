package oolala.model.commands.logocommands;

import java.util.ArrayList;
import javafx.scene.shape.Circle;
import oolala.view.Pen;
import oolala.model.commands.LogoCommand;
import oolala.view.Turtle;

public class Left extends LogoCommand {

  public Left(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);
  }

  /**
   * shifts turtle's orientation left by specified number of degrees
   * @param commandParams
   * @param t
   * @param p
   */
  @Override
  public void commandFunc(ArrayList commandParams, Turtle t, Pen p) {
    super.commandFunc(commandParams, t, p);
    degrees = -1 * Integer.parseInt((String) commandParams.get(0));
    t.setAngle(degrees + t.getAngle());
  }
}

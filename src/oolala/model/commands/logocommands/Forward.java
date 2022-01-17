package oolala.model.commands.logocommands;

import java.util.ArrayList;
import oolala.view.Pen;
import oolala.model.commands.LogoCommand;
import oolala.view.Turtle;

public class Forward extends LogoCommand {

  public Forward(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);
  }

  /**
   * moves turtle forward by specified number of pixels
   * @param commandParams
   * @param t
   * @param p
   */
  @Override
  public void commandFunc(ArrayList commandParams, Turtle t, Pen p) {
    super.commandFunc(commandParams, t, p);
    pixels = Integer.parseInt((String) commandParams.get(0));
    double currentX = t.getX();
    double currentY = t.getY();
    move(p, t, currentX, currentX, currentY, pixels);
  }

}

package oolala.model.commands.logocommands;

import java.util.ArrayList;
import oolala.model.commands.LogoCommand;
import oolala.view.Display.DrawingDisplay;
import oolala.view.Pen;
import oolala.view.Turtle;

public class Stamp extends LogoCommand {

  public Stamp(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);
  }

  /**
   * stamps turtle's image at its current x and y coordinates
   * @param commandParams
   * @param t
   * @param p
   */
  @Override
  public void commandFunc(ArrayList commandParams, Turtle t, Pen p) {
    super.commandFunc(commandParams, t, p);
    double currentX = t.getX();
    double currentY = t.getY();
    DrawingDisplay.drawStamp(currentX, currentY);
  }
}

package oolala.model.commands.logocommands;

import java.util.ArrayList;
import oolala.model.commands.LogoCommand;
import oolala.view.Pen;
import oolala.view.Turtle;

public class PenDown extends LogoCommand {

  public PenDown(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);
  }

  /**
   * changes penDown attribute of pen object to true so that turtle will be drawing
   * @param commandParams
   * @param t
   * @param p
   */
  @Override
  public void commandFunc(ArrayList commandParams, Turtle t, Pen p) {
    super.commandFunc(commandParams, t, p);
    p.setPenDown(true);
  }


}

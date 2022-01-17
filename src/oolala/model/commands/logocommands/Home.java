package oolala.model.commands.logocommands;

import java.util.ArrayList;
import oolala.view.Pen;
import oolala.model.commands.LogoCommand;
import oolala.view.Turtle;

public class Home extends LogoCommand {

  public Home(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);
  }

  /**
   * places turtle back in home position
   * @param commandParams
   * @param t
   * @param p
   */
  @Override
  public void commandFunc(ArrayList commandParams, Turtle t, Pen p) {
    super.commandFunc(commandParams, t, p);
    t.setX(0);
    t.setY(0);
  }
}

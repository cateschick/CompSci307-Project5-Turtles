package oolala.model.commands.logocommands;

import java.util.ArrayList;
import oolala.view.Pen;
import oolala.model.commands.LogoCommand;
import oolala.view.Turtle;

public class ShowTurtle extends LogoCommand {

  public ShowTurtle(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);
  }

  /**
   * Sets turtle's color to the color chosen by user (myPermaColor)
   * @param commandParams
   * @param t
   * @param p
   */
  @Override
  public void commandFunc(ArrayList commandParams, Turtle t, Pen p) {
    super.commandFunc(commandParams, t, p);
    t.setColor(t.getPermaColor());
  }
}

package oolala.model.Parsers;

import java.util.ArrayList;
import oolala.model.Parser;
import oolala.model.commands.Command;
import oolala.model.commands.logocommands.Back;
import oolala.model.commands.logocommands.Forward;
import oolala.model.commands.logocommands.HideTurtle;
import oolala.model.commands.logocommands.Home;
import oolala.model.commands.logocommands.Left;
import oolala.model.commands.logocommands.PenDown;
import oolala.model.commands.logocommands.PenUp;
import oolala.model.commands.logocommands.Right;
import oolala.model.commands.logocommands.ShowTurtle;
import oolala.model.commands.logocommands.Stamp;
import oolala.model.commands.logocommands.Tell;
import oolala.view.Error;
import oolala.view.Pen;
import oolala.view.Turtle;

public class LogoParser extends Parser {

  /**
   * Overridden from superclass in Parser to identify commands in Logo language
   * @param insn
   * @param paramList
   * @param t
   * @param p
   * @return Command object from logocommands package
   */
  @Override
  public Command getCommand(String insn, ArrayList paramList, Turtle t, Pen p) {
    super.getCommand(insn, paramList, t, p);
    if (insn.equals("fd")) {
      return new Forward(paramList, t, p);
    }
    else if (insn.equals("bk")) {
      return new Back(paramList, t, p);
    }
    else if (insn.equals("lt")) {
      return new Left(paramList, t, p);
    }
    else if (insn.equals("rt")) {
      return new Right(paramList, t, p);
    }
    else if (insn.equals("pd")) {
      return new PenDown(paramList, t, p);
    }
    else if (insn.equals("pu")) {
      return new PenUp(paramList, t, p);
    }
    else if (insn.equals("st")) {
      return new ShowTurtle(paramList, t, p);
    }
    else if (insn.equals("ht")) {
      return new HideTurtle(paramList, t, p);
    }
    else if (insn.equals("home")) {
      return new Home(paramList, t, p);
    }
    else if (insn.equals("stamp")) {
      return new Stamp(paramList, t, p);
    }
    else if (insn.equals("tell")) {
      return new Tell(paramList, t, p);
    }
    else {
      Error.showError();
      throw new IllegalArgumentException("Sorry, this command is not found in Logo Programming IDE Language.");
    }
  }
}

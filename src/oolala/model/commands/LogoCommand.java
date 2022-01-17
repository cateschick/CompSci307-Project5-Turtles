package oolala.model.commands;

import java.util.ArrayList;
import oolala.view.Pen;
import oolala.view.Turtle;


public class LogoCommand extends Command {
  protected int pixels;
  protected int degrees;


  public LogoCommand(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);

  }

}

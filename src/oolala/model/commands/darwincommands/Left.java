package oolala.model.commands.darwincommands;

import java.util.ArrayList;
import oolala.model.commands.DarwinCommand;
import oolala.view.Pen;
import oolala.view.Turtle;

public class Left extends DarwinCommand {

  public Left(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);
  }
}
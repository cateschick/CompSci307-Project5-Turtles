package oolala.model.commands.darwincommands;

import java.util.ArrayList;
import oolala.model.Parsers.DarwinParser;
import oolala.model.commands.DarwinCommand;
import oolala.view.Pen;
import oolala.view.Turtle;

public class Move extends DarwinCommand {


  public Move(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);
  }
}

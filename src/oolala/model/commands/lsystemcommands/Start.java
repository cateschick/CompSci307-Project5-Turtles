package oolala.model.commands.lsystemcommands;

import java.util.ArrayList;
import oolala.model.commands.LSysCommand;
import oolala.view.Pen;
import oolala.view.Turtle;

public class Start extends LSysCommand {

  public Start(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);
  }

  @Override
  public void commandFunc(ArrayList commandParams, Turtle t, Pen p) {
    super.commandFunc(commandParams, t, p);

  }
}

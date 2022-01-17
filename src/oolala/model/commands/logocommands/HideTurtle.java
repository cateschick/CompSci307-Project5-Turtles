package oolala.model.commands.logocommands;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import oolala.view.Pen;
import oolala.model.commands.LogoCommand;
import oolala.view.Turtle;

public class HideTurtle extends LogoCommand {


  public HideTurtle(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);
  }

  @Override
  public void commandFunc(ArrayList commandParams, Turtle t, Pen p) {
    super.commandFunc(commandParams, t, p);
    t.setColor(Color.TRANSPARENT);
  }
}

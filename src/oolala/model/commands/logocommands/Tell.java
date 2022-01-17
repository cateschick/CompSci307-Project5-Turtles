package oolala.model.commands.logocommands;

import java.util.ArrayList;
import javafx.scene.shape.Circle;
import oolala.model.commands.LogoCommand;
import oolala.view.Pen;
import oolala.view.Turtle;

public class Tell extends LogoCommand {

  private ArrayList<String> turtles;

  public Tell(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);
    }

  /**
   * sets specified turtles to follow commands
   * @param commandParams
   * @param t
   * @param p
   */
  @Override
  public void commandFunc(ArrayList commandParams, Turtle t, Pen p) {
    super.commandFunc(commandParams, t, p);
    turtles = new ArrayList<>();
    for (Object turtle: commandParams) {
      turtles.add((String)turtle);
    }
  }

  public ArrayList<String> getTurtles() {
    return turtles;
  }
  }



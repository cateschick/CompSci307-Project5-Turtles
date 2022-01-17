package oolala.model.commands;

import java.util.ArrayList;
import oolala.view.Pen;
import oolala.view.Turtle;

public class Command {
  protected String insn;
  protected ArrayList params;

  public Command(ArrayList commandParams, Turtle t, Pen p) {
    params = commandParams;
  }

  public ArrayList getParams() {
    return params;
  }

  public void commandFunc(ArrayList commandParams, Turtle t, Pen p) {
  }

  public void move(Pen p, Turtle t, double a, double currentX, double currentY, int pixels) {
    double delta = pixels * Math.cos(Math.toRadians(a));
    double endX = currentX + delta;
    double endY = currentY + delta;
    t.setX(endX);
    t.setY(endY);
    if (p.getPenDown()) {
      p.draw(currentX, currentY, endX, endY);
    }
  }



}

package oolala.model.Parsers;

import java.util.ArrayList;
import oolala.model.Parser;
import oolala.model.commands.Command;
import oolala.model.commands.darwincommands.Go;
import oolala.model.commands.darwincommands.IfEmpty;
import oolala.model.commands.darwincommands.IfEnemy;
import oolala.model.commands.darwincommands.IfRandom;
import oolala.model.commands.darwincommands.IfSame;
import oolala.model.commands.darwincommands.IfWall;
import oolala.model.commands.darwincommands.Infect;
import oolala.model.commands.darwincommands.Move;
import oolala.model.commands.darwincommands.Left;
import oolala.model.commands.darwincommands.Right;
import oolala.view.Error;
import oolala.view.Pen;
import oolala.view.Turtle;

public class DarwinParser extends Parser {

  @Override
  public Command getCommand(String insn, ArrayList paramList, Turtle t, Pen p) {
    super.getCommand(insn, paramList, t, p);
    if (insn.equals("move")) {
      return new Move(paramList, t, p);
    }
    else if (insn.equals("left")) {
      return new Left(paramList, t, p);
    }
    else if (insn.equals("right")) {
      return new Right(paramList, t, p);
    }
    else if (insn.equals("infect")) {
      return new Infect(paramList, t, p);
    }
    else if (insn.equals("ifempty")) {
      return new IfEmpty(paramList, t, p);
    }
    else if (insn.equals("ifwall")) {
      return new IfWall(paramList, t, p);
    }
    else if (insn.equals("ifsame")) {
      return new IfSame(paramList, t, p);
    }
    else if (insn.equals("ifenemy")) {
      return new IfEnemy(paramList, t, p);
    }
    else if (insn.equals("ifrandom")) {
      return new IfRandom(paramList, t, p);
    }
    else if (insn.equals("go")) {
      return new Go(paramList, t, p);
    }
    else {
      Error.showError();
      throw new IllegalArgumentException("Sorry, this command is not found in Darwin Simulator Language.");
    }
  }
}

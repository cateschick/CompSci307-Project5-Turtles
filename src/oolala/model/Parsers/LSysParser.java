package oolala.model.Parsers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import oolala.model.Parser;
import oolala.model.commands.Command;
import oolala.model.commands.lsystemcommands.Rule;
import oolala.model.commands.lsystemcommands.Set;
import oolala.model.commands.lsystemcommands.Start;
import oolala.view.Pen;
import oolala.view.Turtle;
import oolala.view.Error;

public class LSysParser extends Parser {

  /**
   * Overridden from superclass in Parser in order to build ArrayList of Command objects defined in
   * terms of Commands from logocommands package
   * @param programInput
   * @return ArrayList of Command objects from lsystemcommands package to be looped through
   * in order to execute each of their commandFunc methods
   */
  @Override
  public ArrayList<Command> processedParse(String[] programInput) {
    super.processedParse(programInput);
    /** REFACTOR: move to view **/
    Turtle t = new Turtle();
    Pen p = new Pen();
    /** end of move to view **/
    LinkedHashMap<String,ArrayList> cmap = Parse(programInput);
    ArrayList<Command> parsedCommandList = new ArrayList<>();
    for (String commandKey: cmap.keySet()) {
      Command C = getCommand(commandKey, cmap.get(commandKey), t, p);
      parsedCommandList.add(C);
    }
    return parsedCommandList;
  }

  /**
   * Overridden from superclass in Parser to identify commands in L-System Visualizer language
   * @param insn
   * @param paramList
   * @param t
   * @param p
   * @return Command object from lsystemcommands package
   */
  @Override
  public Command getCommand(String insn, ArrayList paramList, Turtle t, Pen p) {
    super.getCommand(insn, paramList, t, p);

    if (insn.equals("start")) {
      return new Start(paramList, t, p);
    }
    else if (insn.equals("rule")) {
      return new Rule(paramList, t, p);
    }
    else if (insn.equals("set")) {
      return new Set(paramList, t, p);
    }
    else {
      Error.showError();
      throw new IllegalArgumentException("Sorry, this command is not found in L-System Visualizer Language.");
    }
  }
}

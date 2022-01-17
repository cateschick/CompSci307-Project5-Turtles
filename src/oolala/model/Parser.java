package oolala.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import oolala.model.commands.Command;
import oolala.view.Pen;
import oolala.view.Turtle;

public class Parser {
  private static String myParser;

  //needed?
  private String commandName;
  private ArrayList commandParams;

  private LinkedHashMap<String, ArrayList> commandMap;
  private Hashtable<String, Command> commandDictionary;

  public static String getParser() {
    return myParser;
  }

  public static void setParser(String s) {
    myParser = s;
  }

  /**
   * Parses through file input by newline and spaces and
   * @return LinkedHashMap with each key being a String Command and each value
   * being an ArrayList of command parameters
   */
  public LinkedHashMap Parse(String[] programInput) {
    commandMap = new LinkedHashMap<String,ArrayList>(); //LinkedHashMap to preserve correct order (LIFO)
    for (String command: programInput) {
      String[] splitCommand = command.split(" ");
      String name = splitCommand[0]; // make 0 into var
      ArrayList<String> params = new ArrayList<>();
      for (int i=1; i < splitCommand.length; i++) {
        params.add(splitCommand[i]);
      }
      commandMap.put(name.toLowerCase(), params);
    }
    return commandMap;
  }

  /**
   * Parses through the LinkedHashMap returned by Parse method to
   * @return ArrayList of Command objects to be looped through in order to execute each of their
   * commandFunc methods
   */
  public ArrayList<Command> processedParse(String[] programInput) {
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
   * Superclass for retrieving Command for processedParse method based on each language's format
   * Also takes Turtle and Pen so that commandFuncs can be called on them
   * @param insn
   * @param paramList
   * @param t
   * @param p
   * @return Command object corresponding to given instruction and paramList
   */
  public Command getCommand(String insn, ArrayList paramList, Turtle t, Pen p) {
    Command c = new Command(paramList, t, p);
    return c;
  }

  /**
   * Executes all commands in ArrayList of Command objects returned by processedParse
   * @param commandsToRun
   * @param t
   * @param p
   */
  public void execute(ArrayList<Command> commandsToRun, Turtle t, Pen p) {
    for (Command c: commandsToRun) {
      ArrayList<Command> params = c.getParams();
      c.commandFunc(params, t, p);
    }
  }

  /**
   * Executes the Command objects by parsing them using processedParse and execute methods
   * @param programInput
   * @param t
   * @param p
   */
  public void runProgram(String[] programInput, Turtle t, Pen p) {
    ArrayList<Command> commandsToRun = processedParse(programInput);
    execute(commandsToRun, t, p);
  }



}

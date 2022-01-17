package oolala.model.commands.lsystemcommands;

import java.util.ArrayList;
import java.util.HashMap;
import oolala.model.Parsers.LSysParser;
import oolala.model.commands.LSysCommand;
import oolala.view.Pen;
import oolala.view.Turtle;

public class Set extends LSysCommand {

  public Set(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);
  }

  @Override
  public void commandFunc(ArrayList commandParams, Turtle t, Pen p) {
    super.commandFunc(commandParams, t, p);
    LSysAlphabet alphabet = new LSysAlphabet();
    alphabet.setBuiltInAlphabet();
    HashMap<String, ArrayList<String>> LSMap = alphabet.getLSMap();
    ArrayList<String> commandList = new ArrayList<>();
    for (int i=1; i< commandParams.size(); i++) {
      String pString = (String) commandParams.get(i);
      if (pString.equals("fd") || pString.equals("bk") || pString.equals("lt") || pString.equals("rt") || pString.equals("pd") || pString.equals("pu") || pString.equals("st") || pString.equals("ht") || pString.equals("home") || pString.equals("stamp") || pString.equals("tell")) {
        commandList.add(pString);
      }
    }
    LSMap.put((String) commandParams.get(0), commandList);
  }
}

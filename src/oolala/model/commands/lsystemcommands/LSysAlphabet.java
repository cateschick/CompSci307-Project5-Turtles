package oolala.model.commands.lsystemcommands;

import java.util.ArrayList;
import java.util.HashMap;
import oolala.model.commands.Command;
import oolala.model.commands.logocommands.PenDown;

public class LSysAlphabet {
  private HashMap<String, ArrayList<String>> LSMap;

  public LSysAlphabet() {
    LSMap = new HashMap();
  }

  public void setBuiltInAlphabet() {
    ArrayList<String> fCommands = new ArrayList();
    fCommands.add("pd");
    fCommands.add("fd");
    LSMap.put("f", fCommands);

    ArrayList<String> gCommands = new ArrayList();
    gCommands.add("pu");
    gCommands.add("fd");
    LSMap.put("g", gCommands);

    ArrayList<String> aCommands = new ArrayList();
    aCommands.add("pu");
    aCommands.add("bk");
    LSMap.put("a", aCommands);

    ArrayList<String> bCommands = new ArrayList();
    bCommands.add("pd");
    bCommands.add("bk");
    LSMap.put("b", bCommands);

    ArrayList<String> plusCommands = new ArrayList();
    plusCommands.add("rt");
    LSMap.put("+", plusCommands);

    ArrayList<String> minusCommands = new ArrayList();
    minusCommands.add("lt");
    LSMap.put("-", minusCommands);

    ArrayList<String> stampCommands = new ArrayList();
    stampCommands.add("stamp");
    LSMap.put("x", stampCommands);

  }

  public HashMap<String, ArrayList<String>> getLSMap() {
    return LSMap;
  }



}

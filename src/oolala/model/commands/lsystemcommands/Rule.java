package oolala.model.commands.lsystemcommands;

import java.util.ArrayList;
import oolala.model.commands.LSysCommand;
import oolala.model.commands.logocommands.Back;
import oolala.model.commands.logocommands.Forward;
import oolala.model.commands.logocommands.HideTurtle;
import oolala.model.commands.logocommands.Home;
import oolala.model.commands.logocommands.Left;
import oolala.model.commands.logocommands.PenDown;
import oolala.model.commands.logocommands.PenUp;
import oolala.model.commands.logocommands.Right;
import oolala.model.commands.logocommands.ShowTurtle;
import oolala.model.commands.logocommands.Stamp;
import oolala.model.commands.logocommands.Tell;
import oolala.view.Pen;
import oolala.view.Turtle;

public class Rule extends LSysCommand {

  //TO-D0: Make this user input
  //Angle and Length values
  String angle = "90";
  String length = "20";


  public Rule(ArrayList commandParams, Turtle t, Pen p) {
    super(commandParams, t, p);
  }

  @Override
  public void commandFunc(ArrayList commandParams, Turtle t, Pen p) {
    super.commandFunc(commandParams, t, p);
    ArrayList<String> angleParamList = new ArrayList<>();
    angleParamList.add((angle));
    ArrayList<String> lengthParamList = new ArrayList<>();
    lengthParamList.add((length));
    ArrayList<String> emptyParamList = new ArrayList<>();
    String symbol = (String) commandParams.get(0);
    LSysAlphabet alphabet = new LSysAlphabet();
    alphabet.setBuiltInAlphabet();
    ArrayList<String> logoList = alphabet.getLSMap().get(symbol);
    for (String logoInsn: logoList) {
      if (insn.equals("fd")) {
        Forward f = new Forward(lengthParamList, t, p);
        f.commandFunc(lengthParamList, t, p);
      }
      else if (insn.equals("bk")) {
        Back b = new Back(lengthParamList, t, p);
        b.commandFunc(lengthParamList, t, p);
      }
      else if (insn.equals("lt")) {
        Left l = new Left(angleParamList, t, p);
        l.commandFunc(angleParamList, t, p);
      }
      else if (insn.equals("rt")) {
        Right r = new Right(angleParamList, t, p);
        r.commandFunc(angleParamList, t, p);
      }
      else if (insn.equals("pd")) {
        PenDown pd = new PenDown(emptyParamList, t, p);
        pd.commandFunc(emptyParamList, t, p);
      }
      else if (insn.equals("pu")) {
        PenUp pu = new PenUp(emptyParamList, t, p);
        pu.commandFunc(emptyParamList, t, p);
      }
      else if (insn.equals("st")) {
        ShowTurtle st = new ShowTurtle(emptyParamList, t, p);
        st.commandFunc(emptyParamList, t, p);
      }
      else if (insn.equals("ht")) {
        HideTurtle ht = new HideTurtle(emptyParamList, t, p);
        ht.commandFunc(emptyParamList, t, p);
      }
      else if (insn.equals("home")) {
        Home h = new Home(emptyParamList, t, p);
        h.commandFunc(emptyParamList, t, p);
      }
      else if (insn.equals("stamp")) {
        Stamp stamp = new Stamp(emptyParamList, t, p);
        stamp.commandFunc(emptyParamList, t, p);
      }
      else if (insn.equals("tell")) {
        Tell tell = new Tell(emptyParamList, t, p);
        tell.commandFunc(emptyParamList, t, p);
      }
      else {
        throw new IllegalArgumentException("Sorry, this command is not found in Logo Programming IDE Language.");
      }
    }
  }
}

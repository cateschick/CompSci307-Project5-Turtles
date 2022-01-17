package oolala.model.commands.logocommands;

import java.util.ArrayList;
import oolala.view.Pen;
import oolala.model.commands.LogoCommand;
import oolala.view.Turtle;

public class PenUp extends LogoCommand {

    public PenUp(ArrayList commandParams, Turtle t, Pen p) {
        super(commandParams, t, p);
    }

    /**
     * changes penDown attribute of pen object to false so that turtle will not be drawing
     * @param commandParams
     * @param t
     * @param p
     */
    @Override
    public void commandFunc(ArrayList commandParams, Turtle t, Pen p) {
        super.commandFunc(commandParams, t, p);
        p.setPenDown(false);
    }
}


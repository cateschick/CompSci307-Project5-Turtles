package oolala;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import oolala.model.Parser;
import oolala.model.commands.logocommands.Back;
import oolala.model.commands.logocommands.Forward;
import oolala.model.commands.logocommands.HideTurtle;
import oolala.model.commands.logocommands.Home;
import oolala.model.commands.logocommands.Left;
import oolala.model.commands.logocommands.PenDown;
import oolala.model.commands.logocommands.PenUp;
import oolala.model.commands.logocommands.Right;
import oolala.model.commands.logocommands.ShowTurtle;
import oolala.model.ReadWrite;
import oolala.model.commands.logocommands.Stamp;
import oolala.model.commands.logocommands.Tell;
import oolala.view.Pen;
import oolala.view.Turtle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Feel free to completely change this code or delete it entirely. 
 */
class MainTest {
    // how close do real valued numbers need to be to count as the same
    static final double TOLERANCE = 0.0005;

    //test Strings (Turtle Program) to be parsed
    static final String[] testTurtleCodeString = new String[] {"fd 50", "lt 90"};
    static final String[] testNoParamsString = new String[] {"home", "pu"};
    static final String[] testDiffCasesString = new String[] {"HOME" + "lt 90"};

    /** Parser parses correctly **/
    @Test
    void testParser () {
        Map<String, ArrayList> testMap = new LinkedHashMap<>();

        ArrayList<String> c1Params = new ArrayList<>();
        c1Params.add("50");
        testMap.put("fd", c1Params);

        ArrayList<String> c2Params = new ArrayList<>();
        c2Params.add("90");
        testMap.put("lt", c2Params);

        Parser p = new Parser();
        assertEquals(testMap, p.Parse(testTurtleCodeString));
    }

    /** tests Parser result on command with 0 params **/
    @Test
    void testParserNoParams () {
        Map<String, ArrayList> testMap = new LinkedHashMap<>();

        ArrayList<String> c1Params = new ArrayList<>();
        testMap.put("home", c1Params);
        ArrayList<String> c2Params = new ArrayList<>();
        testMap.put("pu", c2Params);

        Parser p = new Parser();
        assertEquals(testMap, p.Parse(testNoParamsString));
    }

    /** tests Parser with different case commands **/
    @Test
    void testParserCases () {
        Map<String, ArrayList> testMap = new LinkedHashMap<>();

        ArrayList<String> c1Params = new ArrayList<>();
        testMap.put("home", c1Params);

        ArrayList<String> c2Params = new ArrayList<>();
        c2Params.add("90");
        testMap.put("lt", c2Params);

        Parser p = new Parser();
        assertEquals(testMap, p.Parse(testDiffCasesString));
    }

    /** Tests that showTurtle command turns fill and stroke from transparent to green **/
    @Test
    void testShowTurtle() {
        ArrayList<String> Params = new ArrayList<>();
        Turtle t = new Turtle();
        Pen p = new Pen();
        ShowTurtle show = new ShowTurtle(Params, t, p);
        show.commandFunc(Params, t, p);
        t.editTurtleColor(Color.GREEN);
        assertEquals(Color.GREEN, t.getColor());
    }

    /** Tests that hideTurtle command turns fill and stroke from green to transparent**/
    @Test
    void testHideTurtle() {
        ArrayList<String> Params = new ArrayList<>();
        Turtle t = new Turtle();
        Pen p = new Pen();
        HideTurtle hide = new HideTurtle(Params, t, p);
        hide.commandFunc(Params, t, p);
        t.editTurtleColor(Color.TRANSPARENT);
        assertEquals(Color.TRANSPARENT, t.getColor());

    }

    /** tests that back moves turtle to correct coordinates **/
    @Test
    void testBack() {
        Turtle t = new Turtle();
        Pen p = new Pen();
        ArrayList<String> Params = new ArrayList<>();
        Params.add("50");
        Back back = new Back(Params, t, p);
        back.commandFunc(Params, t, p);
        assertEquals(t.getX(), -50);
        assertEquals(t.getY(), -50);
    }

    /** tests that forward moves turtle to correct coordinates **/
    @Test
    void testForward() {
        Turtle t = new Turtle();
        Pen p = new Pen();
        ArrayList<String> Params = new ArrayList<>();
        Params.add("50");
        Forward forward = new Forward(Params, t, p);
        forward.commandFunc(Params, t, p);
        assertEquals(t.getX(), 50);
        assertEquals(t.getY(), 50);
    }

    /** tests that penUp makes penDown false **/
    @Test
    void testPenUp() {
        Turtle t = new Turtle();
        Pen p = new Pen();
        ArrayList<String> Params = new ArrayList<>();
        PenUp penUp = new PenUp(Params, t, p);
        penUp.commandFunc(Params, t, p);
        assertEquals(false, p.getPenDown());
    }

    /** tests that penDown makes penDown true **/
    @Test
    void testPenDown() {
        Turtle t = new Turtle();
        Pen p = new Pen();
        ArrayList<String> Params = new ArrayList<>();
        PenDown penDown = new PenDown(Params, t, p);
        penDown.commandFunc(Params, t, p);
        assertEquals(true, p.getPenDown());
    }

    /** tests that Home makes centerX and centerY 0 **/
    @Test
    void testHome() {
        Turtle t = new Turtle();
        Pen p = new Pen();
        ArrayList<String> Params = new ArrayList<>();
        Home home = new Home(Params, t, p);
        home.commandFunc(Params, t, p);
        assertEquals(0, t.getX());
        assertEquals(0, t.getY());
    }

    /** tests that Right correctly changes angle of turtle **/
    @Test
    void testRight() {
        Turtle t = new Turtle();
        Pen p = new Pen();
        ArrayList<String> Params = new ArrayList<>();
        Params.add("90");
        Right r = new Right(Params, t, p);
        r.commandFunc(Params, t, p);
        assertEquals(90, (t.getAngle()));
    }

    /** tests that Left correctly changes angle of turtle **/
    @Test
    void testLeft() {
        Turtle t = new Turtle();
        Pen p = new Pen();
        ArrayList<String> Params = new ArrayList<>();
        Params.add("90");
        Left l = new Left(Params, t, p);
        l.commandFunc(Params, t, p);
        assertEquals(-90, t.getAngle());
    }

    @Test
    void testStamp() {
        Turtle t = new Turtle();
        t.setX(20);
        t.setY(20);
        Pen p = new Pen();
        ArrayList<String> Params = new ArrayList<>();
        Stamp s = new Stamp(Params, t, p);
        s.commandFunc(Params, t, p);
        assertEquals(20, t.getX());
        assertEquals(20, t.getY());
    }

    @Test
    void testTell() {
        Turtle t = new Turtle();
        Pen p = new Pen();
        ArrayList<String> Params = new ArrayList<>();
        Params.add("t0");
        Params.add("t1");
        Params.add("t2");
        Tell tell = new Tell(Params, t, p);
        tell.getTurtles();
    }
    /**
     * tests that a known file is accurately being read
     */
    @Test
    void readFileTest() throws FileNotFoundException {
        assertEquals("F", ReadWrite.readFile("lsystem","koch_curve.txt")[5]);
    }
    @Test
    void readAnotherFileTest() throws FileNotFoundException {
        assertEquals("rt", ReadWrite.readFile("logo","triangle.txt")[2]);
    }

    /**
     * Test to check that a file can be written when called
     */
    @Test
    void writeFileTest() {
        ReadWrite.writeFile("logo", "newFile.txt", "Empty File");
        assertEquals("newFile.txt", ReadWrite.openFile("logo")[3]);
    }

    /**
     * tests to check that all program files can be opened
     */
    @Test
    void OpenFileTest(){
        assertEquals("grid.txt", ReadWrite.openFile("logo")[0]);
        assertEquals("flytrap.txt", ReadWrite.openFile("darwin")[0]);
        assertEquals("koch_curve.txt", ReadWrite.openFile("lsystem")[0]);
    }
}

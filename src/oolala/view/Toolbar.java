package oolala.view;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import java.util.ResourceBundle;
import oolala.view.Display.Display;
import oolala.view.Display.DrawingDisplay;
import oolala.view.Display.LanguageDisplay;
import oolala.view.Display.MainDisplay;
import oolala.view.Display.OpenFileDisplay;
import oolala.view.Display.SettingsDisplay;
import oolala.view.Display.TextEditor;

public final class Toolbar {

  /**
   * Toolbar displayed at top of screen.
   */
  private static ToolBar myToolbar;

  /**
   * Private constructor to hide implicit public class.
   */
  private Toolbar() {
  }

  /**
   * Clears and redraws the ToolBar when the language is changed.
   */
  public static void updateToolBar() {
    myToolbar.getItems().clear();
    myToolbar = makeToolbar();
    View.getRoot().setTop(myToolbar);
  }

  /**
   * Creates a toolbar that sticks to the top of the scene.
   *
   * @return h a new ToolBar.
   */
  public static ToolBar makeToolbar() {
    myToolbar = new ToolBar();

    // Create Buttons and add event handlers to them
    ResourceBundle resources = Resources.getResources(Resources.getPath());
    addToolbarButtons(myToolbar, resources);

    return myToolbar;
  }

  /**
   * Adds buttons to the ToolBar and sets their functionality.
   *
   * @param t the ToolBar.
   * @param r a Resource Bundle to properly name buttons.
   */
  private static void addToolbarButtons(
      final ToolBar t, final ResourceBundle r) {
    Button home = ButtonColorPicker.makeButton(r.getString("Home"),
        event -> Display.switchDisplay(MainDisplay.createMainDisplay()));
    Button newFile = ButtonColorPicker.makeButton(r.getString("NewFile"),
        event -> Display.switchDisplay(TextEditor.createInputField()));
    Button open = ButtonColorPicker.makeButton(r.getString("OpenFile"),
        event -> Display.switchDisplay(OpenFileDisplay.createFileDisplay()));
    Button save = ButtonColorPicker.makeButton(r.getString("SaveFile"),
        event -> TextEditor.handleSave(TextEditor.getEditor()));
    Button clear = ButtonColorPicker.makeButton(r.getString("ClearScreen"),
        event -> Display.clearScreen(DrawingDisplay.getDrawing()));
    Button design =
        ButtonColorPicker.makeButton(r.getString("DesignSettings"),
        event -> Display.switchDisplay(SettingsDisplay.createDesignSettings()));
    Button language =
        ButtonColorPicker.makeButton(r.getString("ChangeLanguage"),
        event -> Display.switchDisplay(
            LanguageDisplay.createLanguageSettings()));

    Button[] buttons = {home, newFile, open, save, clear, design, language};
    for (Button b : buttons) {
      t.getItems().add(b);
      b.getStyleClass().add("tool-bar-button");
    }
  }
}

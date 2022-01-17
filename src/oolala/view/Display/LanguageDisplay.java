package oolala.view.Display;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import oolala.view.ButtonColorPicker;
import oolala.view.Resources;

public class LanguageDisplay extends Display {

  /**
   * Creates display of available languages.
   *
   * @return Display of language settings.
   */
  public static BorderPane createLanguageSettings() {
    BorderPane languageSettings = new BorderPane();
    languageSettings.getStyleClass().addAll("display");

    VBox v = addLanguageContent();
    languageSettings.setCenter(v);
    return languageSettings;
  }

  /**
   * Adds VBox with language content to display.
   *
   * @return VBox with language options and display title.
   */
  private static VBox addLanguageContent() {
    final VBox v = new VBox();
    v.getStyleClass().addAll("vbox", "languages-vbox");

    // Set Title and make buttons
    Display.addDisplayTitle(v, resources.getString("LanguageOptions"));
    addButtons(v);

    return v;
  }

  /**
   * Adds buttons displaying available languages to display.
   *
   * @param v VBox containing display content.
   */
  private static void addButtons(final VBox v) {
    // TODO: Add Zulu
    String[] names = {"English", "Spanish", "Danish", "German", "Zulu"};

    // Add button for each language
    for (String name : names) {
      Button b = ButtonColorPicker.makeButton(resources.getString(name),
          event -> Resources.setPath(String.format(
              "resources.%s", name.toLowerCase())));

      v.getChildren().add(b);
      b.getStyleClass().add("application");
    }
  }
}
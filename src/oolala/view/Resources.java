package oolala.view;

import java.util.ResourceBundle;
import oolala.view.Display.Display;
import oolala.view.Display.LanguageDisplay;

public final class Resources {

  /**
   * Private constructor for public utility class.
   */
  private Resources() {
  }

  /**
   * Default resource path set to English property file.
   */
  private static String resourcePath = "resources.english";

  /**
   * Returns resources from the desired resource bundle.
   *
   * @param path the filepath indicating which resource bundle to access.
   * @return keys and values of resource bundle.
   */
  public static ResourceBundle getResources(final String path) {
    return ResourceBundle.getBundle(path);
  }

  /**
   * Returns the private variable resourcePath.
   *
   * @return resourcePath, the String path to the resource bundle.
   */
  public static String getPath() {
    return resourcePath;
  }

  /**
   * Allows user to set resource path to a selected language
   * and redraws all displays in that language.
   * @param path the filepath for desired resource file
   */
  public static void setPath(final String path) {
    resourcePath = path;
    Display.updateResources();
    Toolbar.updateToolBar();
    Display.switchDisplay(LanguageDisplay.createLanguageSettings());
  }
}

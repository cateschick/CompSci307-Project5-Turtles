# doc

Put any written documents related to your project here, including lab discussions.

I don't want to try and implement any of this stuff yet, I'm just gathering ideas and code from online to begin to be
able to think about some of these things.

```java
import javax.sound.midi.Soundbank;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;

// Typical code to create text field for input from BROWSER Assignment
public class NanoBrowserView {

    private TextField makeInputField(int width, EventHandler<ActionEvent> handler) {
        TextField result = new TextField();
        result.setPrefColumnCount(width);
        result.setOnAction(handler);
        return result;
    }
}

//The handler that gets called is going to be a method that uses the returned TextField to save to a file.
//https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java
//https://stackabuse.com/reading-and-writing-files-in-java/
public class readwriteFile {
    String myFile = ""; //need method to select file
    ArrayList<String> myInstructions;//somehow store all the information

    public writeFile(Sting fileName) {
        String fileName = myFile;

        // Write the content in file
        try (filename) {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(/*Whatever is written by inputField*/);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(); //these go away later.
        }
    }

    // Exception handling
    // we could borrow the exception throwing from browser
    // Read the content from file
    public readFile(Sting fileName, ArrayList infostructions) {
        fileName = myFile;
        infostructions = myInstructions;
        try (infostructions) {
            File instructions = new File(fileName);
            Scanner scnr = new Scanner(instructions);
            while (scnr.hasNextLine()) {
                String line = scrn.nextLine();
                line
                //method for dividing command and number into two entities
            }
        } catch (FileNotFoundException e) {
            // Exception handling
            // we could borrow the exception throwing from browser
        } catch (IOException e) {
            // Exception handling
            // we could borrow the exception throwing from browser
        }
    }

}
 ```

Resource used for OpenFile function, used the File object to list the files.
https://www.tutorialspoint.com/how-to-get-list-of-all-files-folders-from-a-folder-in-java
& this one
https://stackoverflow.com/questions/5694385/getting-the-filenames-of-all-files-in-a-folder

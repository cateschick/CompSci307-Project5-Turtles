package oolala.model;

import java.io.*;
import java.util.Scanner;


/**
 * Java Class designed to read, write, and open files
 */

public class ReadWrite {
    private static final String hashSymbol = "#";
    private static final String filePathStart = "data/examples/";


    /**
     * writes a file and stores it for whatever type program desired
     * @param programName
     * @param fileName
     * @param input
     */
    public static void writeFile(String programName, String fileName, String input) {
        String filePath =  filePathStart + programName + "/" + fileName;
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(input);
            writer.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("Error writing file");
        }
    }

    /**
     * Reads the content from a file and returns it as a String Array, also removes comments
     * @param programName
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public static String[] readFile(String programName, String fileName) throws FileNotFoundException {
        String filePath = filePathStart + programName + "/" + fileName;
        try {
            FileReader instructions = new FileReader(filePath);
            Scanner scnr = new Scanner(instructions);
            String Inscrt = "";
            Inscrt = removeDescriptions(scnr, Inscrt, hashSymbol);
            String[] inst_list = Inscrt.split(" ");
            return inst_list;
        }
        catch(IOException e){
            throw new IllegalArgumentException("File does not exist");
        }
    }
    /**
     * removes descriptions from files
     * @param scnr
     * @param Inscrt
     * @param hash_sym
     * @return
     */
    private static String removeDescriptions(Scanner scnr, String Inscrt, String hash_sym) {
        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();
            if (line.length() > 0 && line.charAt(0) != hash_sym.charAt(0)) {
                Inscrt += line + " ";
            }
        }
        return Inscrt;
    }

    /**
     * returns list of filenames in a program
     * @param programName
     * @return
     */
    public static String[] openFile(String programName){
        String filePath = filePathStart + programName;
        File folderFiles = new File(filePath);
        File[] files = folderFiles.listFiles();
        String filenames ="";
        for(int i=0; i<files.length; i++){
            filenames += files[i] + " ";
        }
        return stripForName(filenames.split(" "));
    }

    /**
     *
     * @param txtFiles
     * @return
     */
    private static String[] stripForName(String[] txtFiles){
        String[] temp = txtFiles;
        for(int i=0; i<temp.length;i++){
            String[] brokenPath = txtFiles[i].split("/");
            temp[i] = brokenPath[brokenPath.length-1];
        }
        return temp;
    }
}
package me.dasha.lab5;


import me.dasha.lab5.parser.Parser;
import me.dasha.lab5.utility.ConsoleManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        //InputStream inputStream = new FileInputStream("test.json");
        Parser.fromJsonToCollection(args[0]);
        //Parser.fromJsonToCollection(inputStream.toString());
        ConsoleManager consoleManager = new ConsoleManager();
        consoleManager.start();
    }
}
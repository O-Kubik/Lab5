package me.dasha.lab5;


import me.dasha.lab5.parser.Parser;
import me.dasha.lab5.parser.Parser_1;
import me.dasha.lab5.utility.ConsoleManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        System.out.println("Введите команду. Для справки введите \"help\"");
        ConsoleManager consoleManager = new ConsoleManager();
        consoleManager.start();
    }
};

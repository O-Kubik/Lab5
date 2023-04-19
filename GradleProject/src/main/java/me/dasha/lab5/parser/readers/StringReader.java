package me.dasha.lab5.parser.readers;

import java.util.Scanner;

public class StringReader {
    public static String read(String msg, boolean canBeNull) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        String readStr = scanner.nextLine().trim();

        while (!canBeNull && readStr.isEmpty()) {
            System.out.println("Поле не может быть пустым " + msg);
            readStr = scanner.nextLine().trim();
        }
        if (canBeNull && readStr.isEmpty()) {
            readStr = null;
        }
        return readStr;
    }
}

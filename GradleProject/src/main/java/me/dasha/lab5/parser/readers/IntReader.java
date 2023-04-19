package me.dasha.lab5.parser.readers;

import java.util.Scanner;

//данный класс отвечает за считывание введенное пользователем значение типа int
public class IntReader {
    public static int read(String msg, boolean canBeNull, int limit) {
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        int result;
        while (true) {
            try {
                result = Integer.parseInt(scanner.nextLine().trim()); //считываем значение с помощью метода scanner.nextLine().trim(),
                // затем преобразовать к типу int с помощью метода Integer.parseInt
                if (result > limit) {
                    break;
                }
                System.out.println("Недопустимое значение. Попробуйте снова: ");
            }
            catch (NumberFormatException ex) {
                if (canBeNull && scanner.nextLine().trim().equals("")) {
                    return -1;
                }
                System.out.println("Недопустимое значение. Введите число: ");
            }
        }
        return result;
    }
}

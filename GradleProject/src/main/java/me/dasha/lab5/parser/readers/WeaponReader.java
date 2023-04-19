package me.dasha.lab5.parser.readers;

import me.dasha.lab5.collectionClasses.Weapon;

import java.util.Arrays;
import java.util.Scanner;

public class WeaponReader {
    public static boolean checkExist(String str) {
        for (Weapon weapon : Weapon.values()) {
            if (weapon.name().equals(str)) {
                return true;
            }
        }
        return false;
    }
    public static Weapon read(boolean canBeNull) {
        System.out.println("Выберите одно оружие: " + Arrays.toString(Weapon.values()));
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();

        while (!checkExist(str) && !canBeNull && !str.equals("")) {
            System.out.println("Недопустимое значение. Попробуйте снова: ");
            str = scanner.nextLine().trim();
        }
        return str.equals("") && canBeNull ? null : Enum.valueOf(Weapon.class, str);
    }
}

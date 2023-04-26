package me.dasha.lab5.parser.readers;

import me.dasha.lab5.collectionClasses.MeleeWeapon;

import java.util.Arrays;
import java.util.Scanner;

public class MeleeWeaponReader {
    public static boolean checkExist(String str) {
        for (MeleeWeapon meleeWeapon : MeleeWeapon.values()) {
            if (meleeWeapon.name().equals(str)) {
                return true;
            }
        }
        return false;
    }
    public static MeleeWeapon read(boolean canBeNull) {
        System.out.println("Выберите одно оружие ближнего боя: " + Arrays.toString(MeleeWeapon.values()));
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();

        while (!checkExist(str) && !canBeNull && !str.equals("")) {
            System.out.println("Недопустимое значение. Попробуйте снова: ");
            str = scanner.nextLine().trim();
        }
        return str.equals("") && canBeNull ? null : Enum.valueOf(MeleeWeapon.class, str);
    }
}

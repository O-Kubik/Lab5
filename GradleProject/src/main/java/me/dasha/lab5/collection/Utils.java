package me.dasha.lab5.collection;

import me.dasha.lab5.collectionClasses.SpaceMarine;

public class Utils {
    public static boolean checkExist(Integer Id) {
        for (SpaceMarine spaceMarine: CollectionManager.getStack()) {
            return spaceMarine.getId().equals(Id);//TODO переопределить equals в SpaceMarine
        }
        return false;
    }
    static void display(SpaceMarine spaceMarine) {
        System.out.println("ID элемента коллекции: " + spaceMarine.getId()
                + "\n" +
                "имя: " + spaceMarine.getName()
                + "\n" +
                "Координата X : " + spaceMarine.getCoordinates().getX()
                + "\n"
                + "Координата Y : " + spaceMarine.getCoordinates().getY()
                + "\n" +
                "Здоровье: " + spaceMarine.getHealth()
                + "\n" +
                "Достижения: " + spaceMarine.getAchievements()
                + "\n" +
                "Тип оружия: " + spaceMarine.getWeaponType().name()
                + "\n" +
                "Оружие ближнего боя: " + spaceMarine.getMeleeWeapon().name()
                + "\n" +
                "Глава: " + spaceMarine.getChapter().getName());
    }
}

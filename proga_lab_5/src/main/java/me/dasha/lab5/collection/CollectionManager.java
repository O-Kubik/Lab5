package me.dasha.lab5.collection;

import me.dasha.lab5.collectionClasses.Coordinates;
import me.dasha.lab5.collectionClasses.SpaceMarine;

import java.time.LocalDateTime;
import java.util.*;

public class CollectionManager {
    private static Stack<SpaceMarine> stack;
    private static LocalDateTime creationDate;

    public static void checkStack(){
        if (stack == null) {
            stack = new Stack<>();
            creationDate = LocalDateTime.now();
        }
    }
    public static Stack<SpaceMarine> getStack(){
        return stack;
    }

    public static void add(SpaceMarine spaceMarine) {
        stack.add(spaceMarine);
    }

    public static void addJSONObject(SpaceMarine spaceMarine) {
        spaceMarine.setId(GeneratorID.generateID(spaceMarine.getId()));//возможно заменить просто на getId
        stack.add(spaceMarine);
    }
    public static void info(){
        System.out.print("Тип коллекции: " + stack.getClass().getName()
                + "\nДата инициализации: " + creationDate
                + "\nКоличество элементов в коллекции: " + stack.size()
                + "\n-----------------------------------\n" );
    }
    public static void show(){
        stack.forEach(Utils::display);
    }
    public static void update(SpaceMarine spaceMarine, Integer id) {
        stack.forEach(SpaceMarine -> {
            if (SpaceMarine.getId().equals(id)) {
                SpaceMarine.setName(spaceMarine.getName());
                SpaceMarine.setCoordinates(spaceMarine.getCoordinates());
                SpaceMarine.setHealth(spaceMarine.getHealth());
                SpaceMarine.setAchievements(spaceMarine.getAchievements());
                SpaceMarine.setWeaponType(spaceMarine.getWeaponType());
                SpaceMarine.setMeleeWeapon(spaceMarine.getMeleeWeapon());
                SpaceMarine.setChapter(spaceMarine.getChapter());
            }
        });
    }
    public static void removeById(Integer id) {
        Iterator<SpaceMarine> i = stack.iterator();
        while (i.hasNext()) {
            SpaceMarine spaceMarine = i.next();
            {
                if (spaceMarine.getId().equals(id)) {
                    i.remove();
                    System.out.println("Элемент удален из коллекции");
                }
            }
        }
        System.out.println("Элемента с таким ID нет в коллекции");
    }
    public static void clear(){
        stack.clear();
    }
    public static void save(){//в другом классе
    }
    public static void insertAt(int index, SpaceMarine element) {
        Stack<SpaceMarine> newStack = new Stack<>();
        int count = 0;
        while (!stack.isEmpty() && count < index) {
            newStack.push(stack.pop());
            count++;
        }
        stack.push(element);
        while (!newStack.isEmpty()) {
            stack.push(newStack.pop());
        }
    }
    public static void addIfMin(SpaceMarine spaceMarine) {
        for (SpaceMarine spaceMarine1 : stack) {
            if(spaceMarine1.compareTo(spaceMarine) > 0) {
                stack.add(spaceMarine);
            }
            else {
                System.out.println("Невозможно добавить элемент");
                break;
            }
        }
    }
    public static void removeAnyByAchievements(String achievements) {
        Iterator<SpaceMarine> iterator = stack.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            SpaceMarine spaceMarine = iterator.next();
            if (spaceMarine.getAchievements().equals(achievements)) {
                iterator.remove();
                found = true;
                System.out.println("Элемент удален из коллекции.");
                break;
            }
        }
        if (!found) {
            System.out.println("Элемента с такими достижениями нет в коллекции.");
        }
    }
    public static void groupCountingByCoordinates() {
        Map<Coordinates, List<SpaceMarine>> groupedSpaceMarines = new HashMap<>();
        Iterator<SpaceMarine> iterator = stack.iterator();
        while (iterator.hasNext()) {
            SpaceMarine spaceMarine = iterator.next();
            Coordinates coordinates = spaceMarine.getCoordinates();
            if (!groupedSpaceMarines.containsKey(coordinates)) {
                groupedSpaceMarines.put(coordinates, new ArrayList<>());
            }
            groupedSpaceMarines.get(coordinates).add(spaceMarine);
        }
        for (Coordinates coordinates : groupedSpaceMarines.keySet()) {
            int count = groupedSpaceMarines.get(coordinates).size();
            System.out.println("Координаты " + coordinates + ": " + count + " элементов");
        }
    }


        public static void sort() {
        ArrayList<SpaceMarine> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            stack.push(list.get(i));
        }
        System.out.println("Коллекция отсортирована: " + stack);
    }
}

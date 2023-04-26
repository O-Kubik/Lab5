package me.dasha.lab5.commands;

import me.dasha.lab5.collection.CollectionManager;
import me.dasha.lab5.collection.Utils;
import me.dasha.lab5.collectionClasses.SpaceMarine;
import me.dasha.lab5.parser.Parser_1;
import me.dasha.lab5.utility.Creator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static me.dasha.lab5.commands.concreteCommands.ExecuteScript.getPath;


//Получатель: принимает команду и содержит основную логику команд
//Команды вызывают методы Receiver-а

public class CommandReceiver {
    private final CommandInvoker commandInvoker;
    private SpaceMarine spaceMarine;

    public CommandReceiver(CommandInvoker commandInvoker) {
        this.commandInvoker = commandInvoker;
    }

    public void help() {
        //commandInvoker.getHistory().forEach((name, command) -> command.writeInfo);//TODO: переписать command.Info
        System.out.println("help : вывести справку по доступным командам \n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.) \n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении \n" +
                "add {element} : добавить новый элемент в коллекцию \n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному \n" +
                "remove_by_id id : удалить элемент из коллекции по его id \n" +
                "clear : очистить коллекцию \n" +
                "save : сохранить коллекцию в файл \n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме \n" +
                "exit : завершить программу (без сохранения в файл) \n" +
                "insert_at index {element} : добавить новый элемент в заданную позицию \n" +
                "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции \n" +
                "sort : отсортировать коллекцию в естественном порядке \n" +
                "remove_any_by_achievements achievements : удалить из коллекции один элемент, значение поля achievements которого эквивалентно заданному \n" +
                "group_counting_by_coordinates : сгруппировать элементы коллекции по значению поля coordinates, вывести количество элементов в каждой группе \n" +
                "count_greater_than_melee_weapon meleeWeapon : вывести количество элементов, значение поля meleeWeapon которых больше заданного"
        );
    }
    public void info() { // добавить класс
        CollectionManager.info();
    }
    public void show() {
        CollectionManager.show();
    }
    public void add() {
        CollectionManager.add(Creator.createSpaceMarine());
        System.out.println("Элемент добавлен в коллекцию");
    }

    public void update(String ID) {
        Integer id;
        try {
            id = Integer.parseInt(ID);
            if (Utils.checkExist(id)) {
                CollectionManager.update(Creator.createSpaceMarine(), id);
            } else {
                System.out.println("Элемента с таким id нет в коллекции");
            }
        } catch (NumberFormatException e) {
            System.out.println("Команда не выполнена. Вы ввели некорректный аргумент");
        }
    }

    public void removeById(String ID) {
        Integer id;
        try {
            id = Integer.parseInt(ID);
            CollectionManager.removeById(id);
        } catch (NumberFormatException e) {
            System.out.println("Команда не выполнена. Вы ввели некорректный аргумент");
        }
    }

    public void clear() {
        CollectionManager.clear();
        System.out.println("Коллекция успешно очищена");
    }

    public void save() {

        Parser_1.collectionToJson();
    }

    public void executeScript(String path) {
        String line;
        String command;
        ArrayList<String> parameters = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(path)), StandardCharsets.UTF_8))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(" ")[0].matches("add|update|")) {
                    command = line;
                    for (int i = 0; i < 15; i++) {
                        if (line != null) {
                            line = bufferedReader.readLine();
                            parameters.add(line);
                        } else {
                            System.out.println("Не хватает параметров для создания объекта.");
                            break;
                        }
                    }
                    SpaceMarine product = Creator.ScriptSpaceMarine(parameters);
                    switch (command.split(" ")[0]) {
                        case "add":
                            CollectionManager.add(product);
                            break;
                        case "update":
                            CollectionManager.update(product, Integer.parseInt(command.split(" ")[1]));
                    }
                } else if (line.split(" ")[0].equals("execute_script")
                        && line.split(" ")[1].equals(getPath())) {
                    System.out.println("Пресечена попытка рекурсивного вызова скрипта.");
                } else {
                    commandInvoker.executeCommand(line.split(" "));
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }

    public void exit() {
        System.out.println("Завершение работы программы (без сохранения в файл)");
        System.exit(0);
    }
    public void insertAt(String ind) {
        Integer index;
        try {
            index = Integer.parseInt(ind);
            CollectionManager.insertAt(index, Creator.createSpaceMarine());
        } catch (NumberFormatException e) {
            System.out.println("Команда не выполнена. Вы ввели некорректный аргумент");
        }
    }
    public void addIfMin() {
        CollectionManager.addIfMin(Creator.createSpaceMarine());
    }

    public void sort() {
        CollectionManager.sort();
        System.out.println("Коллекция успешно отсортирована.");
    }

    public void removeAnyByAchievements(String achievements) {
        CollectionManager.removeAnyByAchievements(achievements);
    }
    public void groupCountingByCoordinates() {
        if (!CollectionManager.getStack().isEmpty()) {
            CollectionManager.groupCountingByCoordinates();
        }
        else {
            System.out.println("Не удается выполнить команду. Коллекция пуста");
        }
    }
}


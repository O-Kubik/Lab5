package me.dasha.lab5.commands.concreteCommands;


import me.dasha.lab5.commands.Command;
import me.dasha.lab5.commands.CommandReceiver;

public class RemoveByAchievements extends Command {
    private CommandReceiver commandReceiver;
    public RemoveByAchievements(CommandReceiver commandReceiver){
        this.commandReceiver = commandReceiver;
    }
    @Override
    public void execute(String[] args) {
        if (args.length > 2) {
            System.out.println("Введен ненужный аргумент. Команда приведена к базовой команде remove_by_achievements %achievements%.");
        }
        commandReceiver.removeAnyByAchievements(args[1]);
    }

    @Override
    public void writeInfo() {
        System.out.println("Команда remove_by_achievements - удалить из коллекции один элемент, значение поля achievements которого эквивалентно заданному");
    }
}
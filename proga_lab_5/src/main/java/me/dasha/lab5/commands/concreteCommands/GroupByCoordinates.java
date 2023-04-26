package me.dasha.lab5.commands.concreteCommands;

import me.dasha.lab5.commands.Command;
import me.dasha.lab5.commands.CommandReceiver;

public class GroupByCoordinates extends Command {
    private final CommandReceiver commandReceiver;

    public GroupByCoordinates(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Введен ненужный аргумент");
        }
        commandReceiver.groupCountingByCoordinates();
    }

    @Override
    public void writeInfo() {
        System.out.println("group_counting_by_coordinates - сгруппировать элементы по значению coordinates, вывести количество элементов в каждой группе");
    }
}

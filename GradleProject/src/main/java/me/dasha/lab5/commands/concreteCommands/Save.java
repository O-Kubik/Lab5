package me.dasha.lab5.commands.concreteCommands;

//Сохранить коллекцию в файл

import me.dasha.lab5.commands.Command;
import me.dasha.lab5.commands.CommandReceiver;

public class Save extends Command {
    private final CommandReceiver commandReceiver;

    public Save(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Введен ненужный аргумент. Команда приведена к базовой команде save.");
        }
        commandReceiver.save();
    }

    @Override
    public void writeInfo() {
        System.out.println("Команда save сохраняет коллекцию в файл.");
    }
}
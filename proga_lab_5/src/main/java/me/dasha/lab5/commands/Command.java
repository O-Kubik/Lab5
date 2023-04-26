package me.dasha.lab5.commands;

//Абстрактный класс, для создания команд

public abstract class Command {


    public abstract void writeInfo();
    public abstract void execute(String[] args);

}
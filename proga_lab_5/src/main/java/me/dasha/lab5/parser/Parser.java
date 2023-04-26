package me.dasha.lab5.parser;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.dasha.lab5.collectionClasses.SpaceMarine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

//пишется новый парсер взамен parser_1
public class Parser {
    public SpaceMarine parse() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        try (FileReader reader = new FileReader("test.json")){
            SpaceMarine spaceMarine = gson.fromJson(reader, SpaceMarine.class);
            return spaceMarine;
        } catch (Exception e) {
            System.out.println("error " + e.toString());
        }
        return null;
    }

}

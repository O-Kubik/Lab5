package me.dasha.lab5.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import me.dasha.lab5.collection.CollectionManager;
import me.dasha.lab5.collectionClasses.SpaceMarine;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

public class Parser {
    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder
            .registerTypeAdapter(LocalDateTime.class, new TypeAdapter<LocalDateTime>() {
                @Override
                public void write(JsonWriter out, LocalDateTime value) throws IOException {
                    out.value(value.toString());
                }

                @Override
                public LocalDateTime read(JsonReader in) throws IOException {
                    return LocalDateTime.parse(in.nextString());
                }
            })
            .serializeNulls()
            .setPrettyPrinting()
            .enableComplexMapKeySerialization()
            .create();
    static String fileName;
    public static void collectionToJson() {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName))) {
            bos.write(gson.toJson(CollectionManager.getStack()).getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fromJsonToCollection(String fileName) {
        if (fileName != null) {
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));
                 Reader reader = new InputStreamReader(bufferedInputStream)) {
                CollectionManager.checkStack();
                List<SpaceMarine> spaceMarineList = gson.fromJson(reader, new TypeToken<List<SpaceMarine>>() {}.getType());
                if (spaceMarineList.size() > 0) {
                    for (SpaceMarine spaceMarine : spaceMarineList) {
                        CollectionManager.addJSONObject(spaceMarine);
                    }
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (SecurityException e) {
                System.out.println("Недостаточно прав для открытия файла.");
            } catch (NullPointerException e) {
                System.out.println("В файле нет объектов");
            } catch (com.google.gson.JsonSyntaxException e) {
                System.out.println("Ошибка в содержании файла " + e.getMessage());
            }
        } else {
            System.out.println("Имя файла не задано");
        }
    }
}

package me.dasha.lab5.collection;

import java.util.HashSet;
import java.util.Random;

public class GeneratorID {//TODO удаление id объектов, которые уже удалены
    private static HashSet<Integer> hashSetGenerateID = new HashSet<>();//используем set для хранения уникальный значений

    public static Integer generateID(){
        Integer id = new Random().nextInt(Integer.MAX_VALUE);//возвращает следующее случайное значение типа Int в диапазоне от 0 до n
        if (hashSetGenerateID.contains(id)){//проверить, содержит ли String другую подстроку или нет
            while (hashSetGenerateID.contains(id)){
                id = new Random().nextInt(Integer.MAX_VALUE);
            }
        }
        else {
            hashSetGenerateID.add(id);
        }
        return id;
    }

    public static Integer generateID(Integer ID){//используется для команды remove_by_id
        Integer id = ID;
        if (ID <= 0) {
            throw new IllegalArgumentException("ID должен быть больше 0");
        }
        if (!hashSetGenerateID.contains(id)) {
            throw new IllegalArgumentException("Элемента с таким ID не существует");
        }
        if (hashSetGenerateID.contains(id)) {
            hashSetGenerateID.remove(id);
        }
        return id;
    }
    public static void clearSet() {//для команды clear
        hashSetGenerateID.clear();
    }

    //
}

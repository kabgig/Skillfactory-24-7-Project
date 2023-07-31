package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.entities.Entity;

import java.util.List;
import java.util.stream.Stream;

public class JsonUtil {
    private JsonUtil() {
    }

    private static Gson getGson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson;
    }

    //SERIALIZATION------------------

    public static String serializeEntity(Entity entity){
        return getGson().toJson(entity);
    }

    public static Stream<String> serializeList(List<? extends Entity> entities){
        return entities.stream().map(entity ->serializeEntity(entity));
    }

    //DESERIALIZATION------------
    public static <E extends Entity> E deserializeJson(String entityJson, Class<E> clazz){
        return getGson().fromJson(entityJson, clazz);
    }

    public static <E extends Entity> List<E> deSerializeJsonsList(List<String> JsonList, Class<E> clazz){
        return JsonList.stream().map(Json -> deserializeJson(Json,clazz)).toList();
    }
}

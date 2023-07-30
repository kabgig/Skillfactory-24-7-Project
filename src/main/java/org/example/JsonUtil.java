package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    public static Entity deserializeJson(String entityJson, Class<? extends Entity> clazz){
        return getGson().fromJson(entityJson, clazz);
    }

    public static List<? extends Entity> deSerializeJsonsList(List<String> JsonList, Class<? extends Entity> clazz){
        return JsonList.stream().map(Json -> deserializeJson(Json,clazz)).toList();
    }
}

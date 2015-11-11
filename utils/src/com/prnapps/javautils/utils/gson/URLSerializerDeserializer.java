package com.prnapps.javautils.utils.gson;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.net.URL;

/**
 * Created by jimbo on 3/20/2015.
 */
public class URLSerializerDeserializer implements ISerializerDeserializer<URL> {
    @Override
    public URL deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            return new URL(jsonElement.getAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JsonElement serialize(URL data, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(data.toString());
    }
}

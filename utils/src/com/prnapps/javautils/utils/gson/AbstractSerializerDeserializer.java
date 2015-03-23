package com.prnapps.javautils.utils.gson;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by jimbo on 3/19/2015.
 */
public abstract class AbstractSerializerDeserializer<D> implements JsonSerializer<D>, JsonDeserializer<D> {
    @Override
    public abstract D deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException;
    @Override
    public abstract JsonElement serialize(D data, Type type, JsonSerializationContext jsonSerializationContext);
}

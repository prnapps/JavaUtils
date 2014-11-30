package com.prnapps.javautils.utils;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

/**
 * Created by jimbo on 11/29/2014.
 */
public abstract class AbstractJsonDeserializer<I> implements JsonDeserializer<I> {

    @Override
    public abstract I deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException;

    protected int getInt(JsonElement element) {
        if(element == null) return 0;
        return element.isJsonNull() ? 0 : element.getAsInt();
    }

    protected long getLong(JsonElement element) {
        if(element == null) return 0;
        return element.isJsonNull() ? 0 : element.getAsLong();
    }

    protected boolean getBoolean(JsonElement element) {
        if(element == null) return false;
        return element.isJsonNull() ? false : element.getAsBoolean();
    }

    protected String getString(JsonElement element) {
        if(element == null) return null;
        return element.isJsonNull() ? null : element.getAsString();
    }

    protected JsonObject getJsonObject(JsonElement element) {
        if(element == null) return null;
        return element.isJsonNull() ? null : element.getAsJsonObject();
    }

    protected JsonArray getJsonArray(JsonElement element) {
        if(element == null) return null;
        return element.isJsonNull() ? null : element.getAsJsonArray();
    }
}
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
        return getInt(element, 0);
    }

    protected int getInt(JsonElement element, int defaultValue) {
        if(element == null) return defaultValue;
        return element.isJsonNull() ? defaultValue : element.getAsInt();
    }

    protected long getLong(JsonElement element) {
        return getLong(element, 0);
    }

    protected long getLong(JsonElement element, long defaultValue) {
        if(element == null) return defaultValue;
        return element.isJsonNull() ? defaultValue : element.getAsLong();
    }

    protected boolean getBoolean(JsonElement element) {
        return getBoolean(element, false);
    }

    protected boolean getBoolean(JsonElement element, boolean defaultValue) {
        if(element == null) return defaultValue;
        return element.isJsonNull() ? defaultValue : element.getAsBoolean();
    }

    protected String getString(JsonElement element) {
        return getString(element, null);
    }

    protected String getString(JsonElement element, String defaultValue) {
        if(element == null) return defaultValue;
        return element.isJsonNull() ? defaultValue : element.getAsString();
    }

    protected JsonObject getJsonObject(JsonElement element) {
        return getJsonObject(element, null);
    }

    protected JsonObject getJsonObject(JsonElement element, JsonObject defaultValue) {
        if(element == null) return defaultValue;
        return element.isJsonNull() ? defaultValue : element.getAsJsonObject();
    }

    protected JsonArray getJsonArray(JsonElement element) {
        return getJsonArray(element, null);
    }

    protected JsonArray getJsonArray(JsonElement element, JsonArray defaultValue) {
        if(element == null) return defaultValue;
        return element.isJsonNull() ? defaultValue : element.getAsJsonArray();
    }
}
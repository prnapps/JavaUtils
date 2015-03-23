package com.prnapps.javautils.reddit.domain.other;

import com.google.gson.*;
import com.prnapps.javautils.reddit.domain.thing.ThingKind;
import com.prnapps.javautils.utils.gson.AbstractSerializerDeserializer;

import java.lang.reflect.Type;

/**
 * Created by jimbo on 3/19/2015.
 */
public class FullName {
    private ThingKind kind;
    private String id;

    @Override
    public String toString() {
        return kind + "_" + id;
    }

    public FullName setFullName(String fullName) {
        String[] strings = fullName.split("_", 2);
        this.kind = ThingKind.get(strings[0]);
        this.id = strings[1];
        return this;
    }

    // getters and setters
    public ThingKind getKind() {
        return kind;
    }
    public FullName setKind(ThingKind kind) {
        this.kind = kind;
        return this;
    }
    public String getId() {
        return id;
    }
    public FullName setId(String id) {
        this.id = id;
        return this;
    }

    public static class SerializerDeserializer extends AbstractSerializerDeserializer<FullName> {
        @Override
        public FullName deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            try {
                return new FullName().setFullName(jsonElement.getAsString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public JsonElement serialize(FullName data, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(data.toString());
        }
    }
}

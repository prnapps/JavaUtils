package com.prnapps.javautils.reddit.domain.thing;

import com.google.gson.*;
import com.prnapps.javautils.reddit.domain.other.FullName;
import com.prnapps.javautils.utils.gson.ISerializerDeserializer;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by jimbo on 3/19/2015.
 */
public class Thing {
    protected ThingKind kind;
    protected ThingData data;
    protected List<List<String>> errors;

    public String getFullname() {
        FullName fullName = new FullName().setKind(kind).setId(data.getId());
        return fullName.toString();
    }

    // getters and setters
    public ThingKind getKind() {
        return kind;
    }
    public Thing setKind(ThingKind kind) {
        this.kind = kind;
        return this;
    }
    public ThingData getData() {
        return data;
    }
    public Thing setData(ThingData data) {
        this.data = data;
        return this;
    }
    public List<List<String>> getErrors() {
        return errors;
    }
    public void setErrors(List<List<String>> errors) {
        this.errors = errors;
    }

    public static class SerializerDeserializer implements ISerializerDeserializer<Thing> {
        @Override
        public Thing deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            try {
                JsonObject object = jsonElement.getAsJsonObject();
                Thing thing = new Thing();
                thing.setKind((ThingKind) jsonDeserializationContext.deserialize(object.get("kind"), ThingKind.class));
                thing.setData((ThingData) jsonDeserializationContext.deserialize(object.get("data"), getDataClass(thing.getKind())));
                return thing;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public JsonElement serialize(Thing data, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("kind", new JsonPrimitive(data.getKind().toString()));
            jsonObject.add("data", jsonSerializationContext.serialize(data.getData()));
            return jsonObject;
        }

        private Class getDataClass(ThingKind kind) {
            switch (kind) {
                case COMMENT:
                    return Comment.class;
                case LINK:
                    return Link.class;
                case ACCOUNT:
                    return User.class;
                default:
                    return ThingData.class;
            }
        }
    }
}

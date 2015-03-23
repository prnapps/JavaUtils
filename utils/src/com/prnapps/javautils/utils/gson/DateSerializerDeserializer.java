package com.prnapps.javautils.utils.gson;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jimbo on 3/19/2015.
 */
public class DateSerializerDeserializer extends AbstractSerializerDeserializer<Date> {
    public static final String TIMESTAMP = "timestamp";

    private String dateFormat;

    @Override
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            if(TIMESTAMP.equals(dateFormat)) {
                return new Date(jsonElement.getAsLong()*1000);
            } else if(dateFormat != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
                return simpleDateFormat.parse(jsonElement.getAsString());
            }
            return new Date(jsonElement.getAsLong());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JsonElement serialize(Date data, Type type, JsonSerializationContext jsonSerializationContext) {
        if(TIMESTAMP.equals(dateFormat)) {
            return new JsonPrimitive(data.getTime() / 1000);
        } else if(dateFormat != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
            return new JsonPrimitive(simpleDateFormat.format(data));
        }
        return new JsonPrimitive(data.getTime());
    }

    public DateSerializerDeserializer setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }
}

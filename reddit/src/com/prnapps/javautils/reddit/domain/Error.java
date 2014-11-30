package com.prnapps.javautils.reddit.domain;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonParseException;
import com.prnapps.javautils.utils.AbstractJsonDeserializer;

import java.lang.reflect.Type;
import com.google.gson.JsonElement;

/**
 * Created by jimbo on 11/29/2014.
 */
public class Error {
    private String error;
    private String errorMessage;
    private String errorField;

    public Error() { }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorField() {
        return errorField;
    }

    public void setErrorField(String errorField) {
        this.errorField = errorField;
    }

    public String toString() {
        return error + ": " + errorMessage + " <" + errorField + ">";
    }

    public static class ErrorDeserializer extends AbstractJsonDeserializer<Error> {
        @Override
        public Error deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
            JsonArray array = getJsonArray(element);
            if(array != null) {
                Error error = new Error();
                error.setError(getString(array.get(0)));
                error.setErrorMessage(getString(array.get(1)));
                error.setErrorField(getString(array.get(2)));
                return error;
            }
            return null;
        }
    }
}

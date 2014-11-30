package com.prnapps.javautils.reddit.domain;

import java.lang.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.prnapps.javautils.utils.AbstractJsonDeserializer;

public class Errors {
	private List<Error> errors;

	public Errors() { }

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	
	public String toString() {
		return Arrays.toString(errors.toArray());
	}
	
	public static class ErrorsDeserializer extends AbstractJsonDeserializer<Errors> {
		@Override
		public Errors deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
			JsonArray array = getJsonArray(json);
			if(array != null) {
				List<Error> errorList = new ArrayList<Error>();
				for(JsonElement errorJson : array) {
					Error error = context.deserialize(errorJson, Error.class);
					if(error != null) {
						errorList.add(error);
					}
				}
				if(errorList.size() > 0) {
					Errors errors = new Errors();
					errors.setErrors(errorList);
					return errors;
				}
			}
			return null;
		}
	}
}

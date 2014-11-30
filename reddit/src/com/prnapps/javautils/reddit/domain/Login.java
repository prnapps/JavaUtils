package com.prnapps.javautils.reddit.domain;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.prnapps.javautils.utils.AbstractJsonDeserializer;

public class Login {
	private final String LOGIN_CONTENT_FORMAT = "api_type=json&user=%s&passwd=%s&rem=true";
	
	private String username;
	private String password;
	private String cookie;
	private String modhash;
	private boolean needHttps;
	private Errors errors;

	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getModhash() {
		return modhash;
	}

	public void setModhash(String modhash) {
		this.modhash = modhash;
	}

	public boolean getNeedHttps() {
		return needHttps;
	}

	public void setNeedHttps(boolean needHttps) {
		this.needHttps = needHttps;
	}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}

	public String getContentForm() {
		return String.format(LOGIN_CONTENT_FORMAT, username, password);
	}
	
	public static class LoginDeserializer extends AbstractJsonDeserializer<Login> {
		private Login login;
		
		public LoginDeserializer(Login login) {
			this.login = login;
		}
		
		@Override
		public Login deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
			JsonObject object = getJsonObject(element);
			if(object != null) {
				JsonObject json = getJsonObject(object.get("json"));
				if(json != null) {
					login.setErrors((Errors) context.deserialize(json.get("errors"), Errors.class));
					JsonObject data = getJsonObject(json.get("data"));
					if(data != null) {
						login.setNeedHttps(getBoolean(data.get("need_https")));
						login.setModhash(getString(data.get("modhash")));
						login.setCookie(getString(data.get("cookie")));
					}
				}
			}
			return login;
		}
	}
}

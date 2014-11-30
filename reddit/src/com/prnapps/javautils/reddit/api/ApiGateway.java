package com.prnapps.javautils.reddit.api;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prnapps.javautils.connection.*;
import com.prnapps.javautils.reddit.domain.Errors;
import com.prnapps.javautils.reddit.domain.Error;
import com.prnapps.javautils.reddit.domain.Login;
import com.prnapps.javautils.reddit.domain.listing.Saved;
import com.prnapps.javautils.reddit.domain.thing.Comment;
import com.prnapps.javautils.reddit.domain.thing.Link;
import com.prnapps.javautils.reddit.domain.thing.Media;

public class ApiGateway {
	private final String LOGIN_URL = "http://www.reddit.com/api/login";
	private final String SAVED_URL_FORMAT = "http://www.reddit.com/user/%s/saved.json";

    public Login login(Login login) throws ConnectionException, IOException {
    	ConnectionBuilder connection = new ConnectionBuilder()
			.setUrl(LOGIN_URL)
			.setMethod(ConnectionMethod.POST)
			.setContent(login.getContentForm(), ContentType.FORM)
			.setAcceptType(ContentType.JSON);
		ConnectionResponse response = ConnectionResponse.parseResponse(connection.connect());
		Gson gson = new GsonBuilder()
		    .registerTypeAdapter(Login.class, new Login.LoginDeserializer(login))
		    .registerTypeAdapter(Errors.class, new Errors.ErrorsDeserializer())
		    .registerTypeAdapter(Error.class, new Error.ErrorDeserializer())
		    .create();
		return gson.fromJson(response.getResponseBody(), Login.class);
    }
    
    public Saved saved(Login login) throws ConnectionException, IOException {
		ConnectionBuilder connection = new ConnectionBuilder()
			.setUrl(String.format(SAVED_URL_FORMAT, login.getUsername()))
			.setCookie("reddit_session=" + login.getCookie())
			.addCustomHeader("X-Modhash", login.getModhash());
		ConnectionResponse response = ConnectionResponse.parseResponse(connection.connect());
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(Saved.class, new Saved.SavedDeserializer())
				.registerTypeAdapter(Errors.class, new Errors.ErrorsDeserializer())
				.registerTypeAdapter(Error.class, new Error.ErrorDeserializer())
				.registerTypeAdapter(Comment.class, new Comment.CommentDeserializer())
				.registerTypeAdapter(Link.class, new Link.LinkDeserializer())
				.registerTypeAdapter(Media.class, new Media.MediaDeserializer())
				.create();
		return gson.fromJson(response.getResponseBody(), Saved.class);
    }
}

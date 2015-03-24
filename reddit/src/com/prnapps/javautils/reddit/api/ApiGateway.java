package com.prnapps.javautils.reddit.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prnapps.javautils.connection.ConnectionException;
import com.prnapps.javautils.connection.ConnectionResponse;
import com.prnapps.javautils.reddit.domain.listing.Listing;
import com.prnapps.javautils.reddit.domain.login.LoginContainer;
import com.prnapps.javautils.reddit.domain.login.Login;
import com.prnapps.javautils.reddit.domain.other.FullName;
import com.prnapps.javautils.reddit.domain.thing.Thing;
import com.prnapps.javautils.utils.gson.DateSerializerDeserializer;
import com.prnapps.javautils.utils.gson.URLSerializerDeserializer;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

/**
 * Created by jimbo on 3/20/2015.
 */
public class ApiGateway {
    private String userAgent;

    public Login login(String username, String password) throws IOException, ConnectionException {
        LoginRequestManager loginRequestManager = new LoginRequestManager()
                .setUsername(username)
                .setPassword(password);
        return getLogin(loginRequestManager);
    }

    public Listing saved(Login login) throws ConnectionException, IOException {
        IRequestManager savedRequestManager = new SavedRequestManager()
                .setLogin(login);
        return getListing(savedRequestManager);
    }

    public Listing subreddit(String subredditName) throws ConnectionException, IOException {
        return subreddit(subredditName, SubredditRequestManager.Order.HOT);
    }

    public Listing subreddit(String subredditName, SubredditRequestManager.Order subredditOrder) throws ConnectionException, IOException {
        IRequestManager requestManager = new SubredditRequestManager()
                .setSubredditName(subredditName)
                .setSubredditOrder(subredditOrder);
        return getListing(requestManager);
    }

    public Login getLogin(LoginRequestManager loginRequestManager) throws ConnectionException, IOException {
        ConnectionResponse response = loginRequestManager.request(userAgent);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        LoginContainer loginContainer = gson.fromJson(response.getResponseBody(), LoginContainer.class);
        return loginContainer.getJson().setUsername(loginRequestManager.getUsername());
    }

    public Listing getListing(IRequestManager requestManager) throws ConnectionException, IOException {
        ConnectionResponse response = requestManager.request(userAgent);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Thing.class, new Thing.SerializerDeserializer())
                .registerTypeAdapter(FullName.class, new FullName.SerializerDeserializer())
                .registerTypeAdapter(Date.class, new DateSerializerDeserializer().setDateFormat(DateSerializerDeserializer.TIMESTAMP))
                .registerTypeAdapter(URL.class, new URLSerializerDeserializer())
                .create();
        return gson.fromJson(response.getResponseBody(), Listing.class);
    }

    public String getUserAgent() {
        return userAgent;
    }
    public ApiGateway setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

}
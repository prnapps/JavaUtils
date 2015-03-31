package com.prnapps.javautils.reddit.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;
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
    private final String userAgent;

    public ApiGateway(String userAgent) {
        this.userAgent = userAgent;
    }

    public Login login(String username, String password) throws IOException, HttpException {
        LoginRequestManager loginRequestManager = new LoginRequestManager(username, password);
        return getLogin(loginRequestManager);
    }

    public Listing saved(Login login) throws HttpException, IOException {
        IRequestManager savedRequestManager = new SavedRequestManager(login);
        return getListing(savedRequestManager);
    }

    public Listing subreddit(String subredditName) throws HttpException, IOException {
        IRequestManager requestManager = new SubredditRequestManager(subredditName);
        return getListing(requestManager);
    }

    public Listing subreddit(String subredditName, String subredditOrder) throws HttpException, IOException {
        IRequestManager requestManager = new SubredditRequestManager(subredditName)
                .setSubredditOrder(subredditOrder);
        return getListing(requestManager);
    }

    public Listing subreddit(String subredditName, String subredditOrder, String before, String after, String limit, String count, String show)
            throws HttpException, IOException {
        IRequestManager requestManager = new SubredditRequestManager(subredditName)
                .setSubredditOrder(subredditOrder)
                .setBefore(before)
                .setAfter(after)
                .setLimit(limit)
                .setCount(count)
                .setShow(show);
        return getListing(requestManager);
    }

    public Login getLogin(LoginRequestManager loginRequestManager) throws HttpException, IOException {
        HttpResponse response = loginRequestManager.request(userAgent);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        LoginContainer loginContainer = gson.fromJson(response.getResponseBody(), LoginContainer.class);
        return loginContainer.getJson().setUsername(loginRequestManager.getUsername());
    }

    public Listing getListing(IRequestManager requestManager) throws HttpException, IOException {
        HttpResponse response = requestManager.request(userAgent);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Thing.class, new Thing.SerializerDeserializer())
                .registerTypeAdapter(FullName.class, new FullName.SerializerDeserializer())
                .registerTypeAdapter(Date.class, new DateSerializerDeserializer().setDateFormat(DateSerializerDeserializer.TIMESTAMP))
                .registerTypeAdapter(URL.class, new URLSerializerDeserializer())
                .create();
        return gson.fromJson(response.getResponseBody(), Listing.class);
    }

}
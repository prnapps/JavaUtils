package com.prnapps.javautils.reddit.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;
import com.prnapps.javautils.reddit.api.endpoints.IRequest;
import com.prnapps.javautils.reddit.api.endpoints.LoginRequest;
import com.prnapps.javautils.reddit.api.endpoints.SavedRequest;
import com.prnapps.javautils.reddit.api.endpoints.SubredditRequest;
import com.prnapps.javautils.reddit.domain.listing.Listing;
import com.prnapps.javautils.reddit.domain.login.LoginContainer;
import com.prnapps.javautils.reddit.domain.login.Login;
import com.prnapps.javautils.reddit.domain.other.FullName;
import com.prnapps.javautils.reddit.domain.other.Order;
import com.prnapps.javautils.reddit.domain.other.Period;
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
        LoginRequest endPoint = new LoginRequest(userAgent)
                .setUsername(username)
                .setPassword(password);
        return getLogin(endPoint);
    }

    public Listing saved(Login login) throws HttpException, IOException {
        IRequest endPoint = new SavedRequest(userAgent).setLogin(login);
        return getListing(endPoint);
    }

    public Listing subreddit(String subredditName) throws HttpException, IOException {
        IRequest endPoint = new SubredditRequest(userAgent).setSubredditName(subredditName);
        return getListing(endPoint);
    }

    public Listing subreddit(String subredditName, Order subredditOrder) throws HttpException, IOException {
        IRequest endPoint = new SubredditRequest(userAgent)
                .setSubredditName(subredditName)
                .setSubredditOrder(subredditOrder);
        return getListing(endPoint);
    }

    public Listing subreddit(String subredditName, Order subredditOrder, String before, String after, String limit, String count,
                             String show, Period period) throws HttpException, IOException {
        IRequest endPoint = new SubredditRequest(userAgent)
                .setSubredditName(subredditName)
                .setSubredditOrder(subredditOrder)
                .setBefore(before)
                .setAfter(after)
                .setLimit(limit)
                .setCount(count)
                .setShow(show)
                .setPeriod(period);
        return getListing(endPoint);
    }

    public Login getLogin(LoginRequest endPoint) throws HttpException, IOException {
        HttpResponse response = endPoint.request();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        LoginContainer loginContainer = gson.fromJson(response.getResponseBody(), LoginContainer.class);
        return loginContainer.getJson().setUsername(endPoint.getUsername());
    }

    public Listing getListing(IRequest endPoint) throws HttpException, IOException {
        HttpResponse response = endPoint.request();
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
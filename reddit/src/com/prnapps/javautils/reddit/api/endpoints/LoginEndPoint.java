package com.prnapps.javautils.reddit.api.endpoints;

import com.prnapps.javautils.http.*;

import java.io.IOException;

/**
 * Created by jimbo on 3/20/2015.
 */
public class LoginEndPoint implements IEndPoint {
    private final String LOGIN_URL = "http://www.reddit.com/listing/login";
    private final String LOGIN_CONTENT_FORMAT = "api_type=json&user=%s&passwd=%s&rem=true";

    private final String username;
    private final String password;

    public LoginEndPoint(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public HttpResponse request(String userAgent) throws IOException, HttpException {
        HttpBuilder connection = new HttpBuilder()
                .setUrl(LOGIN_URL)
                .setMethod(HttpMethod.POST)
                .setContent(String.format(LOGIN_CONTENT_FORMAT, username, password), HttpContent.FORM)
                .setAcceptType(HttpContent.JSON)
                .setUserAgent(userAgent);
        return HttpResponse.parseResponse(connection.connect());
    }

    public String getUsername() {
        return username;
    }

}

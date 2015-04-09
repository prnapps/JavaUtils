package com.prnapps.javautils.reddit.api.endpoints;

import com.prnapps.javautils.http.*;

import java.io.IOException;

/**
 * Created by jimbo on 3/20/2015.
 */
public class LoginRequest implements IRequest {
    private final String LOGIN_URL = "http://www.reddit.com/listing/login";
    private final String LOGIN_CONTENT_FORMAT = "api_type=json&user=%s&passwd=%s&rem=true";

    private final String userAgent;
    private String username;
    private String password;

    public LoginRequest(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public HttpResponse request() throws IOException, HttpException {
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
    public LoginRequest setUsername(String username) {
        this.username = username;
        return this;
    }
    public LoginRequest setPassword(String password) {
        this.password = password;
        return this;
    }

}

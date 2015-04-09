package com.prnapps.javautils.reddit.api.endpoints;

import com.prnapps.javautils.http.HttpBuilder;
import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;
import com.prnapps.javautils.reddit.domain.login.Login;

import java.io.IOException;

/**
 * Created by jimbo on 3/20/2015.
 */
public class SavedRequest implements IRequest {
    private final String URL_FORMAT = "http://www.reddit.com/user/%s/saved.json";

    private final String userAgent;
    private Login login;

    public SavedRequest(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public HttpResponse request() throws HttpException, IOException {
        HttpBuilder connection = new HttpBuilder()
                .setUrl(String.format(URL_FORMAT, login.getUsername()))
                .setCookie("reddit_session=" + login.getCookie())
                .addCustomHeader("X-Modhash", login.getModhash())
                .setUserAgent(userAgent);
        return HttpResponse.parseResponse(connection.connect());
    }

    public Login getLogin() {
        return login;
    }
    public SavedRequest setLogin(Login login) {
        this.login = login;
        return this;
    }

}

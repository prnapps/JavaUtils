package com.prnapps.javautils.reddit.api;

import com.prnapps.javautils.http.HttpBuilder;
import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;
import com.prnapps.javautils.reddit.domain.login.Login;

import java.io.IOException;

/**
 * Created by jimbo on 3/20/2015.
 */
public class SavedRequestManager implements IRequestManager {
    private final String URL_FORMAT = "http://www.reddit.com/user/%s/saved.json";

    private Login login;

    @Override
    public HttpResponse request(String userAgent) throws HttpException, IOException {
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
    public SavedRequestManager setLogin(Login login) {
        this.login = login;
        return this;
    }

}

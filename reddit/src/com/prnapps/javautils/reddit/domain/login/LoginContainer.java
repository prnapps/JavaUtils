package com.prnapps.javautils.reddit.domain.login;

import com.google.gson.annotations.Expose;

/**
 * Created by jimbo on 3/20/2015.
 */
public class LoginContainer {
    @Expose
    protected Login json;

    public Login getJson() {
        return json;
    }
    public void setJson(Login json) {
        this.json = json;
    }

}

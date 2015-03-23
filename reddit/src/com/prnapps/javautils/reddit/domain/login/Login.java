package com.prnapps.javautils.reddit.domain.login;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by jimbo on 3/20/2015.
 */
public class Login {
    private String username;
    @Expose
    protected LoginData data;
    @Expose
    protected List<List<String>> errors;

    public String getUsername() {
        return username;
    }
    public Login setUsername(String username) {
        this.username = username;
        return this;
    }
    public LoginData getData() {
        return data;
    }
    public void setData(LoginData data) {
        this.data = data;
    }
    public List<List<String>> getErrors() {
        return errors;
    }
    public void setErrors(List<List<String>> errors) {
        this.errors = errors;
    }
    public String getCookie() {
        if(data == null) {
            return null;
        }
        return data.getCookie();
    }
    public String getModhash() {
        if(data == null) {
            return null;
        }
        return data.getModhash();
    }

}

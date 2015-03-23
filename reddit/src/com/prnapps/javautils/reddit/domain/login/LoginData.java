package com.prnapps.javautils.reddit.domain.login;

import com.google.gson.annotations.Expose;

/**
 * Created by jimbo on 3/20/2015.
 */
public class LoginData {
    @Expose
    protected boolean needHttps;
    @Expose
    protected String modhash;
    @Expose
    protected String cookie;

    public boolean getNeedHttps() {
        return needHttps;
    }
    public void setNeedHttps(boolean needHttps) {
        this.needHttps = needHttps;
    }
    public String getModhash() {
        return modhash;
    }
    public void setModhash(String modhash) {
        this.modhash = modhash;
    }
    public String getCookie() {
        return cookie;
    }
    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

}

package com.prnapps.javautils.imgur.domain;

import com.google.gson.annotations.Expose;

/**
 * Created by jimbo on 3/31/2015.
 */
public class Error {
    @Expose
    private String error;
    @Expose
    private String request;
    @Expose
    private String method;

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String getRequest() {
        return request;
    }
    public void setRequest(String request) {
        this.request = request;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }

}

package com.prnapps.javautils.http;

/**
* Created by jimbo on 11/29/2014.
*/
public enum HttpMethod {
    GET ("GET", false),
    POST ("POST", true),
    HEAD ("HEAD", false),
    OPTIONS ("OPTIONS", false),
    PUT ("PUT", true),
    DELETE ("DELETE", false),
    TRACE ("TRACE", false);

    private String string;
    private boolean allowsContent;

    HttpMethod(String string, boolean allowsContent) {
        this.string = string;
        this.allowsContent = allowsContent;
    }

    @Override
    public String toString() {
        return string;
    }
    public boolean allowsContent() {
        return allowsContent;
    }

}
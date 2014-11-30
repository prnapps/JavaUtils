package com.prnapps.javautils.connection;

/**
* Created by jimbo on 11/29/2014.
*/
public enum ConnectionMethod {
    GET ("GET", false),
    POST ("POST", true),
    HEAD ("HEAD", false),
    OPTIONS ("OPTIONS", false),
    PUT ("PUT", true),
    DELETE ("DELETE", false),
    TRACE ("TRACE", false);

    private String string;
    private boolean allowsContent;

    ConnectionMethod(String string, boolean allowsContent) {
        this.string = string;
        this.allowsContent = allowsContent;
    }

    public String toString() {
        return string;
    }

    public boolean allowsContent() {
        return allowsContent;
    }
}

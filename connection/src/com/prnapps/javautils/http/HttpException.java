package com.prnapps.javautils.http;

/**
 * Created by jimbo on 11/29/2014.
 */
public class HttpException extends Exception {
    private int statusCode;

    public HttpException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}

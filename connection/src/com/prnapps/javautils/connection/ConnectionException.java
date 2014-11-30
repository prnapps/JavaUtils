package com.prnapps.javautils.connection;

/**
 * Created by jimbo on 11/29/2014.
 */
public class ConnectionException extends Exception {
    private int statusCode;

    public ConnectionException(int statusCode, String message) {
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

package com.prnapps.javautils.http;

/**
* Created by jimbo on 11/29/2014.
*/
public enum HttpContent {
    JSON ("application/json"),
    XML ("text/xml"),
    HTML ("text/html"),
    TEXT ("text/plain"),
    FORM ("application/x-www-form-urlencoded"),
    MP3 ("audio/mpeg"),
    M4A ("audio/mp4"),
    MP4 ("video/mp4");

    private String string;

    HttpContent(String string) {
        this.string = string;
    }

    public String toString() {
        return string;
    }
}

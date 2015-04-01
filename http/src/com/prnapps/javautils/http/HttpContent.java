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
    AIFF ("audio/x-aiff"),
    WAV ("audio/x-wav"),
    MP4 ("video/mp4"),
    MOV ("video/quicktime"),
    MPG ("video/mpeg"),
    JPG ("image/jpeg"),
    GIF ("image/gif"),
    BMP ("image/bmp"),
    TIFF ("image/tiff"),
    WORD ("application/msword"),
    EXCEL ("application/vnd.ms-excel"),
    POWERPOINT ("application/vnd.ms-powerpoint"),
    PDF ("application/pdf"),
    ZIP ("application/zip");

    private String string;

    HttpContent(String string) {
        this.string = string;
    }

    public String toString() {
        return string;
    }

    public static HttpContent get(String string) {
        for(HttpContent type : HttpContent.values()) {
            if(type.toString().equals(string)) {
                return type;
            }
        }
        return null;
    }

}

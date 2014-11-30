package com.prnapps.javautils.utils;

/**
 * Created by jimbo on 11/29/2014.
 */
public class NameValuePair {
    private String name;
    private String value;

    public NameValuePair(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public NameValuePair setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public NameValuePair setValue(String value) {
        this.value = value;
        return this;
    }

    public String toString() {
        return name + ": " + value;
    }
    public String toJson() {
        return "\"" + name + "\": \"" + value + "\"";
    }
    public String toXml() {
        return "<" + name + ">" + value + "</" + name + ">";
    }
}

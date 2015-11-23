package com.prnapps.javautils.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimbo on 11/29/2014.
 */
public class NameValuePair {
    private String name;
    private Object value;

    public NameValuePair(){}

    public NameValuePair(String name, Object value) {
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
    public Object getValue() {
        return value;
    }
    public NameValuePair setValue(Object value) {
        this.value = value;
        return this;
    }

    public String toString() {
        return name + ": " + value;
    }

    public String toJson() {
        String name = this.name.replace(" ", "_");
        if(value == null || value instanceof Number || value instanceof Boolean) {
            return "\"" + name + "\": " + value;
        }
        return "\"" + name + "\": \"" + value + "\"";
    }

    public String toXml() {
        String name = this.name
                .replace(" ", "_")
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
        if(value == null) {
            return "<" + name + " />";
        }
        String value = this.value.toString()
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
        return "<" + name + ">" + value + "</" + name + ">";
    }

    public String toUrlParam() throws UnsupportedEncodingException {
        if(value == null) {
            return URLEncoder.encode(name, "UTF-8") + "=";
        }
        return URLEncoder.encode(name, "UTF-8") + "=" + URLEncoder.encode(value.toString(), "UTF-8");
    }

    public static String toJson(NameValuePair...pairs) {
        StringUtils utils = new StringUtils();
        List<String> params = new ArrayList<>();
        for(NameValuePair pair : pairs) {
            params.add(pair.toJson());
        }
        return utils.combineStrings(",\n", params);
    }

    public static String toXml(NameValuePair...pairs) {
        StringUtils utils = new StringUtils();
        List<String> params = new ArrayList<>();
        for(NameValuePair pair : pairs) {
            params.add(pair.toXml());
        }
        return utils.combineStrings(",\n", params);
    }

    public static String toUrlParams(NameValuePair...pairs) throws UnsupportedEncodingException {
        StringBuilder builder = new StringBuilder();
        if(pairs.length > 0) {
            builder.append("?");
        }
        StringUtils utils = new StringUtils();
        List<String> params = new ArrayList<>();
        for(NameValuePair pair : pairs) {
            params.add(pair.toUrlParam());
        }
        builder.append(utils.combineStrings("&", params));
        return builder.toString();
    }

}

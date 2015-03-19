package com.prnapps.javautils.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jimbo on 11/30/2014.
 */
public class StringUtils {
    public boolean isNullOrEmpty(String str) {
        if (str == null) return true;
        return str.isEmpty();
    }

    public String combineStrings(String between, String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            if(!isNullOrEmpty(string)) {
                if (!isNullOrEmpty(builder.toString())) {
                    if(!isNullOrEmpty(between)) {
                        builder.append(between);
                    }
                }
                builder.append(string);
            }
        }
        return builder.toString();
    }

    public String toTitleCase(String input) {
        if(isNullOrEmpty(input)) {
            return input;
        }
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;
        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c) || c == '(' || c == '-' || c == '/' || c == '\\') {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }
            titleCase.append(c);
        }
        return titleCase.toString();
    }

    public String findPattern(String body, String regex) {
        if(isNullOrEmpty(body)) {
            return null;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(body);
        if(m.find()) {
            return m.group();
        }
        return null;
    }

    public List<String> findAllPatterns(String body, String regex) {
        if(isNullOrEmpty(body)) {
            return null;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(body);
        List<String> list = new ArrayList<String>();
        while(m.find()) {
            list.add(m.group());
        }
        return list;
    }
}

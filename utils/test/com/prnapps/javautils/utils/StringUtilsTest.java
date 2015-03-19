package com.prnapps.javautils.utils;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimbo on 11/30/2014.
 */
public class StringUtilsTest extends TestCase {
    private StringUtils stringUtils;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        stringUtils = new StringUtils();
    }

    public void testIsNullOrEmpty() {
        String test1 = null;
        String test2 = "";
        String test3 = "test";
        assertTrue(stringUtils.isNullOrEmpty(test1));
        assertTrue(stringUtils.isNullOrEmpty(test2));
        assertFalse(stringUtils.isNullOrEmpty(test3));
    }

    public void testCombineStrings() {
        String string1 = "hi";
        String string2 = "world";
        assertEquals(stringUtils.combineStrings(" ", string1, string2), "hi world");
        assertEquals(stringUtils.combineStrings(" ", null, string2), "world");
        assertEquals(stringUtils.combineStrings(" ", null, null), "");
        assertEquals(stringUtils.combineStrings(null, string1, string2), "hiworld");
    }

    public void testToTitleCase() {
        String string1 = "test title case string";
        String string2 = "test title case string (another-one)";
        String string3 = "test title case string\\number-\\three";
        assertNull(stringUtils.toTitleCase(null));
        assertEquals(stringUtils.toTitleCase(""), "");
        assertEquals(stringUtils.toTitleCase(string1), "Test Title Case String");
        assertEquals(stringUtils.toTitleCase(string2), "Test Title Case String (Another-One)");
        assertEquals(stringUtils.toTitleCase(string3), "Test Title Case String\\Number-\\Three");
    }

    public void testFindPattern() {
        String body = "1aa;dlkfj;kla2bsj;df";
        String pattern = "[0-9][a-z]";
        assertNull(stringUtils.findPattern(null, pattern));
        assertEquals(stringUtils.findPattern(body, pattern), "1a");
    }

    public void testFindAllPatterns() {
        String body = "1aa;dlkfj;kla2bsj;df";
        String pattern = "[0-9][a-z]";
        List<String> list = new ArrayList<String>();
        list.add("1a");
        list.add("2b");
        assertNull(stringUtils.findAllPatterns(null, pattern));
        assertEquals(stringUtils.findAllPatterns(body, pattern), list);
    }
}

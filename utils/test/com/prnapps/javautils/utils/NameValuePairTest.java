package com.prnapps.javautils.utils;

import junit.framework.TestCase;

/**
 * Created by jimbo on 11/30/2014.
 */
public class NameValuePairTest extends TestCase {
    private NameValuePair pair;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        pair = new NameValuePair("test name", "test value");
    }

    public void testToString() {
        assertEquals(pair.toString(), "test name: test value");
    }

    public void testToJson() {
        assertEquals(pair.toJson(), "\"test name\": \"test value\"");
    }

    public void testToXml() {
        assertEquals(pair.toXml(), "<test name>test value</test name>");
    }
}
package com.prnapps.javautils.utils;

import junit.framework.TestCase;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.UnsupportedEncodingException;

/**
 * Created by jimbo on 11/30/2014.
 */
public class NameValuePairTest extends TestCase {
    private NameValuePair pair1;
    private NameValuePair pair2;
    private NameValuePair pair3;
    private NameValuePair pair4;
    private NameValuePair pair5;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        pair1 = new NameValuePair().setName("test name").setValue("test value");
        pair2 = new NameValuePair().setName("test name").setValue(1);
        pair3 = new NameValuePair().setName("test name").setValue(true);
        pair4 = new NameValuePair().setName("test name").setValue(null);
        pair5 = new NameValuePair().setName("test name").setValue(3.1415);
    }

    public void testToString() {
        assertEquals(pair1.toString(), "test name: test value");
        assertEquals(pair2.toString(), "test name: 1");
        assertEquals(pair3.toString(), "test name: true");
        assertEquals(pair4.toString(), "test name: null");
        assertEquals(pair5.toString(), "test name: 3.1415");
    }

    public void testToJson() {
        assertEquals(pair1.toJson(), "\"test_name\": \"test value\"");
        assertEquals(pair2.toJson(), "\"test_name\": 1");
        assertEquals(pair3.toJson(), "\"test_name\": true");
        assertEquals(pair4.toJson(), "\"test_name\": null");
        assertEquals(pair5.toJson(), "\"test_name\": 3.1415");
    }

    public void testToXml() {
        try {
            assertEquals(pair1.toXml(), "<test_name>test value</test_name>");
            assertEquals(pair2.toXml(), "<test_name>1</test_name>");
            assertEquals(pair3.toXml(), "<test_name>true</test_name>");
            assertEquals(pair4.toXml(), "<test_name />");
            assertEquals(pair5.toXml(), "<test_name>3.1415</test_name>");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            assertTrue(false);
        } catch (TransformerException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    public void testToUrlParam() {
        try {
            assertEquals(pair1.toUrlParam(), "test+name=test+value");
            assertEquals(pair2.toUrlParam(), "test+name=1");
            assertEquals(pair3.toUrlParam(), "test+name=true");
            assertEquals(pair4.toUrlParam(), "test+name=");
            assertEquals(pair5.toUrlParam(), "test+name=3.1415");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    public void testListToJson() {
        assertEquals(NameValuePair.toJson(pair1, pair2, pair3, pair4, pair5),
                "\"test_name\": \"test value\",\n\"test_name\": 1,\n\"test_name\": true,\n\"test_name\": null,\n\"test_name\": 3.1415");
    }

    public void testListToXml() {
        try {
            assertEquals(NameValuePair.toXml(pair1, pair2, pair3, pair4, pair5),
                    "<test_name>test value</test_name>\n<test_name>1</test_name>\n<test_name>true</test_name>\n<test_name />\n<test_name>3.1415</test_name>");
        } catch (TransformerException e) {
            e.printStackTrace();
            assertTrue(false);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    public void testListToUrlParam() {
        try {
            assertEquals(NameValuePair.toUrlParams(pair1, pair2, pair3, pair4, pair5),
                    "?test+name=test+value&test+name=1&test+name=true&test+name=&test+name=3.1415");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
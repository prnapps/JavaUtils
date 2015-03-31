package com.prnapps.javautils.http;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * Created by jimbo on 3/30/2015.
 */
public class HttpBuilderTest extends TestCase {
    public void testHttp() {
        String url = "http://web.missouri.edu/~cookjer/infotest.xml";
        try {
            HttpBuilder connection = new HttpBuilder()
                    .setUrl(url)
                    .setUserAgent("test");
            HttpResponse response = HttpResponse.parseResponse(connection.connect());
            assertEquals(response.getResponseBody(), "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><information><item><title>Meet the Leaders</title><link>http://newstudent.missouri.edu/meet-the-leaders/</link></item><item><title>List of Majors</title><link>http://majors.missouri.edu</link></item><item><title>General Education Requirements</title><link>http://generaleducation.missouri.edu/requirements/index.php</link></item><item><title>Summer Welcome Evaluations</title><link>http://newstudent.missouri.edu/evaluations/</link></item><item><title>Rollins Dining Hall Menu</title><link>https://webservices.doit.missouri.edu/goMizzouImages/specialevents/summerwelcome/rollinsweek-3-2013.pdf</link></item></information>");
        } catch (IOException | HttpException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    public void testHttps() {
        String url = "https://web.missouri.edu/~cookjer/infotest.xml";
        try {
            HttpBuilder connection = new HttpBuilder()
                    .setUrl(url)
                    .setUserAgent("test");
            HttpResponse response = HttpResponse.parseResponse(connection.connect());
            assertEquals(response.getResponseBody(), "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?><information><item><title>Meet the Leaders</title><link>http://newstudent.missouri.edu/meet-the-leaders/</link></item><item><title>List of Majors</title><link>http://majors.missouri.edu</link></item><item><title>General Education Requirements</title><link>http://generaleducation.missouri.edu/requirements/index.php</link></item><item><title>Summer Welcome Evaluations</title><link>http://newstudent.missouri.edu/evaluations/</link></item><item><title>Rollins Dining Hall Menu</title><link>https://webservices.doit.missouri.edu/goMizzouImages/specialevents/summerwelcome/rollinsweek-3-2013.pdf</link></item></information>");
        } catch (IOException | HttpException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}

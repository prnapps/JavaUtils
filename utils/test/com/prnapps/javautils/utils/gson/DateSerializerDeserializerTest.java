package com.prnapps.javautils.utils.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Date;

/**
 * Created by jimbo on 3/20/2015.
 */
public class DateSerializerDeserializerTest extends TestCase {
    private String testDate1 = "\"Mar 13, 2015 3:15 pm\"";
    private String testDate2 = "\"1411833792\"";

    public void testDateformatDeserialize() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateSerializerDeserializer().setDateFormat("MMM d, yyyy H:mm a"))
                .create();
        Date date = gson.fromJson(testDate1, Date.class);
        Assert.assertTrue(date != null);
    }

    public void testTimestampDeserialize() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateSerializerDeserializer().setDateFormat(DateSerializerDeserializer.TIMESTAMP))
                .create();
        Date date = gson.fromJson(testDate2, Date.class);
        Assert.assertTrue(date != null);
    }

    public void testDefaultDeserialize() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateSerializerDeserializer())
                .create();
        long time = (new Date()).getTime();
        Date date = gson.fromJson(Long.toString(time), Date.class);
        Assert.assertTrue(date != null);
    }
}

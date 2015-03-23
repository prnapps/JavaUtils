package com.prnapps.javautils.reddit.domain.thing;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prnapps.javautils.reddit.domain.other.FullName;
import com.prnapps.javautils.utils.gson.DateSerializerDeserializer;
import com.prnapps.javautils.utils.gson.URLSerializerDeserializer;
import junit.framework.TestCase;
import org.junit.Assert;

import java.net.URL;
import java.util.Date;

/**
 * Created by jimbo on 3/20/2015.
 */
public class UserTest extends TestCase {
    String json = "{\"kind\":\"t2\",\"data\":{\"name\":\"jrizzo76\",\"is_friend\":false,\"created\":1411815182,\"created_utc\":1411786382,\"link_karma\":2,\"comment_karma\":11,\"is_gold\":false,\"is_mod\":true,\"has_verified_email\":false,\"id\":\"4rre1\"}}";

    public void testUserDeserialize() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Thing.class, new Thing.SerializerDeserializer())
                .registerTypeAdapter(FullName.class, new FullName.SerializerDeserializer())
                .registerTypeAdapter(Date.class, new DateSerializerDeserializer().setDateFormat(DateSerializerDeserializer.TIMESTAMP))
                .registerTypeAdapter(URL.class, new URLSerializerDeserializer())
                .create();
        Thing user = gson.fromJson(json, Thing.class);
        Assert.assertNotNull(user);
    }
}

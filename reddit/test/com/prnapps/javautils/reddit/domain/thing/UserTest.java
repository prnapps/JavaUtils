package com.prnapps.javautils.reddit.domain.thing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import junit.framework.TestCase;

/**
 * Created by jimbo on 11/30/2014.
 */
public class UserTest extends TestCase {
    public void testUserAboutDeserialize() {
        String json = "{\"kind\":\"t2\",\"data\":{\"name\":\"jrizzo76\",\"is_friend\":false,\"created\":1411815182,\"created_utc\":1411786382,\"link_karma\":2,\"comment_karma\":11,\"is_gold\":false,\"is_mod\":true,\"has_verified_email\":false,\"id\":\"4rre1\"}}";
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(User.class, new User.AboutDeserializer())
                .create();
        User user = gson.fromJson(json, User.class);
        assertEquals(user.getName(), "jrizzo76");
    }
}

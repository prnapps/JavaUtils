package com.prnapps.javautils.reddit.domain.login;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * Created by jimbo on 3/20/2015.
 */
public class LoginTest extends TestCase {
    public void testLoginDeserialization() {
        String json = "{\"json\": {\"errors\": [[\"WRONG_PASSWORD\", \"invalid password\", \"passwd\"]], \"data\": {\"need_https\": false, \"modhash\": \"bc5i88sviw4e0fdd5189025237c2c849f30920e3cc00d35841\", \"cookie\": \"8013673,2014-09-21T08:01:05,2c32f28703501a9f72a838d7b245f4f157b8d45e\"}}}";
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        LoginContainer loginContainer = gson.fromJson(json, LoginContainer.class);
        Assert.assertNotNull(loginContainer);
    }
}

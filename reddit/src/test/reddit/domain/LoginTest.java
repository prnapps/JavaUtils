package test.reddit.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prnapps.javautils.reddit.domain.Error;
import com.prnapps.javautils.reddit.domain.Errors;
import com.prnapps.javautils.reddit.domain.Login;
import junit.framework.TestCase;

/**
 * Created by jimbo on 11/29/2014.
 */
public class LoginTest extends TestCase {
    public void testLoginDeserialize() {
        String json = "{\"json\": {\"errors\": [[\"WRONG_PASSWORD\", \"invalid password\", \"passwd\"]], \"data\": {\"need_https\": false, \"modhash\": \"bc5i88sviw4e0fdd5189025237c2c849f30920e3cc00d35841\", \"cookie\": \"8013673,2014-09-21T08:01:05,2c32f28703501a9f72a838d7b245f4f157b8d45e\"}}}";
        Login login = new Login("testUser", "testPass");
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Login.class, new Login.LoginDeserializer(login))
                .registerTypeAdapter(Errors.class, new Errors.ErrorsDeserializer())
                .registerTypeAdapter(Error.class, new Error.ErrorDeserializer())
                .create();
        login = gson.fromJson(json, Login.class);
        assertEquals(login.getContentForm(), "api_type=json&user=testUser&passwd=testPass&rem=true");
        assertEquals(login.getCookie(), "8013673,2014-09-21T08:01:05,2c32f28703501a9f72a838d7b245f4f157b8d45e");
        assertEquals(login.getModhash(), "bc5i88sviw4e0fdd5189025237c2c849f30920e3cc00d35841");
        assertEquals(login.getNeedHttps(), false);
        assertEquals(login.getErrors().toString(), "[WRONG_PASSWORD: invalid password <passwd>]");
    }
}

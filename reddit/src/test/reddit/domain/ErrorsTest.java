package test.reddit.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prnapps.javautils.reddit.domain.Error;
import com.prnapps.javautils.reddit.domain.Errors;
import junit.framework.TestCase;

/**
 * Created by jimbo on 11/29/2014.
 */
public class ErrorsTest extends TestCase {
    public void testErrorDeserialize() {
        String json = "[\"WRONG_PASSWORD\", \"invalid password\", \"passwd\"]";
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Error.class, new Error.ErrorDeserializer())
                .create();
        Error error = gson.fromJson(json, Error.class);
        assertEquals(error.toString(), "WRONG_PASSWORD: invalid password <passwd>");
    }

    public void testErrorsDeserialize() {
        String json = "[[\"WRONG_PASSWORD\", \"invalid password\", \"passwd\"], [\"WRONG_PASSWORD\", \"invalid password\", \"passwd\"]]";
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Errors.class, new Errors.ErrorsDeserializer())
                .registerTypeAdapter(Error.class, new Error.ErrorDeserializer())
                .create();
        Errors errors = gson.fromJson(json, Errors.class);
        assertEquals(errors.toString(), "[WRONG_PASSWORD: invalid password <passwd>, WRONG_PASSWORD: invalid password <passwd>]");
    }
}

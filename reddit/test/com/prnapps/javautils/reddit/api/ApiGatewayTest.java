package com.prnapps.javautils.reddit.api;

import com.prnapps.javautils.connection.ConnectionException;
import com.prnapps.javautils.reddit.domain.listing.Listing;
import com.prnapps.javautils.reddit.domain.login.Login;
import com.prnapps.javautils.reddit.mock.MockRequestManagerFactory;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.IOException;

/**
 * Created by jimbo on 3/23/2015.
 */
public class ApiGatewayTest extends TestCase {
    private final String USER_AGENT = "Test User Agent";

    public void testLogin() {
        try {
            ApiGateway apiGateway = new ApiGateway().setUserAgent(USER_AGENT);
            Login login = apiGateway.getLogin(new MockRequestManagerFactory().getMockLoginSavedManager());
            Assert.assertNotNull(login);
            Assert.assertEquals(login.getErrors().get(0).get(0), "WRONG_PASSWORD");
            Assert.assertEquals(login.getErrors().get(0).get(1), "invalid password");
            Assert.assertEquals(login.getErrors().get(0).get(2), "passwd");
            Assert.assertEquals(login.getData().getNeedHttps(), false);
            Assert.assertEquals(login.getData().getCookie(), "8013673,2014-09-21T08:01:05,2c32f28703501a9f72a838d7b245f4f157b8d45e");
            Assert.assertEquals(login.getData().getModhash(), "bc5i88sviw4e0fdd5189025237c2c849f30920e3cc00d35841");
        } catch (ConnectionException | IOException e) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    public void testGetSaved() {
        try {
            ApiGateway apiGateway = new ApiGateway().setUserAgent(USER_AGENT);
            Listing saved = apiGateway.getListing(new MockRequestManagerFactory().getMockSavedRequestManager());
            Assert.assertNotNull(saved);
        } catch (ConnectionException | IOException e) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }

    }
}

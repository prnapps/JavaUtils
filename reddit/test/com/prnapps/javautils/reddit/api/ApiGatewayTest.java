package com.prnapps.javautils.reddit.api;

import com.prnapps.javautils.connection.ConnectionException;
import com.prnapps.javautils.reddit.domain.Login;
import com.prnapps.javautils.reddit.domain.listing.Saved;
import junit.framework.TestCase;

import java.io.IOException;

/**
 * Created by jimbo on 11/30/2014.
 */
public class ApiGatewayTest extends TestCase {
    private final String USER_AGENT = "javautils-reddit-test by pseudorandomname";

    private ApiGateway gateway;
    private Login login;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        gateway = new ApiGateway(USER_AGENT);
        login = new Login("jrizzo76", "ZnAisOxNBpnE7czpiWha");
    }

    public void testLogin() {
        try {
            login = gateway.login(login);
            assertEquals(login.getContentForm(), "api_type=json&user=jrizzo76&passwd=ZnAisOxNBpnE7czpiWha&rem=true");
            assertNotNull(login.getCookie());
            assertNotNull(login.getModhash());
        } catch (ConnectionException | IOException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    public void testSaved() {
        try {
            Saved saved = gateway.saved(login);
            assertNotNull(saved);
        } catch (ConnectionException | IOException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}

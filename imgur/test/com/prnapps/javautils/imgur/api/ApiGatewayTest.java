package com.prnapps.javautils.imgur.api;

import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.imgur.domain.AlbumResponse;
import com.prnapps.javautils.imgur.domain.Image;
import com.prnapps.javautils.imgur.domain.ImageResponse;
import com.prnapps.javautils.imgur.mock.MockRequestManagerFactory;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;

/**
 * Created by jimbo on 3/31/2015.
 */
public class ApiGatewayTest extends TestCase {
    private final String USER_AGENT = "test_useragent";
    private final String CLIENT_ID = "test_clientid";

//    public void testImage() {
//        ApiGateway gateway = new ApiGateway("", "");
//        try {
//            Image image = gateway.image("k5Gdn2m");
//            assertNotNull(image);
//        } catch (IOException | HttpException e) {
//            e.printStackTrace();
//            assertTrue(false);
//        }
//    }
//
//    public void testAlbum() {
//        ApiGateway gateway = new ApiGateway("", "");
//        try {
//            List<Image> album = gateway.album("fsqp9");
//            assertNotNull(album);
//        } catch (IOException | HttpException e) {
//            e.printStackTrace();
//            assertTrue(false);
//        }
//    }

    public void testGetImageResponse() {
        ApiGateway gateway = new ApiGateway(USER_AGENT, CLIENT_ID);
        MockRequestManagerFactory factory = new MockRequestManagerFactory();
        try {
            ImageResponse imageResponse = gateway.getImageResponse(factory.getImageRequestManager());
            assertNotNull(imageResponse);
        } catch (IOException | HttpException e) {
            e.printStackTrace();
        }
    }

    public void testGetAlbumResponse() {
        ApiGateway gateway = new ApiGateway(USER_AGENT, CLIENT_ID);
        MockRequestManagerFactory factory = new MockRequestManagerFactory();
        try {
            AlbumResponse albumResponse = gateway.getAlbumResponse(factory.getAlbumRequestManager());
            assertNotNull(albumResponse);
        } catch (IOException | HttpException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

}

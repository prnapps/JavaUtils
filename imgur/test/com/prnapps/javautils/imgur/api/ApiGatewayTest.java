package com.prnapps.javautils.imgur.api;

import com.google.gson.reflect.TypeToken;
import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.imgur.domain.Album;
import com.prnapps.javautils.imgur.domain.BasicResponse;
import com.prnapps.javautils.imgur.domain.Image;
import com.prnapps.javautils.imgur.mock.MockRequestManagerFactory;
import junit.framework.TestCase;

import java.io.IOException;
import java.lang.reflect.Type;
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
//            Album album = gateway.album("fsqp9");
//            assertNotNull(album);
//        } catch (IOException | HttpException e) {
//            e.printStackTrace();
//            assertTrue(false);
//        }
//    }
//
//    public void testAlbumImages() {
//        ApiGateway gateway = new ApiGateway("", "");
//        try {
//            List<Image> album = gateway.albumImages("fsqp9");
//            assertNotNull(album);
//        } catch (IOException | HttpException e) {
//            e.printStackTrace();
//            assertTrue(false);
//        }
//    }
//
//    public void testAlbumImage() {
//        ApiGateway gateway = new ApiGateway("", "");
//        try {
//            Image image = gateway.albumImage("fsqp9", "AlnD0SI");
//            assertNotNull(image);
//        } catch (IOException | HttpException e) {
//            e.printStackTrace();
//            assertTrue(false);
//        }
//    }

    public void testGetImageResponse() {
        ApiGateway gateway = new ApiGateway(USER_AGENT, CLIENT_ID);
        MockRequestManagerFactory factory = new MockRequestManagerFactory();
        try {
            Type type = new TypeToken<BasicResponse<Image>>(){}.getType();
            BasicResponse<Image> imageResponse = gateway.getResponse(factory.getImageRequestManager(), type);
            assertNotNull(imageResponse);
        } catch (IOException | HttpException e) {
            e.printStackTrace();
        }
    }

    public void testGetAlbumResponse() {
        ApiGateway gateway = new ApiGateway(USER_AGENT, CLIENT_ID);
        MockRequestManagerFactory factory = new MockRequestManagerFactory();
        try {
            Type type = new TypeToken<BasicResponse<Album>>(){}.getType();
            BasicResponse<Album> albumResponse = gateway.getResponse(factory.getAlbumRequestManager(), type);
            assertNotNull(albumResponse);
        } catch (IOException | HttpException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    public void testGetAlbumImagesResponse() {
        ApiGateway gateway = new ApiGateway(USER_AGENT, CLIENT_ID);
        MockRequestManagerFactory factory = new MockRequestManagerFactory();
        try {
            Type type = new TypeToken<BasicResponse<List<Image>>>(){}.getType();
            BasicResponse<Album> albumResponse = gateway.getResponse(factory.getAlbumImagesRequestManager(), type);
            assertNotNull(albumResponse);
        } catch (IOException | HttpException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    public void testGetAlbumImageResponse() {
        ApiGateway gateway = new ApiGateway(USER_AGENT, CLIENT_ID);
        MockRequestManagerFactory factory = new MockRequestManagerFactory();
        try {
            Type type = new TypeToken<BasicResponse<Image>>(){}.getType();
            BasicResponse<Album> albumResponse = gateway.getResponse(factory.getAlbumImageRequestManager(), type);
            assertNotNull(albumResponse);
        } catch (IOException | HttpException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

}

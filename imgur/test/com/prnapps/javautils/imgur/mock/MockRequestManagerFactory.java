package com.prnapps.javautils.imgur.mock;

import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;
import com.prnapps.javautils.imgur.api.IRequestManager;

import java.io.IOException;

/**
 * Created by jimbo on 3/31/2015.
 */
public class MockRequestManagerFactory {

    public IRequestManager getImageRequestManager() {
        return new IRequestManager() {
            @Override
            public HttpResponse request(String userAgent, String clientId) throws HttpException, IOException {
                return new HttpResponse()
                        .setStatusCode(200)
                        .setResponseBody("{\"data\":{\"id\":\"k5Gdn2m\",\"title\":null,\"description\":null,\"datetime\":1427726689,\"type\":\"image\\/jpeg\",\"animated\":false,\"width\":1200,\"height\":900,\"size\":224583,\"views\":41409,\"bandwidth\":9299757447,\"vote\":null,\"favorite\":false,\"nsfw\":false,\"section\":null,\"account_url\":null,\"account_id\":null,\"link\":\"http:\\/\\/i.imgur.com\\/k5Gdn2m.jpg\"},\"success\":true,\"status\":200}");
            }
        };
    }

    public IRequestManager getAlbumRequestManager() {
        return new IRequestManager() {
            @Override
            public HttpResponse request(String userAgent, String clientId) throws HttpException, IOException {
                return new HttpResponse()
                        .setStatusCode(200)
                        .setResponseBody("{\"data\":[{\"id\":\"9ncqRjz\",\"title\":null,\"description\":null,\"datetime\":1427801705,\"type\":\"image\\/jpeg\",\"animated\":false,\"width\":1000,\"height\":756,\"size\":522337,\"views\":635946,\"bandwidth\":332178125802,\"vote\":null,\"favorite\":false,\"nsfw\":null,\"section\":null,\"account_url\":null,\"account_id\":null,\"link\":\"http:\\/\\/i.imgur.com\\/9ncqRjz.jpg\"},{\"id\":\"AlnD0SI\",\"title\":null,\"description\":null,\"datetime\":1427801707,\"type\":\"image\\/jpeg\",\"animated\":false,\"width\":1000,\"height\":877,\"size\":566161,\"views\":567961,\"bandwidth\":321557367721,\"vote\":null,\"favorite\":false,\"nsfw\":null,\"section\":null,\"account_url\":null,\"account_id\":null,\"link\":\"http:\\/\\/i.imgur.com\\/AlnD0SI.jpg\"}],\"success\":true,\"status\":200}");
            }
        };
    }
}

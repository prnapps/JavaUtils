package com.prnapps.javautils.imgur.mock;

import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;
import com.prnapps.javautils.imgur.api.endpoints.IRequest;

import java.io.IOException;

/**
 * Created by jimbo on 3/31/2015.
 */
public class MockRequestManagerFactory {

    public IRequest getImageRequestManager() {
        return new IRequest() {
            @Override
            public HttpResponse request() throws HttpException, IOException {
                return new HttpResponse()
                        .setStatusCode(200)
                        .setResponseBody("{\"data\":{\"id\":\"k5Gdn2m\",\"title\":null,\"description\":null,\"datetime\":1427726689,\"type\":\"image\\/jpeg\",\"animated\":false,\"width\":1200,\"height\":900,\"size\":224583,\"views\":41409,\"bandwidth\":9299757447,\"vote\":null,\"favorite\":false,\"nsfw\":false,\"section\":null,\"account_url\":null,\"account_id\":null,\"link\":\"http:\\/\\/i.imgur.com\\/k5Gdn2m.jpg\"},\"success\":true,\"status\":200}");
            }
        };
    }

    public IRequest getAlbumRequestManager() {
        return new IRequest() {
            @Override
            public HttpResponse request() throws HttpException, IOException {
                return new HttpResponse()
                        .setStatusCode(200)
                        .setResponseBody("{\"data\":{\"id\":\"fsqp9\",\"title\":\"OJ Simpson Pog Slammer\",\"description\":null,\"datetime\":1427801705,\"cover\":\"9ncqRjz\",\"cover_width\":1000,\"cover_height\":756,\"account_url\":null,\"account_id\":null,\"privacy\":\"public\",\"layout\":\"blog\",\"views\":765168,\"link\":\"http:\\/\\/imgur.com\\/a\\/fsqp9\",\"favorite\":false,\"nsfw\":false,\"section\":\"pics\",\"images_count\":2,\"images\":[{\"id\":\"9ncqRjz\",\"title\":null,\"description\":null,\"datetime\":1427801705,\"type\":\"image\\/jpeg\",\"animated\":false,\"width\":1000,\"height\":756,\"size\":522337,\"views\":1284041,\"bandwidth\":670702123817,\"vote\":null,\"favorite\":false,\"nsfw\":null,\"section\":null,\"account_url\":null,\"account_id\":null,\"link\":\"http:\\/\\/i.imgur.com\\/9ncqRjz.jpg\"},{\"id\":\"AlnD0SI\",\"title\":null,\"description\":null,\"datetime\":1427801707,\"type\":\"image\\/jpeg\",\"animated\":false,\"width\":1000,\"height\":877,\"size\":566161,\"views\":1126852,\"bandwidth\":637979655172,\"vote\":null,\"favorite\":false,\"nsfw\":null,\"section\":null,\"account_url\":null,\"account_id\":null,\"link\":\"http:\\/\\/i.imgur.com\\/AlnD0SI.jpg\"}]},\"success\":true,\"status\":200}");
            }
        };
    }

    public IRequest getAlbumImagesRequestManager() {
        return new IRequest() {
            @Override
            public HttpResponse request() throws HttpException, IOException {
                return new HttpResponse()
                        .setStatusCode(200)
                        .setResponseBody("{\"data\":[{\"id\":\"9ncqRjz\",\"title\":null,\"description\":null,\"datetime\":1427801705,\"type\":\"image\\/jpeg\",\"animated\":false,\"width\":1000,\"height\":756,\"size\":522337,\"views\":635946,\"bandwidth\":332178125802,\"vote\":null,\"favorite\":false,\"nsfw\":null,\"section\":null,\"account_url\":null,\"account_id\":null,\"link\":\"http:\\/\\/i.imgur.com\\/9ncqRjz.jpg\"},{\"id\":\"AlnD0SI\",\"title\":null,\"description\":null,\"datetime\":1427801707,\"type\":\"image\\/jpeg\",\"animated\":false,\"width\":1000,\"height\":877,\"size\":566161,\"views\":567961,\"bandwidth\":321557367721,\"vote\":null,\"favorite\":false,\"nsfw\":null,\"section\":null,\"account_url\":null,\"account_id\":null,\"link\":\"http:\\/\\/i.imgur.com\\/AlnD0SI.jpg\"}],\"success\":true,\"status\":200}");
            }
        };
    }

    public IRequest getAlbumImageRequestManager() {
        return new IRequest() {
            @Override
            public HttpResponse request() throws HttpException, IOException {
                return new HttpResponse()
                        .setStatusCode(200)
                        .setResponseBody("{\"data\":{\"id\":\"AlnD0SI\",\"title\":null,\"description\":null,\"datetime\":1427801707,\"type\":\"image\\/jpeg\",\"animated\":false,\"width\":1000,\"height\":877,\"size\":566161,\"views\":1127013,\"bandwidth\":638070807093,\"vote\":null,\"favorite\":false,\"nsfw\":null,\"section\":null,\"account_url\":null,\"account_id\":null,\"link\":\"http:\\/\\/i.imgur.com\\/AlnD0SI.jpg\"},\"success\":true,\"status\":200}");
            }
        };
    }
}

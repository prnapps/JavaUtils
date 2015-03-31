package com.prnapps.javautils.imgur.api.endpoints;

import com.prnapps.javautils.http.HttpBuilder;
import com.prnapps.javautils.http.HttpContent;
import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;

import java.io.IOException;

/**
 * Created by jimbo on 3/31/2015.
 */
public class ImageEndPoint implements IEndPoint {
    private final String LINK_FORMAT = "https://api.imgur.com/3/image/%s";
    private final String CLIENTID_HEADER = "Authorization";
    private final String CLIENTID_VALUE_FORMAT = "Client-ID %s";

    private final String imageId;

    public ImageEndPoint(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public HttpResponse request(String userAgent, String clientId) throws HttpException, IOException {
        HttpBuilder http = new HttpBuilder()
                .setUrl(String.format(LINK_FORMAT, imageId))
                .setUserAgent(userAgent)
                .addCustomHeader(CLIENTID_HEADER, String.format(CLIENTID_VALUE_FORMAT, clientId))
                .setAcceptType(HttpContent.JSON);
        return HttpResponse.parseResponse(http.connect());
    }

    public String getImageId() {
        return imageId;
    }

}

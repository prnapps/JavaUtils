package com.prnapps.javautils.imgur.api.endpoints;

import com.prnapps.javautils.http.HttpBuilder;
import com.prnapps.javautils.http.HttpContent;
import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;

import java.io.IOException;

/**
 * Created by jimbo on 3/31/2015.
 */
public class AlbumRequest implements IRequest {
    private final String LINK_FORMAT = "https://api.imgur.com/3/album/%s";
    private final String CLIENTID_HEADER = "Authorization";
    private final String CLIENTID_VALUE_FORMAT = "Client-ID %s";

    private final String userAgent;
    private final String clientId;
    private String albumId;

    public AlbumRequest(String userAgent, String clientId) {
        this.userAgent = userAgent;
        this.clientId = clientId;
    }

    @Override
    public HttpResponse request() throws HttpException, IOException {
        HttpBuilder http = new HttpBuilder()
                .setUrl(String.format(LINK_FORMAT, albumId))
                .setUserAgent(userAgent)
                .addCustomHeader(CLIENTID_HEADER, String.format(CLIENTID_VALUE_FORMAT, clientId))
                .setAcceptType(HttpContent.JSON);
        return HttpResponse.parseResponse(http.connect());
    }

    public String getAlbumId() {
        return albumId;
    }
    public AlbumRequest setAlbumId(String albumId) {
        this.albumId = albumId;
        return this;
    }

}
package com.prnapps.javautils.imgur.api.endpoints;

import com.prnapps.javautils.http.HttpBuilder;
import com.prnapps.javautils.http.HttpContent;
import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;
import com.prnapps.javautils.utils.StringUtils;

import java.io.IOException;

/**
 * Created by jimbo on 3/31/2015.
 */
public class AlbumImagesEndPoint implements IEndPoint {
    private final String LINK_FORMAT = "https://api.imgur.com/3/album/%s";
    private final String LINK_IMAGE_FORMAT = "/image/%s";
    private final String LINK_IMAGES = "/images";
    private final String CLIENTID_HEADER = "Authorization";
    private final String CLIENTID_VALUE_FORMAT = "Client-ID %s";

    private final String albumId;

    private String imageId;

    public AlbumImagesEndPoint(String albumId) {
        this.albumId = albumId;
    }

    @Override
    public HttpResponse request(String userAgent, String clientId) throws HttpException, IOException {
        StringUtils utils = new StringUtils();
        String url = String.format(LINK_FORMAT, albumId);
        url += utils.isNullOrEmpty(imageId) ? LINK_IMAGES : String.format(LINK_IMAGE_FORMAT, imageId);
        HttpBuilder http = new HttpBuilder()
                .setUrl(url)
                .setUserAgent(userAgent)
                .addCustomHeader(CLIENTID_HEADER, String.format(CLIENTID_VALUE_FORMAT, clientId))
                .setAcceptType(HttpContent.JSON);
        return HttpResponse.parseResponse(http.connect());
    }

    public String getAlbumId() {
        return albumId;
    }
    public String getImageId() {
        return imageId;
    }
    public AlbumImagesEndPoint setImageId(String imageId) {
        this.imageId = imageId;
        return this;
    }

}

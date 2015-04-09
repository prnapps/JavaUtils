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
public class AlbumImagesRequest implements IRequest {
    private final String LINK_IMAGE_FORMAT = "https://api.imgur.com/3/album/%s/image/%s";
    private final String LINK_IMAGES_FORMAT = "https://api.imgur.com/3/album/%s/images";
    private final String CLIENTID_HEADER = "Authorization";
    private final String CLIENTID_VALUE_FORMAT = "Client-ID %s";

    private final String userAgent;
    private final String clientId;
    private String albumId;
    private String imageId;

    public AlbumImagesRequest(String userAgent, String clientId) {
        this.userAgent = userAgent;
        this.clientId = clientId;
    }

    @Override
    public HttpResponse request() throws HttpException, IOException {
        StringUtils utils = new StringUtils();
        String url = utils.isNullOrEmpty(imageId) ? String.format(LINK_IMAGES_FORMAT, albumId) :
                String.format(LINK_IMAGE_FORMAT, albumId, imageId);
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
    public AlbumImagesRequest setAlbumId(String albumId) {
        this.albumId = albumId;
        return this;
    }
    public String getImageId() {
        return imageId;
    }
    public AlbumImagesRequest setImageId(String imageId) {
        this.imageId = imageId;
        return this;
    }

}
package com.prnapps.javautils.imgur.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;
import com.prnapps.javautils.imgur.domain.AbstractResponse;
import com.prnapps.javautils.imgur.domain.AlbumResponse;
import com.prnapps.javautils.imgur.domain.Image;
import com.prnapps.javautils.imgur.domain.ImageResponse;
import com.prnapps.javautils.utils.gson.DateSerializerDeserializer;
import com.prnapps.javautils.utils.gson.URLSerializerDeserializer;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * Created by jimbo on 3/30/2015.
 */
public class ApiGateway {
    private final String userAgent;
    private final String clientId;

    public ApiGateway(String userAgent, String clientId) {
        this.userAgent = userAgent;
        this.clientId = clientId;
    }

    public Image image(String imageId) throws IOException, HttpException {
        ImageRequestManager request = new ImageRequestManager(imageId);
        ImageResponse response = getImageResponse(request);
        return response.getData();
    }

    public List<Image> album(String albumId) throws IOException, HttpException {
        AlbumRequestManager request = new AlbumRequestManager(albumId);
        AlbumResponse response = getAlbumResponse(request);
        return response.getData();
    }

    public ImageResponse getImageResponse(IRequestManager request) throws IOException, HttpException {
        HttpResponse response = request.request(userAgent, clientId);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateSerializerDeserializer().setDateFormat(DateSerializerDeserializer.TIMESTAMP))
                .registerTypeAdapter(URL.class, new URLSerializerDeserializer())
                .create();
        return gson.fromJson(response.getResponseBody(), ImageResponse.class);
    }

    public AlbumResponse getAlbumResponse(IRequestManager request) throws IOException, HttpException {
        HttpResponse response = request.request(userAgent, clientId);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateSerializerDeserializer().setDateFormat(DateSerializerDeserializer.TIMESTAMP))
                .registerTypeAdapter(URL.class, new URLSerializerDeserializer())
                .create();
        return gson.fromJson(response.getResponseBody(), AlbumResponse.class);
    }

}

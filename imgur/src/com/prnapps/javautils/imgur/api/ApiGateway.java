package com.prnapps.javautils.imgur.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;
import com.prnapps.javautils.imgur.api.endpoints.AlbumEndPoint;
import com.prnapps.javautils.imgur.api.endpoints.IEndPoint;
import com.prnapps.javautils.imgur.api.endpoints.ImageEndPoint;
import com.prnapps.javautils.imgur.domain.Album;
import com.prnapps.javautils.imgur.domain.AlbumResponse;
import com.prnapps.javautils.imgur.domain.Image;
import com.prnapps.javautils.imgur.domain.BasicResponse;
import com.prnapps.javautils.utils.gson.DateSerializerDeserializer;
import com.prnapps.javautils.utils.gson.URLSerializerDeserializer;

import java.io.IOException;
import java.lang.reflect.Type;
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
        ImageEndPoint request = new ImageEndPoint(imageId);
        BasicResponse<Image> response = getImageResponse(request);
        return response.getData();
    }

    public List<Image> albumImage(String albumId) throws IOException, HttpException {
        AlbumEndPoint request = new AlbumEndPoint(albumId);
        BasicResponse<Album> response = getAlbumResponse(request);
        return response.getData();
    }

    public BasicResponse getImageResponse(IEndPoint request) throws IOException, HttpException {
        HttpResponse response = request.request(userAgent, clientId);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateSerializerDeserializer().setDateFormat(DateSerializerDeserializer.TIMESTAMP))
                .registerTypeAdapter(URL.class, new URLSerializerDeserializer())
                .create();
        Type type = new TypeToken<BasicResponse<Image>>(){}.getType();
        return gson.fromJson(response.getResponseBody(), type);
    }

    public BasicResponse getAlbumResponse(IEndPoint request) throws IOException, HttpException {
        HttpResponse response = request.request(userAgent, clientId);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateSerializerDeserializer().setDateFormat(DateSerializerDeserializer.TIMESTAMP))
                .registerTypeAdapter(URL.class, new URLSerializerDeserializer())
                .create();
        Type type = new TypeToken<BasicResponse<Album>>(){}.getType();
        return gson.fromJson(response.getResponseBody(), type);
    }

    public BasicResponse getAlbumImageResponse(IEndPoint request) throws IOException, HttpException {
        HttpResponse response = request.request(userAgent, clientId);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateSerializerDeserializer().setDateFormat(DateSerializerDeserializer.TIMESTAMP))
                .registerTypeAdapter(URL.class, new URLSerializerDeserializer())
                .create();
        Type type = new TypeToken<BasicResponse<List<Image>>>(){}.getType();
        return gson.fromJson(response.getResponseBody(), type);
    }

}

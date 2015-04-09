package com.prnapps.javautils.imgur.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;
import com.prnapps.javautils.imgur.api.endpoints.AlbumRequest;
import com.prnapps.javautils.imgur.api.endpoints.AlbumImagesRequest;
import com.prnapps.javautils.imgur.api.endpoints.IRequest;
import com.prnapps.javautils.imgur.api.endpoints.ImageRequest;
import com.prnapps.javautils.imgur.domain.Album;
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
        ImageRequest request = new ImageRequest(userAgent, clientId).setImageId(imageId);
        Type type = new TypeToken<BasicResponse<Image>>(){}.getType();
        BasicResponse<Image> response = getResponse(request, type);
        return response.getData();
    }

    public Album album(String albumId) throws IOException, HttpException {
        AlbumRequest request = new AlbumRequest(userAgent, clientId).setAlbumId(albumId);
        Type type = new TypeToken<BasicResponse<Album>>(){}.getType();
        BasicResponse<Album> response = getResponse(request, type);
        return response.getData();
    }

    public List<Image> albumImages(String albumId) throws IOException, HttpException {
        AlbumImagesRequest request = new AlbumImagesRequest(userAgent, clientId).setAlbumId(albumId);
        Type type = new TypeToken<BasicResponse<List<Image>>>(){}.getType();
        BasicResponse<List<Image>> response = getResponse(request, type);
        return response.getData();
    }

    public Image albumImage(String albumId, String imageId) throws IOException, HttpException {
        AlbumImagesRequest request = new AlbumImagesRequest(userAgent, clientId)
                .setAlbumId(albumId)
                .setImageId(imageId);
        Type type = new TypeToken<BasicResponse<Image>>(){}.getType();
        BasicResponse<Image> response = getResponse(request, type);
        return response.getData();
    }

    public BasicResponse getResponse(IRequest request, Type dataType) throws IOException, HttpException {
        HttpResponse response = request.request();
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateSerializerDeserializer().setDateFormat(DateSerializerDeserializer.TIMESTAMP))
                .registerTypeAdapter(URL.class, new URLSerializerDeserializer())
                .create();
        return gson.fromJson(response.getResponseBody(), dataType);
    }

}

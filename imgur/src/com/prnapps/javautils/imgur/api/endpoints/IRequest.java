package com.prnapps.javautils.imgur.api.endpoints;

import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;

import java.io.IOException;

/**
 * Created by jimbo on 3/31/2015.
 */
public interface IRequest {
    public HttpResponse request() throws HttpException, IOException;
}
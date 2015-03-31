package com.prnapps.javautils.imgur.api;

import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;

import java.io.IOException;

/**
 * Created by jimbo on 3/31/2015.
 */
public interface IRequestManager {
    public HttpResponse request(String userAgent, String clientId) throws HttpException, IOException;
}

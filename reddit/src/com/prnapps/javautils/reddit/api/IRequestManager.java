package com.prnapps.javautils.reddit.api;

import com.prnapps.javautils.http.HttpException;
import com.prnapps.javautils.http.HttpResponse;

import java.io.IOException;

/**
 * Created by jimbo on 3/20/2015.
 */
public interface IRequestManager {
    public HttpResponse request(String userAgent) throws HttpException, IOException;
}

package com.prnapps.javautils.reddit.api;

import com.prnapps.javautils.connection.ConnectionException;
import com.prnapps.javautils.connection.ConnectionResponse;

import java.io.IOException;

/**
 * Created by jimbo on 3/20/2015.
 */
public interface IRequestManager {
    public ConnectionResponse request(String userAgent) throws ConnectionException, IOException;
}

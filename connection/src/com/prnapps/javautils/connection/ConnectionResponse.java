package com.prnapps.javautils.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by jimbo on 11/29/2014.
 */
public class ConnectionResponse {
    protected int statusCode;
    protected String responseBody;
    protected Map<String, List<String>> headers;

    public ConnectionResponse() { }

    public String getResponseBody() {
        return responseBody;
    }

    public ConnectionResponse setResponseBody(String responseBody) {
        this.responseBody = responseBody;
        return this;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public ConnectionResponse setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public ConnectionResponse setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
        return this;
    }

    public static ConnectionResponse parseResponse(HttpURLConnection connection) throws ConnectionException, IOException {
        ConnectionResponse response = new ConnectionResponse();
        try {
            if((response.statusCode = connection.getResponseCode()) == HttpURLConnection.HTTP_OK) {
                response.responseBody = response.readStream(connection.getInputStream());
                response.headers = connection.getHeaderFields();
            } else {
                throw new ConnectionException(response.statusCode, response.readStream(connection.getErrorStream()));
            }
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
        return response;
    }

    /**
     * <p>Converts the input stream returned from the url connection to a string.</p>
     *
     * @param stream the url connection response stream
     * @return the response string
     * @throws IOException
     */
    private String readStream(InputStream stream) throws IOException {
        if(stream != null) {
            InputStreamReader isr = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(isr, 8192);

            try {
                String line = null;
                StringBuilder builder = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    builder.append(line);
                }
                return builder.toString();
            } finally {
                br.close();
                isr.close();
                stream.close();
            }
        }
        return null;
    }
}

package com.prnapps.javautils.connection;

import com.prnapps.javautils.utils.NameValuePair;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Created by jimbo on 11/29/2014.
 */
public class ConnectionBuilder {
    private final int maxRedirectAttempts = 5;

    private HttpURLConnection connection;
    private ConnectionMethod method = ConnectionMethod.GET;
    private URL url;
    private boolean secure = false;
    private String content;
    private ContentType contentType;
    private int contentLength;
    private boolean hasContent = false;
    private ContentType acceptType = ContentType.HTML;
    private List<String> cookies;
    private List<NameValuePair> customHeaders;
    private String userAgent;
    private KeyManager[] keyManager = null;
    private TrustManager[] trustManager = null;
    private int redirects;

    public ConnectionBuilder() {
        cookies = new ArrayList<String>();
        customHeaders = new ArrayList<NameValuePair>();
    }

    public ConnectionBuilder setMethod(ConnectionMethod method) {
        this.method = method;
        return this;
    }

    public ConnectionBuilder setUrl(String url) throws MalformedURLException {
        this.url = new URL(url);
        this.secure = url.startsWith("https");
        setAcceptType(url);
        return this;
    }

    public ConnectionBuilder setContent(String content, ContentType contentType) {
        this.hasContent = true;
        this.content = content;
        this.contentLength = content.getBytes().length;
        this.contentType = contentType;
        return this;
    }

    public ConnectionBuilder setAcceptType(ContentType acceptType) {
        this.acceptType = acceptType;
        return this;
    }

    public ConnectionBuilder setAcceptType(String url) {
        if(url.endsWith(".mp3")) {
            this.acceptType = ContentType.MP3;
        } else if(url.endsWith(".m4a")) {
            this.acceptType = ContentType.M4A;
        } else if(url.endsWith(".m4v") || url.endsWith(".mp4")) {
            this.acceptType = ContentType.MP4;
        } else if(url.endsWith(".json")) {
            this.acceptType = ContentType.JSON;
        } else if(url.endsWith(".xml")) {
            this.acceptType = ContentType.XML;
        }
        return this;
    }

    public ConnectionBuilder setCookies(List<String> cookies) {
        this.cookies = cookies;
        return this;
    }

    public ConnectionBuilder setCookie(String cookie) {
        if(cookies == null) {
            cookies = new ArrayList<String>();
        }
        cookies.add(cookie);
        return this;
    }

    public ConnectionBuilder setCustomHeaders(List<NameValuePair> customHeaders) {
        this.customHeaders = customHeaders;
        return this;
    }

    public ConnectionBuilder setCustomHeaders(NameValuePair...pairs) {
        customHeaders = Arrays.asList(pairs);
        return this;
    }

    public ConnectionBuilder addCustomHeaders(List<NameValuePair> customHeaders) {
        if(customHeaders == null) {
            customHeaders = new ArrayList<NameValuePair>();
        }
        customHeaders.addAll(customHeaders);
        return this;
    }

    public ConnectionBuilder addCustomHeaders(NameValuePair...pairs) {
        if(customHeaders == null) {
            customHeaders = new ArrayList<NameValuePair>();
        }
        customHeaders.addAll(Arrays.asList(pairs));
        return this;
    }

    public ConnectionBuilder addCustomHeader(String name, String value) {
        if(customHeaders == null) {
            customHeaders = new ArrayList<NameValuePair>();
        }
        customHeaders.add(new NameValuePair(name, value));
        return this;
    }

    public ConnectionBuilder setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public ConnectionBuilder setTrustManager(TrustManager[] trustManager) {
        this.trustManager = trustManager;
        return this;
    }

    public ConnectionBuilder setKeyManager(KeyManager[] keyManager) {
        this.keyManager = keyManager;
        return this;
    }

    public static ConnectionBuilder get(String link) throws MalformedURLException {
        return new ConnectionBuilder().setUrl(link).setAcceptType(link);
    }

    public static ConnectionBuilder post(String link, String content) throws MalformedURLException {
        return new ConnectionBuilder().setMethod(ConnectionMethod.POST).setUrl(link).setContent(content, ContentType.JSON).setAcceptType(ContentType.JSON);
    }

    public HttpURLConnection connect() throws IOException {
        connection = null;
        if(secure) {
            try {
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(keyManager, trustManager, new SecureRandom());
                connection = (HttpsURLConnection) url.openConnection();
                ((HttpsURLConnection) connection).setSSLSocketFactory(sslContext.getSocketFactory());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
        } else {
            connection = (HttpURLConnection) url.openConnection();
        }

        connection.setRequestMethod(method.toString());
        connection.setRequestProperty("Accept", acceptType.toString());
        connection.setRequestProperty("User-Agent", userAgent);

        if(cookies != null) {
            for (String cookie : cookies) {
                connection.addRequestProperty("Cookie", cookie);
            }
        }

        if(customHeaders != null) {
            for(NameValuePair header : customHeaders) {
                connection.addRequestProperty(header.getName(), header.getValue());
            }
        }

        if(hasContent && method.allowsContent()) {
            connection.setRequestProperty("Content-Type", contentType.toString());
            connection.setRequestProperty("Content-Length", "" + contentLength);
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            CharsetEncoder encoder = Charset.forName("UTF-8").newEncoder();
            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream(), encoder);
            wr.append(content);
            wr.flush();
            wr.close();
        }

        if(connection.getResponseCode() >= 300 && connection.getResponseCode() < 400 && redirects <= maxRedirectAttempts) {
            redirects++;
            InputStream inputStream = connection.getInputStream();
            url = connection.getURL();
            secure = url.toString().startsWith("https");
            inputStream.close();
            connection = connect();
        }

        return connection;
    }
}

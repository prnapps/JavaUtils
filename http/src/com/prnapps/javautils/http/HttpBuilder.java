package com.prnapps.javautils.http;

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
public class HttpBuilder {
    private final int maxRedirectAttempts = 5;

    private HttpURLConnection connection;
    private HttpMethod method = HttpMethod.GET;
    private URL url;
    private boolean secure = false;
    private String content;
    private HttpContent httpContent;
    private int contentLength;
    private boolean hasContent = false;
    private HttpContent acceptType = HttpContent.HTML;
    private List<String> cookies;
    private List<NameValuePair> customHeaders;
    private String userAgent;
    private KeyManager[] keyManager = null;
    private TrustManager[] trustManager = null;
    private int redirects;

    public HttpBuilder() {
        cookies = new ArrayList<String>();
        customHeaders = new ArrayList<NameValuePair>();
    }

    public HttpBuilder setMethod(HttpMethod method) {
        this.method = method;
        return this;
    }

    public HttpBuilder setUrl(String url) throws MalformedURLException {
        this.url = new URL(url);
        this.secure = url.startsWith("https");
        setAcceptType(url);
        return this;
    }

    public HttpBuilder setContent(String content, HttpContent httpContent) {
        this.hasContent = true;
        this.content = content;
        this.contentLength = content.getBytes().length;
        this.httpContent = httpContent;
        return this;
    }

    public HttpBuilder setAcceptType(HttpContent acceptType) {
        this.acceptType = acceptType;
        return this;
    }

    public HttpBuilder setAcceptType(String url) {
        if(url.endsWith(".mp3")) {
            this.acceptType = HttpContent.MP3;
        } else if(url.endsWith(".m4a")) {
            this.acceptType = HttpContent.M4A;
        } else if(url.endsWith(".m4v") || url.endsWith(".mp4")) {
            this.acceptType = HttpContent.MP4;
        } else if(url.endsWith(".json")) {
            this.acceptType = HttpContent.JSON;
        } else if(url.endsWith(".xml")) {
            this.acceptType = HttpContent.XML;
        }
        return this;
    }

    public HttpBuilder setCookies(List<String> cookies) {
        this.cookies = cookies;
        return this;
    }

    public HttpBuilder setCookie(String cookie) {
        if(cookies == null) {
            cookies = new ArrayList<String>();
        }
        cookies.add(cookie);
        return this;
    }

    public HttpBuilder setCustomHeaders(List<NameValuePair> customHeaders) {
        this.customHeaders = customHeaders;
        return this;
    }

    public HttpBuilder setCustomHeaders(NameValuePair...pairs) {
        customHeaders = Arrays.asList(pairs);
        return this;
    }

    public HttpBuilder addCustomHeaders(List<NameValuePair> customHeaders) {
        if(customHeaders == null) {
            customHeaders = new ArrayList<NameValuePair>();
        }
        customHeaders.addAll(customHeaders);
        return this;
    }

    public HttpBuilder addCustomHeaders(NameValuePair...pairs) {
        if(customHeaders == null) {
            customHeaders = new ArrayList<NameValuePair>();
        }
        customHeaders.addAll(Arrays.asList(pairs));
        return this;
    }

    public HttpBuilder addCustomHeader(String name, String value) {
        if(customHeaders == null) {
            customHeaders = new ArrayList<NameValuePair>();
        }
        customHeaders.add(new NameValuePair().setName(name).setValue(value));
        return this;
    }

    public HttpBuilder setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public HttpBuilder setTrustManager(TrustManager[] trustManager) {
        this.trustManager = trustManager;
        return this;
    }

    public HttpBuilder setKeyManager(KeyManager[] keyManager) {
        this.keyManager = keyManager;
        return this;
    }

    public static HttpBuilder get(String link) throws MalformedURLException {
        return new HttpBuilder().setUrl(link).setAcceptType(link);
    }

    public static HttpBuilder post(String link, String content) throws MalformedURLException {
        return new HttpBuilder().setMethod(HttpMethod.POST).setUrl(link).setContent(content, HttpContent.JSON).setAcceptType(HttpContent.JSON);
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
                connection.addRequestProperty(header.getName(), header.getValue().toString());
            }
        }

        if(hasContent && method.allowsContent()) {
            connection.setRequestProperty("Content-Type", httpContent.toString());
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

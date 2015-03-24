package com.prnapps.javautils.reddit.api;

import com.prnapps.javautils.connection.*;
import com.prnapps.javautils.utils.NameValuePair;

import java.io.IOException;
import java.util.List;

/**
 * Created by jimbo on 3/24/2015.
 */
public class SubredditRequestManager implements IRequestManager {
    private final String URL_FORMAT = "http://reddit.com/r/%s/%s.json%s";

    private String subredditName;
    private Order subredditOrder;
    private List<NameValuePair> params;

    @Override
    public ConnectionResponse request(String userAgent) throws ConnectionException, IOException {
        ConnectionBuilder connection = new ConnectionBuilder()
                .setUrl(String.format(URL_FORMAT, subredditName, subredditOrder.toString(),
                        NameValuePair.toUrlParams(params.toArray(new NameValuePair[params.size()]))))
                .setMethod(ConnectionMethod.GET)
                .setAcceptType(ContentType.JSON)
                .setUserAgent(userAgent);
        return ConnectionResponse.parseResponse(connection.connect());
    }

    public String getSubredditName() {
        return subredditName;
    }
    public SubredditRequestManager setSubredditName(String subredditName) {
        this.subredditName = subredditName;
        return this;
    }
    public Order getSubredditOrder() {
        return subredditOrder;
    }
    public SubredditRequestManager setSubredditOrder(Order subredditOrder) {
        this.subredditOrder = subredditOrder;
        return this;
    }
    public List<NameValuePair> getParams() {
        return params;
    }
    public SubredditRequestManager setParams(List<NameValuePair> params) {
        this.params = params;
        return this;
    }

    public enum Order {
        HOT("hot"),
        NEW("new");

        private String string;

        Order(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return this.string;
        }
    }
}

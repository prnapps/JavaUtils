package com.prnapps.javautils.reddit.api.endpoints;

import com.prnapps.javautils.http.*;
import com.prnapps.javautils.reddit.api.endpoints.interfaces.IRequest;
import com.prnapps.javautils.reddit.domain.other.Order;
import com.prnapps.javautils.reddit.domain.other.Period;
import com.prnapps.javautils.utils.NameValuePair;
import com.prnapps.javautils.utils.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimbo on 3/24/2015.
 */
public class SubredditRequest implements IRequest {
    private final String URL_FORMAT = "http://reddit.com/r/%s/%s.json%s";
    private final String URL_QUERY_BEFORE = "before";
    private final String URL_QUERY_AFTER = "after";
    private final String URL_QUERY_LIMIT = "limit";
    private final String URL_QUERY_COUNT = "count";
    private final String URL_QUERY_SHOW = "show";
    private final String URL_QUERY_PERIOD = "t";

    private final String userAgent;
    private String subredditName;

    // params
    private Order subredditOrder = Order.HOT;
    private String before;
    private String after;
    private String limit;
    private String count;
    private String show;
    private Period period;

    public SubredditRequest(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public HttpResponse request() throws HttpException, IOException {
        HttpBuilder connection = new HttpBuilder()
                .setUrl(String.format(URL_FORMAT, subredditName, subredditOrder, generateParams()))
                .setMethod(HttpMethod.GET)
                .setAcceptType(HttpContent.JSON)
                .setUserAgent(userAgent);
        return HttpResponse.parseResponse(connection.connect());
    }

    protected String generateParams() {
        try {
            StringUtils utils = new StringUtils();
            List<NameValuePair> params = new ArrayList<>();
            if(!utils.isNullOrEmpty(before)) {
                params.add(new NameValuePair().setName(URL_QUERY_BEFORE).setValue(before));
            }
            if(!utils.isNullOrEmpty(after)) {
                params.add(new NameValuePair().setName(URL_QUERY_AFTER).setValue(after));
            }
            if(!utils.isNullOrEmpty(limit)) {
                params.add(new NameValuePair().setName(URL_QUERY_LIMIT).setValue(limit));
            }
            if(!utils.isNullOrEmpty(count)) {
                params.add(new NameValuePair().setName(URL_QUERY_COUNT).setValue(count));
            }
            if(!utils.isNullOrEmpty(show)) {
                params.add(new NameValuePair().setName(URL_QUERY_SHOW).setValue(show));
            }
            if(period != null) {
                params.add(new NameValuePair().setName(URL_QUERY_PERIOD).setValue(period));
            }
            return NameValuePair.toUrlParams(params.toArray(new NameValuePair[params.size()]));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getSubredditName() {
        return subredditName;
    }
    public SubredditRequest setSubredditName(String subredditName) {
        this.subredditName = subredditName;
        return this;
    }
    public Order getSubredditOrder() {
        return subredditOrder;
    }
    public SubredditRequest setSubredditOrder(Order subredditOrder) {
        this.subredditOrder = subredditOrder;
        return this;
    }
    public String getBefore() {
        return before;
    }
    public SubredditRequest setBefore(String before) {
        this.before = before;
        return this;
    }
    public String getAfter() {
        return after;
    }
    public SubredditRequest setAfter(String after) {
        this.after = after;
        return this;
    }
    public String getLimit() {
        return limit;
    }
    public SubredditRequest setLimit(String limit) {
        this.limit = limit;
        return this;
    }
    public String getCount() {
        return count;
    }
    public SubredditRequest setCount(String count) {
        this.count = count;
        return this;
    }
    public String getShow() {
        return show;
    }
    public SubredditRequest setShow(String show) {
        this.show = show;
        return this;
    }
    public Period getPeriod() {
        return period;
    }
    public SubredditRequest setPeriod(Period period) {
        this.period = period;
        return this;
    }

}

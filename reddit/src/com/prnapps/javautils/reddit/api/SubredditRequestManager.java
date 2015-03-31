package com.prnapps.javautils.reddit.api;

import com.prnapps.javautils.http.*;
import com.prnapps.javautils.utils.NameValuePair;
import com.prnapps.javautils.utils.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimbo on 3/24/2015.
 */
public class SubredditRequestManager implements IRequestManager {
    private final String URL_FORMAT = "http://reddit.com/r/%s/%s.json%s";
    private final String URL_QUERY_BEFORE = "before";
    private final String URL_QUERY_AFTER = "after";
    private final String URL_QUERY_LIMIT = "limit";
    private final String URL_QUERY_COUNT = "count";
    private final String URL_QUERY_SHOW = "show";
    private final String URL_QUERY_PERIOD = "t";

    private final String subredditName;

    // params
    private Order subredditOrder = Order.HOT;
    private String before;
    private String after;
    private String limit;
    private String count;
    private String show;
    private String period;

    public SubredditRequestManager(String subredditName) {
        this.subredditName = subredditName;
    }

    @Override
    public HttpResponse request(String userAgent) throws HttpException, IOException {
        HttpBuilder connection = new HttpBuilder()
                .setUrl(String.format(URL_FORMAT, subredditName, subredditOrder.toString(), generateParams()))
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
    public Order getSubredditOrder() {
        return subredditOrder;
    }
    public SubredditRequestManager setSubredditOrder(Order subredditOrder) {
        this.subredditOrder = subredditOrder;
        return this;
    }
    public SubredditRequestManager setSubredditOrder(String subredditOrder) {
        if(Order.NEW.toString().equalsIgnoreCase(subredditOrder)) {
            return setSubredditOrder(Order.NEW);
        } else if(Order.TOP.toString().equalsIgnoreCase(subredditOrder)) {
            return setSubredditOrder(Order.TOP);
        } else if(Order.CONTROVERSIAL.toString().equalsIgnoreCase(subredditOrder)) {
            return setSubredditOrder(Order.CONTROVERSIAL);
        }
        return setSubredditOrder(Order.HOT);
    }
    public String getBefore() {
        return before;
    }
    public SubredditRequestManager setBefore(String before) {
        this.before = before;
        return this;
    }
    public String getAfter() {
        return after;
    }
    public SubredditRequestManager setAfter(String after) {
        this.after = after;
        return this;
    }
    public String getLimit() {
        return limit;
    }
    public SubredditRequestManager setLimit(String limit) {
        this.limit = limit;
        return this;
    }
    public String getCount() {
        return count;
    }
    public SubredditRequestManager setCount(String count) {
        this.count = count;
        return this;
    }
    public String getShow() {
        return show;
    }
    public SubredditRequestManager setShow(String show) {
        this.show = show;
        return this;
    }
    public String getPeriod() {
        return period;
    }
    public SubredditRequestManager setPeriod(String period) {
        this.period = period;
        return this;
    }

    public enum Order {
        HOT("hot"),
        NEW("new"),
        TOP("top"),
        CONTROVERSIAL("controversial");

        private String string;

        private Order(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return this.string;
        }
    }

    public enum Period {
        HOUR("hour"),
        DAY("day"),
        WEEK("week"),
        MONTH("month"),
        YEAR("year"),
        ALL("all");

        private String string;

        private Period(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return this.string;
        }
    }
}

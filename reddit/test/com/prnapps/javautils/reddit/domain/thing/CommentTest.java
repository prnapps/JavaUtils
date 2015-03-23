package com.prnapps.javautils.reddit.domain.thing;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prnapps.javautils.reddit.domain.other.FullName;
import com.prnapps.javautils.utils.gson.DateSerializerDeserializer;
import com.prnapps.javautils.utils.gson.URLSerializerDeserializer;
import junit.framework.TestCase;
import org.junit.Assert;

import java.net.URL;
import java.util.Date;

/**
 * Created by jimbo on 3/19/2015.
 */
public class CommentTest extends TestCase {
    private String json = "{\"kind\":\"t1\",\"data\":{\"subreddit_id\":\"t5_2qoil\",\"link_title\":\"Hue hue hue\",\"banned_by\":null,\"link_id\":\"t3_2hln8c\",\"link_author\":\"PingasPanther\",\"likes\":null,\"replies\":null,\"user_reports\":[],\"saved\":true,\"id\":\"cktsrh3\",\"gilded\":0,\"report_reasons\":null,\"author\":\"PingasPanther\",\"parent_id\":\"t3_2hln8c\",\"score\":24,\"approved_by\":null,\"controversiality\":0,\"body\":\"Album\\n\\nhttp://Imgur.com/a/OmHT8\",\"edited\":false,\"author_flair_css_class\":null,\"downs\":0,\"body_html\":\"&lt;div class=\\\"md\\\"&gt;&lt;p&gt;Album&lt;/p&gt;\\n\\n&lt;p&gt;&lt;a href=\\\"http://Imgur.com/a/OmHT8\\\"&gt;http://Imgur.com/a/OmHT8&lt;/a&gt;&lt;/p&gt;\\n&lt;/div&gt;\",\"subreddit\":\"ass\",\"score_hidden\":false,\"name\":\"t1_cktsrh3\",\"created\":1411833134,\"author_flair_text\":null,\"link_url\":\"http://imgur.com/FAQx5EX.jpg\",\"created_utc\":1411804334,\"ups\":24,\"mod_reports\":[],\"num_reports\":null,\"distinguished\":null}}";

    public void testCommentDeserialize() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Thing.class, new Thing.SerializerDeserializer())
                .registerTypeAdapter(FullName.class, new FullName.SerializerDeserializer())
                .registerTypeAdapter(Date.class, new DateSerializerDeserializer().setDateFormat(DateSerializerDeserializer.TIMESTAMP))
                .registerTypeAdapter(URL.class, new URLSerializerDeserializer())
                .create();
        Thing comment = gson.fromJson(json, Thing.class);
        Assert.assertNotNull(comment);
    }
}
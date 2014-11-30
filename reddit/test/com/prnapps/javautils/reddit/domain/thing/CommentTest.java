package com.prnapps.javautils.reddit.domain.thing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import junit.framework.TestCase;

/**
 * Created by jimbo on 11/30/2014.
 */
public class CommentTest extends TestCase {
    public void testCommentDeserialize() {
        String json = "{\"kind\":\"t1\",\"data\":{\"subreddit_id\":\"t5_2qoil\",\"link_title\":\"Hue hue hue\",\"banned_by\":null,\"link_id\":\"t3_2hln8c\",\"link_author\":\"PingasPanther\",\"likes\":null,\"replies\":null,\"user_reports\":[],\"saved\":true,\"id\":\"cktsrh3\",\"gilded\":0,\"report_reasons\":null,\"author\":\"PingasPanther\",\"parent_id\":\"t3_2hln8c\",\"score\":24,\"approved_by\":null,\"controversiality\":0,\"body\":\"Album\\n\\nhttp://Imgur.com/a/OmHT8\",\"edited\":false,\"author_flair_css_class\":null,\"downs\":0,\"body_html\":\"&lt;div class=\\\"md\\\"&gt;&lt;p&gt;Album&lt;/p&gt;\\n\\n&lt;p&gt;&lt;a href=\\\"http://Imgur.com/a/OmHT8\\\"&gt;http://Imgur.com/a/OmHT8&lt;/a&gt;&lt;/p&gt;\\n&lt;/div&gt;\",\"subreddit\":\"ass\",\"score_hidden\":false,\"name\":\"t1_cktsrh3\",\"created\":1411833134,\"author_flair_text\":null,\"link_url\":\"http://imgur.com/FAQx5EX.jpg\",\"created_utc\":1411804334,\"ups\":24,\"mod_reports\":[],\"num_reports\":null,\"distinguished\":null}}";
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Comment.class, new Comment.CommentDeserializer())
                .create();
        Comment comment = gson.fromJson(json, Comment.class);
        assertEquals(comment.getFullname(), "t1_cktsrh3");
        assertEquals(comment.getLink().getFullname(), "t3_2hln8c");
        assertEquals(comment.getLink().getTitle(), "Hue hue hue");
        assertEquals(comment.getLink().getUrl(), "http://imgur.com/FAQx5EX.jpg");
        assertEquals(comment.getLink().getAuthor().getName(), "PingasPanther");
        assertEquals(comment.getSubreddit().getFullname(), "t5_2qoil");
        assertEquals(comment.getSubreddit().getName(), "ass");
        assertEquals(comment.getAuthor().getName(), "PingasPanther");
        assertEquals(comment.getAuthorFlair().getText(), null);
        assertEquals(comment.getAuthorFlair().getCssClass(), null);
        assertEquals(comment.getCreated().getTime(), Long.parseLong("1411804334") * 1000);
        assertEquals(comment.getBody(), "Album\n\nhttp://Imgur.com/a/OmHT8");
        assertEquals(comment.getBodyHtml(), "&lt;div class=\"md\"&gt;&lt;p&gt;Album&lt;/p&gt;\n\n&lt;p&gt;&lt;a href=\"http://Imgur.com/a/OmHT8\"&gt;http://Imgur.com/a/OmHT8&lt;/a&gt;&lt;/p&gt;\n&lt;/div&gt;");
        assertEquals(comment.getScore(), 24);
        assertEquals(comment.getUps(), 24);
        assertEquals(comment.getDowns(), 0);
        assertEquals(comment.getGilded(), 0);
        assertEquals(comment.getContoversiality(), 0);
        assertEquals(comment.getLikes(), 0);
        assertEquals(comment.getReplies(), 0);
        assertEquals(comment.getReports(), 0);
        assertEquals(comment.isSaved(), true);
        assertEquals(comment.isEdited(), false);
        assertEquals(comment.isScoreHidden(), false);
    }
}

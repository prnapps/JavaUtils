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
public class LinkTest extends TestCase {
    private String json = "{\"kind\":\"t3\",\"data\":{\"domain\":\"chirb.it\",\"banned_by\":null,\"media_embed\":{\"content\":\"&lt;iframe class=\\\"embedly-embed\\\" src=\\\"//cdn.embedly.com/widgets/media.html?src=http%3A%2F%2Fchirb.it%2Fwp%2Fk7am7t&amp;src_secure=1&amp;url=http%3A%2F%2Fchirb.it%2Fk7am7t&amp;image=http%3A%2F%2Fchirb.it%2Fchirbit_oembedpic.jpg&amp;key=2aa3c4d5f3de4f5b9120b660ad850dc9&amp;type=text%2Fhtml&amp;schema=chirb\\\" width=\\\"380\\\" height=\\\"120\\\" scrolling=\\\"no\\\" frameborder=\\\"0\\\" allowfullscreen&gt;&lt;/iframe&gt;\",\"width\":380,\"scrolling\":false,\"height\":120},\"subreddit\":\"gonewildaudio\",\"selftext_html\":null,\"selftext\":\"\",\"likes\":null,\"user_reports\":[],\"secure_media\":null,\"link_flair_text\":null,\"id\":\"2hlntm\",\"gilded\":1,\"secure_media_embed\":{},\"clicked\":false,\"report_reasons\":null,\"author\":\"Pippits\",\"media\":{\"oembed\":{\"provider_url\":\"http://www.chirbit.com/\",\"description\":\"Audio: The name's Satan, but you can call me lucy Ideal woman contract, fuck my infernal pussy, lucy has feelings - social audio\",\"title\":\"The name&amp;#39;s Satan, but you can call me lucy\",\"type\":\"rich\",\"thumbnail_width\":120,\"height\":120,\"width\":380,\"html\":\"&lt;iframe class=\\\"embedly-embed\\\" src=\\\"//cdn.embedly.com/widgets/media.html?src=http%3A%2F%2Fchirb.it%2Fwp%2Fk7am7t&amp;src_secure=1&amp;url=http%3A%2F%2Fchirb.it%2Fk7am7t&amp;image=http%3A%2F%2Fchirb.it%2Fchirbit_oembedpic.jpg&amp;key=2aa3c4d5f3de4f5b9120b660ad850dc9&amp;type=text%2Fhtml&amp;schema=chirb\\\" width=\\\"380\\\" height=\\\"120\\\" scrolling=\\\"no\\\" frameborder=\\\"0\\\" allowfullscreen&gt;&lt;/iframe&gt;\",\"author_name\":\"Pip\",\"version\":\"1.0\",\"provider_name\":\"chirbit\",\"thumbnail_url\":\"http://chirb.it/chirbit_oembedpic.jpg\",\"thumbnail_height\":120,\"author_url\":\"http://www.chirbit.com/Pip\"},\"type\":\"chirb.it\"},\"score\":10,\"approved_by\":null,\"over_18\":true,\"hidden\":false,\"thumbnail\":\"http://b.thumbs.redditmedia.com/ML21HfrMbTnYyoSoUVlpPF_xR2PnfEXhCmmHqxtBmHU.jpg\",\"subreddit_id\":\"t5_2u463\",\"edited\":false,\"link_flair_css_class\":null,\"author_flair_css_class\":\"verifyblackpink\",\"downs\":0,\"mod_reports\":[],\"saved\":true,\"is_self\":false,\"name\":\"t3_2hlntm\",\"permalink\":\"/r/gonewildaudio/comments/2hlntm/f4m_the_names_satan_but_you_can_call_me_lucy/\",\"stickied\":false,\"created\":1411833792,\"url\":\"http://chirb.it/k7am7t\",\"author_flair_text\":\"Verified!\",\"title\":\"[F4M] The name's Satan but you can call me lucy [Humor] [2 voices] [Ideal woman contract] [Fuck my infernal pussy] [Satan doesn't give a shit!] [Wait maybe I do] [Script by /u/homersoc]\",\"created_utc\":1411804992,\"ups\":10,\"num_comments\":13,\"visited\":false,\"num_reports\":null,\"distinguished\":null}}";

    public void testLinkDeserialize() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Thing.class, new Thing.SerializerDeserializer())
                .registerTypeAdapter(FullName.class, new FullName.SerializerDeserializer())
                .registerTypeAdapter(Date.class, new DateSerializerDeserializer().setDateFormat(DateSerializerDeserializer.TIMESTAMP))
                .registerTypeAdapter(URL.class, new URLSerializerDeserializer())
                .create();
        Thing link = gson.fromJson(json, Thing.class);
        Assert.assertNotNull(link);
    }
}

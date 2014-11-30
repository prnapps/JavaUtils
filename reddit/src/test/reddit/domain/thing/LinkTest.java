package test.reddit.domain.thing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prnapps.javautils.reddit.domain.thing.Link;
import com.prnapps.javautils.reddit.domain.thing.Media;
import junit.framework.TestCase;

/**
 * Created by jimbo on 11/30/2014.
 */
public class LinkTest extends TestCase {
    public void testLinkDeserialize() {
        String json = "{\"kind\":\"t3\",\"data\":{\"domain\":\"chirb.it\",\"banned_by\":null,\"media_embed\":{\"content\":\"&lt;iframe class=\\\"embedly-embed\\\" src=\\\"//cdn.embedly.com/widgets/media.html?src=http%3A%2F%2Fchirb.it%2Fwp%2Fk7am7t&amp;src_secure=1&amp;url=http%3A%2F%2Fchirb.it%2Fk7am7t&amp;image=http%3A%2F%2Fchirb.it%2Fchirbit_oembedpic.jpg&amp;key=2aa3c4d5f3de4f5b9120b660ad850dc9&amp;type=text%2Fhtml&amp;schema=chirb\\\" width=\\\"380\\\" height=\\\"120\\\" scrolling=\\\"no\\\" frameborder=\\\"0\\\" allowfullscreen&gt;&lt;/iframe&gt;\",\"width\":380,\"scrolling\":false,\"height\":120},\"subreddit\":\"gonewildaudio\",\"selftext_html\":null,\"selftext\":\"\",\"likes\":null,\"user_reports\":[],\"secure_media\":null,\"link_flair_text\":null,\"id\":\"2hlntm\",\"gilded\":1,\"secure_media_embed\":{},\"clicked\":false,\"report_reasons\":null,\"author\":\"Pippits\",\"media\":{\"oembed\":{\"provider_url\":\"http://www.chirbit.com/\",\"description\":\"Audio: The name's Satan, but you can call me lucy Ideal woman contract, fuck my infernal pussy, lucy has feelings - social audio\",\"title\":\"The name&amp;#39;s Satan, but you can call me lucy\",\"type\":\"rich\",\"thumbnail_width\":120,\"height\":120,\"width\":380,\"html\":\"&lt;iframe class=\\\"embedly-embed\\\" src=\\\"//cdn.embedly.com/widgets/media.html?src=http%3A%2F%2Fchirb.it%2Fwp%2Fk7am7t&amp;src_secure=1&amp;url=http%3A%2F%2Fchirb.it%2Fk7am7t&amp;image=http%3A%2F%2Fchirb.it%2Fchirbit_oembedpic.jpg&amp;key=2aa3c4d5f3de4f5b9120b660ad850dc9&amp;type=text%2Fhtml&amp;schema=chirb\\\" width=\\\"380\\\" height=\\\"120\\\" scrolling=\\\"no\\\" frameborder=\\\"0\\\" allowfullscreen&gt;&lt;/iframe&gt;\",\"author_name\":\"Pip\",\"version\":\"1.0\",\"provider_name\":\"chirbit\",\"thumbnail_url\":\"http://chirb.it/chirbit_oembedpic.jpg\",\"thumbnail_height\":120,\"author_url\":\"http://www.chirbit.com/Pip\"},\"type\":\"chirb.it\"},\"score\":10,\"approved_by\":null,\"over_18\":true,\"hidden\":false,\"thumbnail\":\"http://b.thumbs.redditmedia.com/ML21HfrMbTnYyoSoUVlpPF_xR2PnfEXhCmmHqxtBmHU.jpg\",\"subreddit_id\":\"t5_2u463\",\"edited\":false,\"link_flair_css_class\":null,\"author_flair_css_class\":\"verifyblackpink\",\"downs\":0,\"mod_reports\":[],\"saved\":true,\"is_self\":false,\"name\":\"t3_2hlntm\",\"permalink\":\"/r/gonewildaudio/comments/2hlntm/f4m_the_names_satan_but_you_can_call_me_lucy/\",\"stickied\":false,\"created\":1411833792,\"url\":\"http://chirb.it/k7am7t\",\"author_flair_text\":\"Verified!\",\"title\":\"[F4M] The name's Satan but you can call me lucy [Humor] [2 voices] [Ideal woman contract] [Fuck my infernal pussy] [Satan doesn't give a shit!] [Wait maybe I do] [Script by /u/homersoc]\",\"created_utc\":1411804992,\"ups\":10,\"num_comments\":13,\"visited\":false,\"num_reports\":null,\"distinguished\":null}}";
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Link.class, new Link.LinkDeserializer())
                .registerTypeAdapter(Media.class, new Media.MediaDeserializer())
                .create();
        Link link = gson.fromJson(json, Link.class);
        assertEquals(link.getKind(), "t3");
        assertEquals(link.getId(), "2hlntm");
        assertEquals(link.getTitle(), "[F4M] The name's Satan but you can call me lucy [Humor] [2 voices] [Ideal woman contract] [Fuck my infernal pussy] [Satan doesn't give a shit!] [Wait maybe I do] [Script by /u/homersoc]");
        assertEquals(link.getLinkFlair().getText(), null);
        assertEquals(link.getLinkFlair().getCssClass(), null);
        assertEquals(link.getUrl(), "http://chirb.it/k7am7t");
        assertEquals(link.getPermalink(), "/r/gonewildaudio/comments/2hlntm/f4m_the_names_satan_but_you_can_call_me_lucy/");
        assertEquals(link.getDomain(), "chirb.it");
        assertEquals(link.getSelfText(), "");
        assertEquals(link.getAuthor().getName(), "Pippits");
        assertEquals(link.getAuthorFlair().getText(), "Verified!");
        assertEquals(link.getAuthorFlair().getCssClass(), "verifyblackpink");
        assertEquals(link.getSubreddit().getFullname(), "t5_2u463");
        assertEquals(link.getSubreddit().getName(), "gonewildaudio");
        assertEquals(link.getCreated().getTime(), Long.parseLong("1411804992000"));
        assertEquals(link.getScore(), 10);
        assertEquals(link.getUps(), 10);
        assertEquals(link.getDowns(), 0);
        assertEquals(link.getGilded(), 1);
        assertEquals(link.getComments(), 13);
        assertEquals(link.getReports(), 0);
        assertEquals(link.isSelf(), false);
        assertEquals(link.isSaved(), true);
        assertEquals(link.isEdited(), false);
        assertEquals(link.isOver18(), true);
        assertEquals(link.isStickied(), false);
        assertEquals(link.isHidden(), false);
        assertEquals(link.isClicked(), false);
        assertEquals(link.isVisited(), false);
        json = "{\"kind\":\"t3\",\"data\":{\"domain\":\"chirb.it\",\"banned_by\":null,\"media_embed\":{\"content\":\"&lt;iframe class=\\\"embedly-embed\\\" src=\\\"//cdn.embedly.com/widgets/media.html?src=http%3A%2F%2Fchirb.it%2Fwp%2Fk7am7t&amp;src_secure=1&amp;url=http%3A%2F%2Fchirb.it%2Fk7am7t&amp;image=http%3A%2F%2Fchirb.it%2Fchirbit_oembedpic.jpg&amp;key=2aa3c4d5f3de4f5b9120b660ad850dc9&amp;type=text%2Fhtml&amp;schema=chirb\\\" width=\\\"380\\\" height=\\\"120\\\" scrolling=\\\"no\\\" frameborder=\\\"0\\\" allowfullscreen&gt;&lt;/iframe&gt;\",\"width\":380,\"scrolling\":false,\"height\":120},\"subreddit\":\"gonewildaudio\",\"selftext_html\":null,\"selftext\":\"\",\"likes\":null,\"user_reports\":[],\"secure_media\":null,\"link_flair_text\":null,\"id\":\"2hlntm\",\"gilded\":1,\"secure_media_embed\":{},\"clicked\":false,\"report_reasons\":null,\"author\":\"Pippits\",\"media\":null,\"score\":10,\"approved_by\":null,\"over_18\":true,\"hidden\":false,\"thumbnail\":\"http://b.thumbs.redditmedia.com/ML21HfrMbTnYyoSoUVlpPF_xR2PnfEXhCmmHqxtBmHU.jpg\",\"subreddit_id\":\"t5_2u463\",\"edited\":false,\"link_flair_css_class\":null,\"author_flair_css_class\":\"verifyblackpink\",\"downs\":0,\"mod_reports\":[],\"saved\":true,\"is_self\":false,\"name\":\"t3_2hlntm\",\"permalink\":\"/r/gonewildaudio/comments/2hlntm/f4m_the_names_satan_but_you_can_call_me_lucy/\",\"stickied\":false,\"created\":1411833792,\"url\":\"http://chirb.it/k7am7t\",\"author_flair_text\":\"Verified!\",\"title\":\"[F4M] The name's Satan but you can call me lucy [Humor] [2 voices] [Ideal woman contract] [Fuck my infernal pussy] [Satan doesn't give a shit!] [Wait maybe I do] [Script by /u/homersoc]\",\"created_utc\":1411804992,\"ups\":10,\"num_comments\":13,\"visited\":false,\"num_reports\":null,\"distinguished\":null}}";
        link = gson.fromJson(json, Link.class);
        assertEquals(link.getMedia(), null);
    }
}

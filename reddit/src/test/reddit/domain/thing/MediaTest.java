package test.reddit.domain.thing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prnapps.javautils.reddit.domain.thing.Media;
import junit.framework.TestCase;

/**
 * Created by jimbo on 11/30/2014.
 */
public class MediaTest extends TestCase {
    public void testMediaDeserialize() {
        String json = "{\"oembed\":{\"provider_url\":\"http://www.chirbit.com/\",\"description\":\"Audio: The name's Satan, but you can call me lucy Ideal woman contract, fuck my infernal pussy, lucy has feelings - social audio\",\"title\":\"The name&amp;#39;s Satan, but you can call me lucy\",\"type\":\"rich\",\"thumbnail_width\":120,\"height\":120,\"width\":380,\"html\":\"&lt;iframe class=\\\"embedly-embed\\\" src=\\\"//cdn.embedly.com/widgets/media.html?src=http%3A%2F%2Fchirb.it%2Fwp%2Fk7am7t&amp;src_secure=1&amp;url=http%3A%2F%2Fchirb.it%2Fk7am7t&amp;image=http%3A%2F%2Fchirb.it%2Fchirbit_oembedpic.jpg&amp;key=2aa3c4d5f3de4f5b9120b660ad850dc9&amp;type=text%2Fhtml&amp;schema=chirb\\\" width=\\\"380\\\" height=\\\"120\\\" scrolling=\\\"no\\\" frameborder=\\\"0\\\" allowfullscreen&gt;&lt;/iframe&gt;\",\"author_name\":\"Pip\",\"version\":\"1.0\",\"provider_name\":\"chirbit\",\"thumbnail_url\":\"http://chirb.it/chirbit_oembedpic.jpg\",\"thumbnail_height\":120,\"author_url\":\"http://www.chirbit.com/Pip\"},\"type\":\"chirb.it\"}";
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Media.class, new Media.MediaDeserializer())
                .create();
        Media media = gson.fromJson(json, Media.class);
        assertEquals(media.getKind(), "chirb.it");
        assertEquals(media.getTitle(), "The name&amp;#39;s Satan, but you can call me lucy");
        assertEquals(media.getDescription(), "Audio: The name's Satan, but you can call me lucy Ideal woman contract, fuck my infernal pussy, lucy has feelings - social audio");
        assertEquals(media.getHtml(), "&lt;iframe class=\"embedly-embed\" src=\"//cdn.embedly.com/widgets/media.html?src=http%3A%2F%2Fchirb.it%2Fwp%2Fk7am7t&amp;src_secure=1&amp;url=http%3A%2F%2Fchirb.it%2Fk7am7t&amp;image=http%3A%2F%2Fchirb.it%2Fchirbit_oembedpic.jpg&amp;key=2aa3c4d5f3de4f5b9120b660ad850dc9&amp;type=text%2Fhtml&amp;schema=chirb\" width=\"380\" height=\"120\" scrolling=\"no\" frameborder=\"0\" allowfullscreen&gt;&lt;/iframe&gt;");
        assertEquals(media.getAuthorName(), "Pip");
        assertEquals(media.getAuthorUrl(), "http://www.chirbit.com/Pip");
        assertEquals(media.getProviderUrl(), "http://www.chirbit.com/");
        assertEquals(media.getProviderName(), "chirbit");
        assertEquals(media.getHeight(), 120);
        assertEquals(media.getWidth(), 380);
        assertEquals(media.getThumbnailUrl(), "http://chirb.it/chirbit_oembedpic.jpg");
        assertEquals(media.getThumbnailHeight(), 120);
        assertEquals(media.getThumbnailWidth(), 120);
        assertEquals(media.getMediaType(), "rich");
        assertEquals(media.getVersion(), "1.0");
    }
}

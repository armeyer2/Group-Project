package Entity;

import Persistence.HTMLImageParser;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import static javax.ws.rs.core.HttpHeaders.USER_AGENT;
import static org.junit.jupiter.api.Assertions.*;

public class ImageParserTest {

    private Document doc;

    HTMLImageParser imageParser;
    String searchFor;

    @BeforeEach
    void setUp() throws IOException {
        imageParser = new HTMLImageParser();
        doc = Jsoup.connect("https://www.google.com/search?hl=en&site=imghp&tbm=isch&source=hp&q="+searchFor).userAgent(USER_AGENT).get();
    }

    @Test
    void  getImageSuccess() {
        searchFor = "strawberry";
        Element element = doc.select("img").first();
        assertEquals("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTF7EHfslQHj393Ro_JA52iDZ7xPYhKKM9c1QuRDlmuETNomzP_lw5kyEI", imageParser.ImageSearch(searchFor));
    }

}

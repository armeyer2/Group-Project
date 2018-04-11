package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.HttpHeaders.USER_AGENT;


/**
 * This class will parse google for the image returned from the image search
 */

public class HTMLImageParser {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @JsonIgnore
    public String ImageSearch(String searchFor) {
        logger.info(searchFor + " passed to ImageParse");
        String imgSrc = null;
        Document doc;

        try {

            doc = Jsoup.connect("https://www.google.com/search?hl=en&site=imghp&tbm=isch&source=hp&q="+searchFor).userAgent(USER_AGENT).get();

            Element imageFound = doc.select("img").first();
            imgSrc = imageFound.absUrl("src");


        } catch (IOException e) {
            e.printStackTrace();
        }

        return imgSrc;
    }

    @JsonIgnore
    public List<String> MultipleImageSearch(String searchFor) {
        logger.info(searchFor + " passed to ImageParse");
        List<String> imgSrcArray = new ArrayList<String>();
        Document doc;

        try {

            doc = Jsoup.connect("https://www.google.com/search?hl=en&site=imghp&tbm=isch&source=hp&q="+searchFor).userAgent(USER_AGENT).get();


            Elements images = doc.select("img");
            for (Element image : images) {
                imgSrcArray.add(image.attr("src"));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return imgSrcArray;
    }
}

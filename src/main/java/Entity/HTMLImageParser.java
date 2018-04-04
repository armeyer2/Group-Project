package Entity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static javax.ws.rs.core.HttpHeaders.USER_AGENT;


/**
 * This class will parse google for the image returned from the image search
 */
public class HTMLImageParser {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public String ImageSearch(String searchFor) {
        logger.info(searchFor + " passed to ImageParse");
        String imgSrc = null;


        Document doc;
        try {

            doc = Jsoup.connect("https://www.google.com/search?hl=en&site=imghp&tbm=isch&source=hp&q="+searchFor).userAgent(USER_AGENT).get();

            Element image = doc.select("img").first();
            imgSrc = image.absUrl("src");

                System.out.println("\nsrc : " + image.attr("src"));
                System.out.println("height : " + image.attr("height"));
                System.out.println("width : " + image.attr("width"));
                System.out.println("alt : " + image.attr("alt"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgSrc;
    }
}

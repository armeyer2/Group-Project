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

            //get all images
            doc = Jsoup.connect("https://www.google.com/search?hl=en&site=imghp&tbm=isch&source=hp&q="+searchFor).userAgent(USER_AGENT).get();
            Elements elements = doc.getElementsByClass("img.rg_ic.rg_i");

//            imgSrc = elements.get(0).attr("src");
            Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");

            for (Element image : images) {

                System.out.println("\nsrc : " + image.attr("src"));
                System.out.println("height : " + image.attr("height"));
                System.out.println("width : " + image.attr("width"));
                System.out.println("alt : " + image.attr("alt"));

            }
            //            for (Element image : images) {
//            Element el = images.get();
//            imgSrc = el.attr("src");
//            System.out.println("\nsrc : " + elements.get(0).attr("src"));
//            System.out.println("height : " + elements.get(0).attr("height"));
//            System.out.println("width : " + elements.get(0).attr("width"));
//            System.out.println("alt : " + elements.get(0).attr("alt"));
//            System.out.println("\nsrc : " + el.attr("src"));
//            System.out.println("height : " + el.attr("height"));
//            System.out.println("width : " + el.attr("width"));
//            System.out.println("alt : " + el.attr("alt"));


        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgSrc;
    }
}

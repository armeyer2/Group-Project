package Entity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

/**
 * This class will parse google for the image returned from the image search
 */
public class HTMLImageParser {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void ImageSearch(String searchFor) {
        logger.info(searchFor + " passed to ImageParse");

        Document doc;
        try {

            // TODO change to only first image
            //get ONE image
            doc = Jsoup.connect("http://google.com").get();
            Elements image = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");

//            Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
//            for (Element image : images) {

            // IMAGE SRC RETURNED
            String imgSrc = image.attr("src");
            String imgAlt = image.attr("alt");

            logger.info("imgSrc: " + imgSrc
                    + "\nimgAlt: " + imgAlt);


            System.out.println(image.attr("src"));
            System.out.println("height : " + image.attr("height"));
            System.out.println("width : " + image.attr("width"));
            System.out.println("alt : " + image.attr("alt"));

//            }

        } catch (IOException e) {
            logger.error("Err in ImageParse... " + e);
        }

    }


}
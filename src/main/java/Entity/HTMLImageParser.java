package Entity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class will parse google for the image returned from the image search
 */
public class HTMLImageParser {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public ArrayList<String> ImageSearch(String searchFor) {
        // index 0 is src, index 1 is alt
        ArrayList<String> imgInfoArray = new ArrayList<String>();
        logger.info(searchFor + " passed to ImageParse");

        Document doc;
        try {

            // TODO change to only first image
            //get ONE image
            doc = Jsoup.connect("http://google.com").get();
//            Elements image = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");

            Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            for (Element image : images) {

                // IMAGE SRC RETURNED
                imgInfoArray.add(image.attr("src"));
                imgInfoArray.add(image.attr("alt"));

                logger.info("imgSrc: " + imgInfoArray.get(0)
                        + "\nimgAlt: " + imgInfoArray.get(1));


                logger.info(image.attr("src"));
                logger.info("height : " + image.attr("height"));
                logger.info("width : " + image.attr("width"));
                logger.info("alt : " + image.attr("alt"));

            }

        } catch (IOException e) {
            logger.error("Err in ImageParse... " + e);
        }
        return imgInfoArray;
    }


}
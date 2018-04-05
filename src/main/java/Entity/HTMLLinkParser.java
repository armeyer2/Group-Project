package Entity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

/**
 * This class will parse the links for the google image returned
 */
public class HTMLLinkParser {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void LinkSearch(String searchFor) {
        Document doc;
        try {

            // need http protocol
            doc = Jsoup.connect("http://google.com").get();

            // get page title
            String title = doc.title();
            logger.info("title : " + title);

            // get all links
            Elements links = doc.select("a[href]");
            /**for (Element link : links) {

                // get the value from href attribute
                logger.info("\nlink : " + link.attr("href"));
                logger.info("text : " + link.text());

            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
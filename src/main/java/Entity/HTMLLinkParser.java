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

    public String LinkSearch(String searchFor) {
        String imgLink = "";
        logger.info(searchFor + " passed to LinkParse");

        Document doc;
        try {

            // need http protocol
            doc = Jsoup.connect("http://google.com").get();

            // get page title
            String title = doc.title();
            System.out.println("title : " + title);

            // get ONE link
            Elements link = doc.select("a[href]");
//            for (Element link : links) {

            // IMAGE LINK RETURNED
            imgLink = link.attr("href");
            logger.info("imgLink: " + imgLink);

            // get the value from href attribute
            System.out.println("\nlink : " + link.attr("href"));
            System.out.println("text : " + link.text());


                // get all links
//            Elements links = doc.select("a[href]");
//            for (Element link : links) {
//
//                // get the value from href attribute
//                System.out.println("\nlink : " + link.attr("href"));
//                System.out.println("text : " + link.text());

//            }
        } catch (IOException e) {
            logger.error("Err in LinkParse... " + e);
        }
        return imgLink;
    }

}
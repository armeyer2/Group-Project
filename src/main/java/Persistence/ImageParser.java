package Persistence;
import Entity.HTMLImageParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sun.plugin.util;
import java.io.IOException;



import static javax.ws.rs.core.HttpHeaders.USER_AGENT;
import static sun.plugin.util.ProgressMonitor.get;

@Path("/image")
public class ImageParser {

    Document doc;
    String imgSrc;
    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getImages(@PathParam("param") String msg) throws IOException {
        doc = Jsoup.connect("https://www.google.com/search?hl=en&site=imghp&tbm=isch&source=hp&q="+msg).userAgent(USER_AGENT).get();
        HTMLImageParser htmlImageParser = new HTMLImageParser();

        Element image = doc.select("img").first();
        imgSrc = image.absUrl("src");


        //Document doc = Jsoup.connect(url).get();
        //return Response.ok(doc.body()).build();
        return Response.ok(imgSrc).build();

    }
}

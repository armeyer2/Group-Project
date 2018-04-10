package Persistence;

import Entity.HTMLImageParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static javax.ws.rs.core.HttpHeaders.USER_AGENT;

@Path("/image")
public class ImageParser {

    Document doc;
    String imgSrc;


    @GET
    @Path("/{param}")
    @Produces("application/json")
    public Response getImages(@PathParam("param") String msg) throws IOException {

        //doc = Jsoup.connect("https://www.google.com/search?hl=en&site=imghp&tbm=isch&source=hp&q="+msg).userAgent(USER_AGENT).get();


        HTMLImageParser htmlImageParser = new HTMLImageParser();

        //Element image = doc.select("img").first();

        //imgSrc = image.absUrl("src");


        String imgSrc = htmlImageParser.ImageSearch(msg);

        Set<String> imageSet;

        imageSet = new HashSet<String>(Arrays.asList(msg, imgSrc));

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String arrayToJson = objectMapper.writeValueAsString(imageSet);

        return Response.status(200).entity(arrayToJson).build();


    }



}
/** String googleSearch = request.getParameter("imageName");

 String imgSrc = imageParse.ImageSearch(googleSearch);*/
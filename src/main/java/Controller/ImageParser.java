package Controller;

import Entity.HTMLImageParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.*;

/**
 * This is the API class that user the HTMLImageParser
 * to return a valid json that holds searchTerm and a link to the image
 */
@Path("/image")
public class ImageParser {

    @GET
    @Path("/{param}")
    @Produces("application/json")
    public Response getImages(@PathParam("param") String msg) throws IOException {

        //instantiate the parser class
        HTMLImageParser htmlImageParser = new HTMLImageParser();

        String imgSrc = htmlImageParser.ImageSearch(msg);

        Set<String> imageSet;

        imageSet = new HashSet<String>(Arrays.asList(msg, imgSrc));

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String arrayToJson = objectMapper.writeValueAsString(imageSet);

        return Response.status(200).entity(arrayToJson).build();

    }

    @GET
    @Path("multiple/{param}")
    @Produces("application/json")
    public Response getMultipleImages(@PathParam("param") String msg) throws IOException {

        //instantiate the parser class
        HTMLImageParser htmlImageParser = new HTMLImageParser();

        List<String> imgSrc = htmlImageParser.MultipleImageSearch(msg);


        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String arrayToJson = objectMapper.writeValueAsString(imgSrc);

        return Response.status(200).entity(arrayToJson).build();

    }
}

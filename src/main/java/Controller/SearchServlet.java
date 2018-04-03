package Controller;

import Entity.*;

import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        name = "Search Results",
        urlPatterns = "/searchServlet")

public class SearchServlet extends HttpServlet {
    HTMLImageParser imageParse = new HTMLImageParser();
    HTMLLinkParser linkParse = new HTMLLinkParser();

    private String imgLink;
    private String imgSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String googleSearch = request.getParameter("imageName");
        searchForImage(googleSearch);

        RequestDispatcher dispatcher = request.getRequestDispatcher("../webapp/searchResults.jsp");
        dispatcher.forward(request, response);
    }

    private void searchForImage(String googleSearch) {
        imageParse.ImageSearch(googleSearch);
        linkParse.LinkSearch(googleSearch);

    }
}
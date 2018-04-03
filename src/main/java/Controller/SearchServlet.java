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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(
        name = "Search Results",
        urlPatterns = "/searchServlet")

public class SearchServlet extends HttpServlet {
    HTMLImageParser imageParse = new HTMLImageParser();
    HTMLLinkParser linkParse = new HTMLLinkParser();

    private String url = "/searchResults.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String googleSearch = request.getParameter("imageName");

       /* ArrayList<String> imgInfo = new ArrayList<String>();

        // img src
        imgInfo.add(imageParse.ImageSearch(googleSearch).get(0));
        // img alt
        imgInfo.add(imageParse.ImageSearch(googleSearch).get(1));
        // img href
//        imgInfo.add(linkParse.LinkSearch(googleSearch));*/
        String imgSrc = "https://www.google.com/"+imageParse.ImageSearch(googleSearch);

        HttpSession session = request.getSession();
        session.setAttribute("searchItem", googleSearch);
        session.setAttribute("imgSrc", imgSrc);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
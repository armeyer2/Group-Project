package Controller;

import Entity.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(
        name = "Search Results",
        urlPatterns = "/searchServlet")

public class SearchServlet extends HttpServlet {
    HTMLImageParser imageParse = new HTMLImageParser();


    private String url = "/searchResults.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String googleSearch = request.getParameter("imageName");

        String imgSrc = imageParse.ImageSearch(googleSearch);


        HttpSession session = request.getSession();
        session.setAttribute("searchItem", googleSearch);
        session.setAttribute("imgSrc", imgSrc);


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
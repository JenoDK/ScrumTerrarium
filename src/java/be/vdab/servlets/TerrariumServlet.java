/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.servlets;

import be.vdab.entities.Terrarium;
import be.vdab.services.SpelService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet("/terrarium.htm")
public class TerrariumServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String VIEW = "/WEB-INF/JSP/terrarium.jsp";
    private static final String REDIRECT_VIEW = "/index.htm";
    private SpelService spelService;
    private int grootte,planten,herbivoren,carnivoren,
            omnivoren,extraPlanten,maximumBezetting,actueleBezetting;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //this.getServletConfig().getServletContext().getAttribute("sharedId");
        grootte = (Integer)(this.getServletContext().getAttribute("grootte"));
        System.out.println("***GROOTTE***" + grootte);
        planten = (Integer)(this.getServletConfig().getServletContext().getAttribute("planten"));
        herbivoren = (Integer)(this.getServletConfig().getServletContext().getAttribute("herbivoren"));
        carnivoren = (Integer)(this.getServletConfig().getServletContext().getAttribute("carnivoren"));
        omnivoren = (Integer)(this.getServletConfig().getServletContext().getAttribute("omnivoren"));
        extraPlanten = (Integer)(this.getServletConfig().getServletContext().getAttribute("extraPlanten"));
        spelService = new SpelService(grootte, planten, extraPlanten, herbivoren, carnivoren, omnivoren);
        request.setAttribute("terrarium", spelService.getTerrarium());
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String button = request.getParameter("terrButton");
        if (button.equals("Volgende dag")){
            spelService.nieuweDag();
            request.setAttribute("terrarium", spelService.getTerrarium());
            request.getRequestDispatcher(VIEW).forward(request, response);
        }
    }

}

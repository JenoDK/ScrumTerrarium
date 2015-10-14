/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.servlets;

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
public class Terrarium extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String VIEW = "/WEB-INF/JSP/terrarium.jsp";
    private SpelService spelService;
    private int grootte,planten,herbivoren,carnivoren,
            omnivoren,extraPlanten,maximumBezetting,actueleBezetting;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        grootte = Integer.parseInt(request.getParameter("grootte"));
        planten = Integer.parseInt(request.getParameter("planten"));
        herbivoren = Integer.parseInt(request.getParameter("herbivoren"));
        carnivoren = Integer.parseInt(request.getParameter("carnivoren"));
        omnivoren = Integer.parseInt(request.getParameter("omnivoren"));
        extraPlanten = Integer.parseInt(request.getParameter("extraPlanten"));
        spelService = new SpelService(grootte, planten, extraPlanten, herbivoren, carnivoren, omnivoren);
        request.setAttribute("terrarium", spelService.getTerrarium());
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}

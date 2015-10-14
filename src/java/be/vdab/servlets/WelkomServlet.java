/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.servlets;

import be.vdab.services.SpelService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet("/index.htm")
public class WelkomServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/welkom.jsp";
    private static final String REDIRECT_VIEW = "terrarium.htm";
    private int grootte, planten, herbivoren, carnivoren,
            omnivoren, extraPlanten, maximumBezetting, actueleBezetting;
    private SpelService spelService = new SpelService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        grootte = spelService.getTerrarium().getGrootte();
        planten = spelService.getTerrarium().getAantalPlanten();
        herbivoren = spelService.getTerrarium().getAantalHerbivoren();
        carnivoren = spelService.getTerrarium().getAantalCarnivoren();
        omnivoren = spelService.getTerrarium().getAantalOmnivoren();
        extraPlanten = spelService.getTerrarium().getAantalExtraPlantenPerDag();
        
        request.setAttribute("grootte", grootte);
        request.setAttribute("planten", planten);
        request.setAttribute("herbivoren", herbivoren);
        request.setAttribute("carnivoren", carnivoren);
        request.setAttribute("omnivoren", omnivoren);
        request.setAttribute("extraPlanten", extraPlanten);

        request.getRequestDispatcher(VIEW).forward(request, response);

    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> fouten = new ArrayList<>();
        try {
            grootte = Integer.parseInt(request.getParameter("grootte"));
        } catch (NumberFormatException ex) {
            fouten.add("Gelieve grootte van het veld als nummer in te geven");
            request.setAttribute("fouten", fouten);
            request.getRequestDispatcher(VIEW).forward(request, response);

        }
        try {
            planten = Integer.parseInt(request.getParameter("planten"));
        } catch (NumberFormatException ex) {
            fouten.add("Gelieve aantal planten nummer in te geven");
            request.setAttribute("fouten", fouten);
            request.getRequestDispatcher(VIEW).forward(request, response);

        }
        try {
            herbivoren = Integer.parseInt(request.getParameter("herbivoren"));
        } catch (NumberFormatException ex) {
            fouten.add("Gelieve aantal herbivoren als nummer in te geven");
            request.setAttribute("fouten", fouten);
            request.getRequestDispatcher(VIEW).forward(request, response);

        }
        try {
            carnivoren = Integer.parseInt(request.getParameter("carnivoren"));
        } catch (NumberFormatException ex) {
            fouten.add("Gelieve aantal carnivoren nummer in te geven");
            request.setAttribute("fouten", fouten);
            request.getRequestDispatcher(VIEW).forward(request, response);

        }
        try {
            omnivoren = Integer.parseInt(request.getParameter("omnivoren"));
        } catch (NumberFormatException ex) {
            fouten.add("Gelieve aantal omnivoren nummer in te geven");
            request.setAttribute("fouten", fouten);
            request.getRequestDispatcher(VIEW).forward(request, response);

        }
        try {
            extraPlanten = Integer.parseInt(request.getParameter("extraPlanten"));
        } catch (NumberFormatException ex) {
            fouten.add("Gelieve aantal extra planten per beurt als nummer in te geven");
            request.setAttribute("fouten", fouten);
            request.getRequestDispatcher(VIEW).forward(request, response);

        }
        actueleBezetting = planten + herbivoren + carnivoren + omnivoren;
        maximumBezetting = (grootte * grootte) / 2;

        if (grootte < 6 || grootte > 20) {
            fouten.add("Het veld moet tussen 6x6 en 20x20 zijn.");
        }
        if (planten <= 0 || herbivoren <= 0) {
            fouten.add("Er moet zich minstens 1 plant en 1 hebivoor in het veld bevinden");
        }

        if (carnivoren < 0 || omnivoren < 0) {
            fouten.add("Men kan geen negatieve carnivoren of omnivoren toevoegen.");
        }
        if (extraPlanten < 1) {
            fouten.add("Er moet minstens 1 plant per beurt toegevoegd worden.");
        }

        if (actueleBezetting > maximumBezetting) {
            fouten.add("Er mag maximum de helft van het veld bezet worden bij START.");
        }

        if (fouten.isEmpty()) {
            this.getServletContext().setAttribute("grootte", grootte);
            this.getServletConfig().getServletContext().setAttribute("planten", planten);
            this.getServletConfig().getServletContext().setAttribute("herbivoren", herbivoren);
            this.getServletConfig().getServletContext().setAttribute("carnivoren", carnivoren);
            this.getServletConfig().getServletContext().setAttribute("omnivoren", omnivoren);
            this.getServletConfig().getServletContext().setAttribute("extraPlanten", extraPlanten);
//            request.setAttribute("grootte", grootte);
//            request.setAttribute("planten", planten);
//            request.setAttribute("herbivoren", herbivoren);
//            request.setAttribute("carnivoren", carnivoren);
//            request.setAttribute("omnivoren", omnivoren);
//            request.setAttribute("extraPlanten", extraPlanten);
            response.sendRedirect(String.format(REDIRECT_VIEW, request
                    .getContextPath()));
        } else {
            request.setAttribute("fouten", fouten);
            request.getRequestDispatcher(VIEW).forward(request, response);

        }

    }
}

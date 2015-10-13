/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.servlets;

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
    private static final String REDIRECT_VIEW = "/terrarium.htm";
    private long grootte,planten,herbivoren,carnivoren,
            omnivoren,extraPlanten,maximumBezetting,actueleBezetting;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(VIEW).forward(request, response);

    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> fouten = new ArrayList<>();
        grootte = Long.parseLong(request.getParameter("grootte"));
        planten = Long.parseLong(request.getParameter("planten"));
        herbivoren = Long.parseLong(request.getParameter("herbivoren"));
        carnivoren = Long.parseLong(request.getParameter("carnivoren"));
        omnivoren = Long.parseLong(request.getParameter("omnivoren"));
        extraPlanten = Long.parseLong(request.getParameter("extraPlanten"));
        actueleBezetting = planten + herbivoren + carnivoren + omnivoren; 
        maximumBezetting = (grootte*grootte)/2;
        
        if(grootte<6 || grootte >20){
            fouten.add("Het veld moet tussen 6x6 en 20x20 zijn.");
        }
        if(planten<=0 || herbivoren<=0){
            fouten.add("Er moet zich minstens 1 plant en 1 hebivoor in het veld bevinden");
        }
        
        if(carnivoren <0 ||omnivoren<0){
            fouten.add("Men kan geen negatieve carnivoren of omnivoren toevoegen.");
        }
        if(extraPlanten<1){
            fouten.add("Er moet minstens 1 plant per beurt toegevoegd worden.");
        }
        
        if(actueleBezetting>maximumBezetting){
            fouten.add("Er mag maximum de helft van het veld bezet worden bij START.");
        }
        
        if (fouten.isEmpty()) {
                this.getServletContext().setAttribute("grootte",grootte);
                this.getServletContext().setAttribute("planten",planten);
                this.getServletContext().setAttribute("herbivoren",herbivoren);
                this.getServletContext().setAttribute("carnivoren",carnivoren);
                this.getServletContext().setAttribute("omnivoren",omnivoren);
                this.getServletContext().setAttribute("extraPlanten",extraPlanten);
                response.sendRedirect(response.encodeRedirectURL(request
                    .getContextPath() + REDIRECT_VIEW));
            }
        
        else{
            request.setAttribute("fouten", fouten);     
            request.getRequestDispatcher(VIEW).forward(request, response);
            
        }

    }
}

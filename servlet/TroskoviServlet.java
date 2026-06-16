/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package rs.ac.bg.fon.web.app.drugi.kolokvijum.servlet;

import jakarta.servlet.ServletConfig;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.MyAction;

/**
 *
 * @author Aleksandar Milicevic
 */
@WebServlet(name="TroskoviServlet", urlPatterns={"/troskovi/*"})
public class TroskoviServlet extends HttpServlet {
    
    @Autowired
    @Qualifier(value = "prikaziActon")
    private MyAction prikaziActon;
    
    @Autowired
    @Qualifier(value = "promeniStatusAction")
    private MyAction promeniStatusAction;
    
    @Autowired
    @Qualifier(value = "obrisiAction")
    private MyAction obrisiAction;
    
    @Autowired
    @Qualifier(value = "potvrdaBrisanjaAction")
    private MyAction potvrdaBrisanjaAction;
    
    @Autowired
    @Qualifier(value = "dodajTrosakAction")
    private MyAction dodajTrosakAction;
    
    @Autowired
    @Qualifier(value = "potvrdiDodavanjeAction")
    private MyAction potvrdiDodavanjeAction;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getPathInfo();
        String page = "/WEB-INF/pages/main.jsp";
        
        if(action.contains("/prikazi")) {
            page = prikaziActon.execute(request);
        } else if(action.contains("/promeniStatus/")) {
            page = promeniStatusAction.execute(request);
        } else if(action.contains("/obrisi/")) {
            page = obrisiAction.execute(request);
        } else if(action.contains("/potvrdiBrisanje")) {
            page = potvrdaBrisanjaAction.execute(request);
        } else if(action.contains("/dodaj")) {
            page = dodajTrosakAction.execute(request);
        } else if(action.contains("/potvrdaDodavanja")) {
            page = potvrdiDodavanjeAction.execute(request);
        }
        
        request.getRequestDispatcher(page).forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("context");
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

}

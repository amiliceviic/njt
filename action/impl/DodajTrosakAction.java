/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rs.ac.bg.fon.web.app.drugi.kolokvijum.action.impl;

import jakarta.servlet.http.HttpServletRequest;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.MyAction;

/**
 *
 * @author Aleksandar Milicevic
 */
public class DodajTrosakAction implements MyAction {

    @Override
    public String execute(HttpServletRequest request) {
        String naziv = request.getParameter("naziv");
        String iznos = request.getParameter("iznos");
        
        request.setAttribute("naziv", naziv);
        request.setAttribute("iznos", iznos);
        
        return "/WEB-INF/pages/potvrda_dodavanja.jsp";
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rs.ac.bg.fon.web.app.drugi.kolokvijum.action.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.MyAction;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.dto.KorisnikDto;

/**
 *
 * @author Aleksandar Milicevic
 */
public class LogoutAction implements MyAction {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        
        KorisnikDto korisnik = (KorisnikDto) session.getAttribute("ulogovaniKorisnik");
        
        korisnik.setOnline(false);
        
        session.invalidate();
        
        request.setAttribute("message", "Krosnik se uspesno odjavio sa sistem!");
        
        return "/login.jsp";
    }

}

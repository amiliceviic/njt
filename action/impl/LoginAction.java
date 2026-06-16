/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rs.ac.bg.fon.web.app.drugi.kolokvijum.action.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.MyAction;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.domain.Status;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.dto.KorisnikDto;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.dto.TrosakDto;

/**
 *
 * @author Aleksandar Milicevic
 */
public class LoginAction implements MyAction {

    @Override
    public String execute(HttpServletRequest request) {
        String korisnickoIme = request.getParameter("korisnickoIme");
        String sifra = request.getParameter("sifra");
        
        List<KorisnikDto> korisnici = (List<KorisnikDto>) request.getServletContext().getAttribute("korisnici");
        boolean flag = false;
        
        String page = "/login.jsp";
        
        for(KorisnikDto korisnik: korisnici) {
            if(korisnik.getKorisnickoIme().equals(korisnickoIme) && korisnik.getSifra().equals(sifra)) {
                
                if(korisnik.isOnline()) {
                    request.setAttribute("message", "Greska, korisnik je vec ulogovan na sistem!");
                    return page;
                }
                
                HttpSession session = request.getSession(true);
                flag = true;
                
                korisnik.setOnline(true);
                
                session.setAttribute("ulogovaniKorisnik", korisnik);
                
                List<TrosakDto> troskovi = korisnik.getTroskovi();
                
                session.setAttribute("brojTroskova", troskovi.size());
                
                double sumaRealizovanihTroskova = 0;
                for(TrosakDto trosak: troskovi) {
                    if(trosak.getStatus() == Status.REALIZOVAN) {
                        sumaRealizovanihTroskova += trosak.getIznos();
                    }
                }
                session.setAttribute("sumaRealizovanihTroskova", sumaRealizovanihTroskova);
                
                page = "/WEB-INF/pages/main.jsp";
                break;
            }
        }
        
        if(!flag) request.setAttribute("message", "Greska, korisnik ne postoji!");
        
        return page;
    }

}

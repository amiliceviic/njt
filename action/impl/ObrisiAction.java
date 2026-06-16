/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rs.ac.bg.fon.web.app.drugi.kolokvijum.action.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.MyAction;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.dto.KorisnikDto;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.dto.TrosakDto;

/**
 *
 * @author Aleksandar Milicevic
 */
public class ObrisiAction implements MyAction {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        
        KorisnikDto korisnik = (KorisnikDto) session.getAttribute("ulogovaniKorisnik");
        
        List<TrosakDto> troskovi = korisnik.getTroskovi();
        TrosakDto trosakZaBrisanje = null;
        
        String[] parts = request.getPathInfo().split("/");
        int id = Integer.parseInt(parts[parts.length - 1]);
        
        for(TrosakDto trosak: troskovi) {
            if(trosak.getId() == id) {
                trosakZaBrisanje = trosak;
                break;
            }
        }
        
        request.setAttribute("trosakZaBrisanje", trosakZaBrisanje);
        
        return "/WEB-INF/pages/potvrda_brisanja.jsp";
    }

}

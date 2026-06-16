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
public class PromeniStatusAction implements MyAction {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        
        KorisnikDto korisnik = (KorisnikDto) session.getAttribute("ulogovaniKorisnik");
        
        List<TrosakDto> troskovi = korisnik.getTroskovi();
        
        String[] parts = request.getPathInfo().split("/");
        int id = Integer.parseInt(parts[parts.length - 1]);
        
        for(TrosakDto trosak: troskovi) {
            if(trosak.getId() == id) {
                Status trenutniStatus = trosak.getStatus();
                if(trenutniStatus == Status.PLANIRAN) {
                    trosak.setStatus(Status.REALIZOVAN);
                } else if (trenutniStatus == Status.REALIZOVAN) {
                    trosak.setStatus(Status.PLANIRAN);
                }
                break;
            }
        }

        double sumaRealizovanihTroskova = 0;
        for (TrosakDto trosak : troskovi) {
            if (trosak.getStatus() == Status.REALIZOVAN) {
                sumaRealizovanihTroskova += trosak.getIznos();
            }
        }
        session.setAttribute("sumaRealizovanihTroskova", sumaRealizovanihTroskova);
        
        return "/WEB-INF/pages/main.jsp";
    }

}

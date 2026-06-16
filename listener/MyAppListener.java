/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */

package rs.ac.bg.fon.web.app.drugi.kolokvijum.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.config.AppConfig;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.domain.Status;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.dto.KorisnikDto;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.dto.TrosakDto;

/**
 * Web application lifecycle listener.
 * @author Aleksandar Milicevic
 */
public class MyAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized()");
        
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        sce.getServletContext().setAttribute("context", context);
        
        List<KorisnikDto> korisnici = new ArrayList<>() {
                {
                    List<TrosakDto> troskovi1 = new ArrayList<>();
                    troskovi1.add(new TrosakDto(1, "Kirija", 5000, Status.PLANIRAN));
                    troskovi1.add(new TrosakDto(2, "Voda", 3000, Status.PLANIRAN));
                    troskovi1.add(new TrosakDto(3, "Struja", 7000, Status.PLANIRAN));
                    troskovi1.add(new TrosakDto(4, "Infostan", 2000, Status.REALIZOVAN));
                    
                    List<TrosakDto> troskovi2 = new ArrayList<>();
                    troskovi2.add(new TrosakDto(5, "Kirija", 4000, Status.PLANIRAN));
                    troskovi2.add(new TrosakDto(6, "Voda", 4000, Status.PLANIRAN));
                    troskovi2.add(new TrosakDto(7, "Struja", 8000, Status.REALIZOVAN));
                    troskovi2.add(new TrosakDto(8, "Infostan", 1000, Status.PLANIRAN));
                    
                    add(new KorisnikDto("Ana", "Anic", "ana", "ana", false, troskovi1));
                    add(new KorisnikDto("Pera", "Peric", "pera", "pera", false, troskovi2));
                    add(new KorisnikDto("Zika", "Zikic", "zika", "zika", false));
                }
        };
        sce.getServletContext().setAttribute("korisnici", korisnici);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed()");
    }
}

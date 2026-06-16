/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rs.ac.bg.fon.web.app.drugi.kolokvijum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.MyAction;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.impl.DodajTrosakAction;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.impl.LoginAction;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.impl.LogoutAction;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.impl.ObrisiAction;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.impl.PotvrdaBrisanjaAction;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.impl.PotvrdiDodavanjeAction;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.impl.PrikaziAction;
import rs.ac.bg.fon.web.app.drugi.kolokvijum.action.impl.PromeniStatusAction;

/**
 *
 * @author Aleksandar Milicevic
 */
@Configuration
public class AppConfig {
    
    @Bean(value = "loginAction")
    public MyAction loginAction() {
        return new LoginAction();
    }
    
    @Bean(value = "logoutAction")
    public MyAction logoutAction() {
        return new LogoutAction();
    }
    
    @Bean(value = "prikaziActon")
    public MyAction prikaziActon() {
        return new PrikaziAction();
    }
    
    @Bean(value = "promeniStatusAction")
    public MyAction promeniStatusAction() {
        return new PromeniStatusAction();
    }
    
    @Bean(value = "obrisiAction")
    public MyAction obrisiAction() {
        return new ObrisiAction();
    }
    
    @Bean(value = "potvrdaBrisanjaAction")
    public MyAction potvrdaBrisanjaAction() {
        return new PotvrdaBrisanjaAction();
    }
    
    @Bean(value = "dodajTrosakAction")
    public MyAction dodajTrosakAction() {
        return new DodajTrosakAction();
    }
    
    @Bean(value = "potvrdiDodavanjeAction")
    public MyAction potvrdiDodavanjeAction() {
        return new PotvrdiDodavanjeAction();
    }

}

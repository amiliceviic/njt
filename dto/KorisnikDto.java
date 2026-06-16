/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rs.ac.bg.fon.web.app.drugi.kolokvijum.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aleksandar Milicevic
 */
public class KorisnikDto {
    
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String sifra;
    private boolean online;
    private List<TrosakDto> troskovi;

    public KorisnikDto() {
    }
    
    public KorisnikDto(String ime, String prezime, String korisnickoIme, String sifra, boolean online) {
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.online = online;
        this.troskovi = new ArrayList<>();
    }

    public KorisnikDto(String ime, String prezime, String korisnickoIme, String sifra, boolean online, List<TrosakDto> troskovi) {
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.online = online;
        this.troskovi = troskovi;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public List<TrosakDto> getTroskovi() {
        return troskovi;
    }

    public void setTroskovi(List<TrosakDto> troskovi) {
        this.troskovi = troskovi;
    }

}

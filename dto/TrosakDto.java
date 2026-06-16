/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package rs.ac.bg.fon.web.app.drugi.kolokvijum.dto;

import rs.ac.bg.fon.web.app.drugi.kolokvijum.domain.Status;

/**
 *
 * @author Aleksandar Milicevic
 */
public class TrosakDto {
    
    private int id;
    private String naziv;
    private double iznos;
    private Status status;

    public TrosakDto() {
    }

    public TrosakDto(int id, String naziv, double iznos, Status status) {
        this.id = id;
        this.naziv = naziv;
        this.iznos = iznos;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}

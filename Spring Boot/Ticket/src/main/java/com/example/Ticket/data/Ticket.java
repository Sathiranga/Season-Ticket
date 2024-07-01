package com.example.Ticket.data;

import javax.persistence.*;

@Entity
@Table(name="normal_ticket")
public class Ticket {
    @Id
    private String station;
    @Column(name="colombo")
    private double colombo;

    @Column(name="galle")
    private double galle;

    @Column(name="weligama")
    private double weligama;

    @Column(name="matara")
    private double matara;

    @Column(name="jaffna")
    private double jaffna;

    @Column(name="kandy")
    private double kandy;

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public double getColombo() {
        return colombo;
    }

    public void setColombo(double colombo) {
        this.colombo = colombo;
    }

    public double getGalle() {
        return galle;
    }

    public void setGalle(double galle) {
        this.galle = galle;
    }

    public double getWeligama() {
        return weligama;
    }

    public void setWeligama(double weligama) {
        this.weligama = weligama;
    }

    public double getMatara() {
        return matara;
    }

    public void setMatara(double matara) {
        this.matara = matara;
    }

    public double getJaffna() {
        return jaffna;
    }

    public void setJaffna(double jaffna) {
        this.jaffna = jaffna;
    }

    public double getKandy() {
        return kandy;
    }

    public void setKandy(double kandy) {
        this.kandy = kandy;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;

/**
 *
 * @author PC
 */
public class Fichaje {
    int idFichaje;
    String dni;
    Timestamp FecHoraIni,FecHoraFin;

    public Fichaje(int idFichaje, String dni, Timestamp FecHoraIni) {
        this.idFichaje = idFichaje;
        this.dni = dni;
        this.FecHoraIni = FecHoraIni;
        this.FecHoraFin = null;
    }

    public Fichaje(int idFichaje, String dni, Timestamp FecHoraIni, Timestamp FecHoraFin) {
        this.idFichaje = idFichaje;
        this.dni = dni;
        this.FecHoraIni = FecHoraIni;
        this.FecHoraFin = FecHoraFin;
    }

    public int getIdFichaje() {
        return idFichaje;
    }

    public void setIdFichaje(int idFichaje) {
        this.idFichaje = idFichaje;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Timestamp getFecHoraIni() {
        return FecHoraIni;
    }

    public void setFecHoraIni(Timestamp FecHoraIni) {
        this.FecHoraIni = FecHoraIni;
    }

    public Timestamp getFecHoraFin() {
        return FecHoraFin;
    }

    public void setFecHoraFin(Timestamp FecHoraFin) {
        this.FecHoraFin = FecHoraFin;
    }
}

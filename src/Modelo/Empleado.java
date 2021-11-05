/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author PC
 */
public class Empleado {

    String dni, nombre;
    Double HorasMin, precioHora, precioHoraE;

    public Empleado(String dni, String nombre, Double HorasMin, Double precioHora) {
        this.dni = dni;
        this.nombre = nombre;
        this.HorasMin = HorasMin;
        this.precioHora = precioHora;
        this.precioHoraE = precioHora * 1.75;
    }

    public Empleado(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.HorasMin = 0.0;
        this.precioHora = 0.0;
        this.precioHoraE = 0.0;
    }

    public Empleado(String dni, String nombre, Double HorasMin, Double precioHora, Double precioHoraE) {
        this.dni = dni;
        this.nombre = nombre;
        this.HorasMin = HorasMin;
        this.precioHora = precioHora;
        this.precioHoraE = precioHoraE;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getHorasMin() {
        return HorasMin;
    }

    public void setHorasMin(Double HorasMin) {
        this.HorasMin = HorasMin;
    }

    public Double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(Double precioHora) {
        this.precioHora = precioHora;
    }

    public Double getPrecioHoraE() {
        return precioHoraE;
    }

    public void setPrecioHoraE(Double precioHoraE) {
        this.precioHoraE = precioHoraE;
    }
}

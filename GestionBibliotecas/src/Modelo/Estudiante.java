/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Configuracion.*;
import java.util.*;

/**
 *
 * @author Juan
 */
public class Estudiante extends Usuario {
    private String numExp;
    private String nombre_biblioteca;
    private List<Prestamo> prestamos;
    private List<Reservado> reservas;
    
    public Estudiante(String dni, String nombre, String apellido, String sexo, String email, String password, String numExp, String nombre_biblioteca, List<Prestamo> prestamos, List<Reservado> reservas){
        super(dni, nombre, apellido, sexo, email, password);
        this.numExp = numExp;
        this.nombre_biblioteca = nombre_biblioteca;
        this.prestamos = prestamos;
        this.reservas = reservas;
      
}

    public String getNumExp() {
        return numExp;
    }

    public void setNumExp(String numExp) {
        this.numExp = numExp;
    }

    public String getNombre_biblioteca() {
        return nombre_biblioteca;
    }

    public void setNombre_biblioteca(String nombre_biblioteca) {
        this.nombre_biblioteca = nombre_biblioteca;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public List<Reservado> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reservado> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "numExp=" + numExp + ", nombre_biblioteca=" + nombre_biblioteca + ", prestamos=" + prestamos + ", reservas=" + reservas + '}';
    }
    
    //ACABAR
    public static List<Usuario> getTodos(){
        return null;
    }

}

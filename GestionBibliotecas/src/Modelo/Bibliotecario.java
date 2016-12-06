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
public class Bibliotecario extends Usuario {
    
    private String nombre_biblioteca;

    public Bibliotecario(String dni, String nombre, String apellido, String sexo, String email, String password) {
        super(dni, nombre, apellido, sexo, email, password);
    }
    
    public Bibliotecario(String dni, String nombre, String apellido, String sexo, String email, String password, String nombre_biblioteca) {
        super(dni, nombre, apellido, sexo, email, password);
        this.nombre_biblioteca = nombre_biblioteca;
    }

    public String getNombre_biblioteca() {
        return nombre_biblioteca;
    }

    public void setNombre_biblioteca(String nombre_biblioteca) {
        this.nombre_biblioteca = nombre_biblioteca;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" + "nombre_biblioteca=" + nombre_biblioteca + '}';
    }

    // ACABAR
    public static List<Usuario> getTodos(){
        return null;
    }
    
}

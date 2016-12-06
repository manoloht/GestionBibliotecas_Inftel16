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
public class Admin extends Usuario {
    
    private List<Biblioteca> bibliotecas;

    public Admin(String dni, String nombre, String apellido, String sexo, String email, String password) {
        super(dni, nombre, apellido, sexo, email, password);
    }
    
    public Admin(String dni, String nombre, String apellido, String sexo, String email, String password, List<Biblioteca> bibliotecas) {
        super(dni, nombre, apellido, sexo, email, password);
        this.bibliotecas = bibliotecas;
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    @Override
    public String toString() {
        return "Admin{" + "bibliotecas=" + bibliotecas + '}';
    }
    
    // ACABAR
    public static List<Usuario> getTodos(){
        return null;
    }
}

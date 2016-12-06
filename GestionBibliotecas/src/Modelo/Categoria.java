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
 * @author YUEMEI
 */
public class Categoria implements BaseDatos<Categoria> {

    private String nombre_biblioteca;
    private String nombre_cat;
    private List<Libro> libros;

    public Categoria() {
    }

    public Categoria(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }

    public Categoria(String nombre_biblioteca, String nombre_cat, List<Libro> libros) {
        this.nombre_biblioteca = nombre_biblioteca;
        this.nombre_cat = nombre_cat;
        this.libros = libros;
    }

    public String getNombre_biblioteca() {
        return nombre_biblioteca;
    }

    public String getNombre_cat() {
        return nombre_cat;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setNombre_biblioteca(String nombre_biblioteca) {
        this.nombre_biblioteca = nombre_biblioteca;
    }

    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Categoria{" + "nombre_biblioteca=" + nombre_biblioteca + ", nombre_cat=" + nombre_cat + ", libros=" + libros + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nombre_biblioteca);
        hash = 29 * hash + Objects.hashCode(this.nombre_cat);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.nombre_biblioteca, other.nombre_biblioteca)) {
            return false;
        }
        return Objects.equals(this.nombre_cat, other.nombre_cat);
    }

    @Override //ACABAR
    public boolean insertar() {
        return false;
    }

    @Override //ACABAR
    public boolean actualizar() {
        return false;
    }

    @Override //ACABAR
    public boolean borrar() {
        return false;
    }

    @Override //ACABAR
    public boolean comprobar() {
        return false;
    }

    @Override //ACABAR
    public boolean buscar() {
        return false;
    }
    
    // ACABAR
    public static List<Categoria> getTodas(){
        return null;
    }
}

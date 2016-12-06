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
public class Editorial implements BaseDatos<Editorial> {

    private String nombre_edit;
    private List<Libro> libros;

    public Editorial() {
    }

    public Editorial(String nombre_edit) {
        this.nombre_edit = nombre_edit;
    }

    public Editorial(String nombre_edit, List<Libro> libros) {
        this.nombre_edit = nombre_edit;
        this.libros = libros;
    }

    public String getNombre_edit() {
        return nombre_edit;
    }

    public void setNombre_edit(String nombre_edit) {
        this.nombre_edit = nombre_edit;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Editorial{" + "nombre_edit=" + nombre_edit + ", libros=" + libros + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.nombre_edit);
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
        final Editorial other = (Editorial) obj;
        return Objects.equals(this.nombre_edit, other.nombre_edit);
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
    public static List<Editorial> getTodas() {
        return null;
    }

}

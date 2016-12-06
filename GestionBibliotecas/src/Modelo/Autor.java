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
public class Autor implements BaseDatos<Autor>{

    private int id_autor;
    private String nombre;
    private String apellido;
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(int id_autor, String nombre, String apellido) {
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Autor(int id_autor, String nombre, String apellido, List<Libro> libros) {
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.libros = libros;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" + "id_autor=" + id_autor + ", nombre=" + nombre + ", apellido=" + apellido + ", libros=" + libros + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id_autor;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.apellido);
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
        final Autor other = (Autor) obj;
        if (this.id_autor != other.id_autor) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.apellido, other.apellido);
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
    
    //ACABAR
    public static List<Autor> getTodos(){
        return null;
    }
}

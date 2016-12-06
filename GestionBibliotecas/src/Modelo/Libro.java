/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.*;
import Configuracion.*;


/**
 *
 * @author YUEMEI
 */
public class Libro implements BaseDatos<Libro> {

    private String isbn;
    private String titulo;
    private Date fecha_edi;
    private String nombre_categoria;
    private List<Ejemplar> ejemplares;
    private List<Autor> autores;
    private String editorial;

    public Libro() {
    }

    public Libro(String isbn, String titulo, Date fecha_edi) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fecha_edi = fecha_edi;
    }

    public Libro(String isbn, String titulo, Date fecha_edi, String nombre_categoria, List<Ejemplar> ejemplares, List<Autor> autores, String editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fecha_edi = fecha_edi;
        this.nombre_categoria = nombre_categoria;
        this.ejemplares = ejemplares;
        this.autores = autores;
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getFecha_edi() {
        return fecha_edi;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public List<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFecha_edi(Date fecha_edi) {
        this.fecha_edi = fecha_edi;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public void setEjemplares(List<Ejemplar> ejemplares) {
        this.ejemplares = ejemplares;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", fecha_edi=" + fecha_edi + ", nombre_categoria=" + nombre_categoria + ", ejemplares=" + ejemplares + ", autores=" + autores + ", editorial=" + editorial + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.isbn);
        hash = 73 * hash + Objects.hashCode(this.titulo);
        hash = 73 * hash + Objects.hashCode(this.fecha_edi);
        hash = 73 * hash + Objects.hashCode(this.nombre_categoria);
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
        final Libro other = (Libro) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.nombre_categoria, other.nombre_categoria)) {
            return false;
        }
        return Objects.equals(this.fecha_edi, other.fecha_edi);
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
    public static List<Libro> getTodos(){
        return null;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
import Configuracion.*;

/**
 *
 * @author YUEMEI
 */
public class Libro {
    private String isbn;
    private String titulo;
    private Date fecha_edi;

    public Libro() {
    }

    public Libro(String isbn, Date fecha_edi) {
        this.isbn = isbn;
        this.fecha_edi = fecha_edi;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha_edi() {
        return fecha_edi;
    }

    public void setFecha_edi(Date fecha_edi) {
        this.fecha_edi = fecha_edi;
    }
    
    
}

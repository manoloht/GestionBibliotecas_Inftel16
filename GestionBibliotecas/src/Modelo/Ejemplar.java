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
public class Ejemplar implements BaseDatos<Ejemplar> {

    private int id_ejem;
    private String nombre_libro;

    public Ejemplar() {
    }

    public Ejemplar(int id_ejem) {
        this.id_ejem = id_ejem;
    }

    public Ejemplar(int id_ejem, String nombre_libro) {
        this.id_ejem = id_ejem;
        this.nombre_libro = nombre_libro;
    }

    public int getId_ejem() {
        return id_ejem;
    }

    public void setId_ejem(int id_ejem) {
        this.id_ejem = id_ejem;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    @Override
    public String toString() {
        return "Ejemplar{" + "id_ejem=" + id_ejem + ", nombre_libro=" + nombre_libro + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id_ejem;
        hash = 37 * hash + Objects.hashCode(this.nombre_libro);
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
        final Ejemplar other = (Ejemplar) obj;
        if (this.id_ejem != other.id_ejem) {
            return false;
        }
        return Objects.equals(this.nombre_libro, other.nombre_libro);
    }

    @Override // ACABAR
    public boolean insertar() {
        return false;
    }

    @Override // ACABAR
    public boolean actualizar() {
        return false;
    }

    @Override // ACABAR
    public boolean borrar() {
        return false;
    }

    @Override // ACABAR
    public boolean comprobar() {
        return false;
    }

    @Override // ACABAR
    public boolean buscar() {
        return false;
    }

    // ACABAR
    public static List<Ejemplar> getTodos() {
        return null;
    }

}

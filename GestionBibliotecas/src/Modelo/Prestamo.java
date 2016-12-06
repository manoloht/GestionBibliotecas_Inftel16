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
public class Prestamo implements BaseDatos<Prestamo> {

    private Date fecha_ini;
    private Date fecha_fin;
    private String numExp;
    private int id_ejem;

    public Prestamo() {

    }

    public Prestamo(Date fecha_ini, Date fecha_fin, String numExp, int id_ejem) {
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.numExp = numExp;
        this.id_ejem = id_ejem;
    }

    public Date getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(Date fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getNumExp() {
        return numExp;
    }

    public void setNumExp(String numExp) {
        this.numExp = numExp;
    }

    public int getId_ejem() {
        return id_ejem;
    }

    public void setId_ejem(int id_ejem) {
        this.id_ejem = id_ejem;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "fecha_ini=" + fecha_ini + ", fecha_fin=" + fecha_fin + ", numExp=" + numExp + ", id_ejem=" + id_ejem + '}';
    }
   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.fecha_ini);
        hash = 19 * hash + Objects.hashCode(this.fecha_fin);
        hash = 19 * hash + Objects.hashCode(this.numExp);
        hash = 19 * hash + this.id_ejem;
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
        final Prestamo other = (Prestamo) obj;
        if (this.id_ejem != other.id_ejem) {
            return false;
        }
        if (!Objects.equals(this.numExp, other.numExp)) {
            return false;
        }
        if (!Objects.equals(this.fecha_ini, other.fecha_ini)) {
            return false;
        }
        return Objects.equals(this.fecha_fin, other.fecha_fin);
    }
    
    //ACABAR
    public static List<Prestamo> getTodos() {
        return null;
    }

    @Override  //ACABAR
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
}

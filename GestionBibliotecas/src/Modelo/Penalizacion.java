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
public class Penalizacion implements BaseDatos<Penalizacion> {

    private Date Fecha_inicio;
    private Date Fecha_fin;
    private String numExp;

    public Penalizacion() {
    
    }

    public Penalizacion(Date Fecha_inicio, Date Fecha_fin, String numExp) {
        this.Fecha_inicio = Fecha_inicio;
        this.Fecha_fin = Fecha_fin;
        this.numExp = numExp;
    }

    public Date getFecha_inicio() {
        return Fecha_inicio;
    }

    public Date getFecha_fin() {
        return Fecha_fin;
    }

    public String getNumExp() {
        return numExp;
    }

    public void setFecha_inicio(Date Fecha_inicio) {
        this.Fecha_inicio = Fecha_inicio;
    }

    public void setFecha_fin(Date Fecha_fin) {
        this.Fecha_fin = Fecha_fin;
    }

    public void setNumExp(String numExp) {
        this.numExp = numExp;
    }

    @Override
    public String toString() {
        return "Penalizacion{" + "Fecha_inicio=" + Fecha_inicio + ", Fecha_fin=" + Fecha_fin + ", numExp=" + numExp + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.Fecha_inicio);
        hash = 59 * hash + Objects.hashCode(this.Fecha_fin);
        hash = 59 * hash + Objects.hashCode(this.numExp);
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
        final Penalizacion other = (Penalizacion) obj;
        if (!Objects.equals(this.numExp, other.numExp)) {
            return false;
        }
        if (!Objects.equals(this.Fecha_inicio, other.Fecha_inicio)) {
            return false;
        }
        return Objects.equals(this.Fecha_fin, other.Fecha_fin);
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
    public static List<Penalizacion> getTodas() {
        return null;
    }
}

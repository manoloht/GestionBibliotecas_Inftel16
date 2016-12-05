/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Configuracion.*;
import java.util.Date;

/**
 *
 * @author YUEMEI
 */
public class Prestamo {
    private  Date fecha_ini;
    private Date fecha_fin;

    public Prestamo() {
    }

    public Prestamo(Date fecha_ini, Date fecha_fin) {
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
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

   
    
    
}

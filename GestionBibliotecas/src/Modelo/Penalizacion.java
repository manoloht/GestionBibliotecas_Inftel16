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
 * @author Juan
 */
public class Penalizacion {
    private Date Fecha_inicio;
    private Date Fecha_fin;
    
    public Penalizacion (){};
    
    public Penalizacion (Date Fecha_inicio, Date Fecha_fin){
        this.Fecha_inicio = Fecha_inicio;
        this.Fecha_fin = Fecha_fin;
    }
 
}

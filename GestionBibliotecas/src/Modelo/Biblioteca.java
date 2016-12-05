/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Juan
 */
public class Biblioteca {
    private String nombre;
    private String localizacion;
    private int telefono;
    
    public Biblioteca(){};
    
    public Biblioteca(String nombre, String localizacion, int telefono){
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.telefono = telefono;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alberto jesus carrion leiva
 * @param <T>
 */

public interface BaseDatos <T>{
    public boolean insertar();
    public boolean actualizar(T obj);
    public boolean borrar();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbibliotecas;

/**
 *
 * @author alberto jesus carrion leiva
 * @param <T>
 */

public interface BaseDatos<T> {
    public boolean insertar(T objeto);
    public boolean actualizar(T objeto);
    public boolean borrar(T objeto);
    public boolean comprobar(T objeto);
}

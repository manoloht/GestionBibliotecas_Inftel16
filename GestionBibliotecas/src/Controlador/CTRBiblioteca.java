/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Biblioteca;
import java.util.List;

/**
 *
 * @author albertocheca
 */
public class CTRBiblioteca {

    public static List<Biblioteca> getTodasBibliotecas() {
        List<Biblioteca> bibliotecas = Biblioteca.getTodosBibliotecas();
        return bibliotecas;
    }

    public static List<Biblioteca> getBibliotecas(String nombre) {
        List<Biblioteca> bibliotecas = Biblioteca.getTodosBibliotecas();
        return bibliotecas;
    }

    public static boolean crearBiblioteca(String nombre_bib, String dni_admin) {
        return true;
    }

    public static boolean comprobarBiblioteca(String nombre_bib) {
        return true;
    }

    public static boolean editarBiblioteca(String nombre_bib, String dni_admin) {
        return true;
    }
    
    public static boolean borrarBiblioteca(String nombre){
        return true;
    }
}

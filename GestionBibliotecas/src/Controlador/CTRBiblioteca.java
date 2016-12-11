/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Biblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author albertocheca
 */
public class CTRBiblioteca {
    public static List<Biblioteca> getTodasBibliotecas(){
        List<Biblioteca> bibliotecas;
        bibliotecas = new ArrayList<>();
        for(int i = 0; i< 30; i++){
            Biblioteca b = new Biblioteca("alberto "+i);
            bibliotecas.add(b);
        }
        return bibliotecas;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Reservado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author albertocheca
 */
public class CTRReservas {
    public static List<Reservado> getReservasEstudiante(String dni){
        List<Reservado> reservas = new ArrayList<>();
        for (int i = 0; i<12; i++){
            Reservado reservado= new Reservado(dni, dni, 0, dni,  dni, dni, dni);
            reservas.add(reservado);
        }
        return reservas;
    }
}

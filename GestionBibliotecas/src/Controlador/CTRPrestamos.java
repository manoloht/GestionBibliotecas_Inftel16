/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Prestamo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author albertocheca
 */
public class CTRPrestamos {
    
    public static List<Prestamo> getPrestamosEstudiante(String dni){
        List<Prestamo> prestamos = new ArrayList<>();
        for(int i = 0; i<30; i++){
            Prestamo m = new Prestamo(dni, dni, 0, dni,  dni,  dni,  dni);
            prestamos.add(m);
        }
        return prestamos;
    }
}

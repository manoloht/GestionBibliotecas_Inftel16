/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbibliotecas;

import Controlador.*;
import Interfaz.*;

/**
 *
 * @author Manuel
 */
public class GestionBibliotecas {

    public static void main(String[] args) {
        Session sesion = new Session();
        ViewLogin aplicacion = new ViewLogin();
        aplicacion.setVisible(true);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbibliotecas;

import Configuracion.Conexion;
import Modelo.Usuario;
import java.util.*;

/**
 *
 * @author Manuel
 */
public class GestionBibliotecas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Conexion c = new Conexion();
        c.getConnection();
        List<Usuario> u = new ArrayList<>();
        u = Usuario.getTodos();
        for(Usuario s : u){
             System.out.println(s.toString());
        }
        Usuario x = new Usuario("0099k9");
        System.err.println(x.buscar());
        
    }
}

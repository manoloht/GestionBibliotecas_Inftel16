/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Manuel
 */
public class Session {
    static int id_usuario;

    
    public Session() {
    }
    
    public Session(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public static int getId_usuario() {
        return id_usuario;
    }

    public static void setId_usuario(int id_usuario) {
        Session.id_usuario = id_usuario;
    }

    

}

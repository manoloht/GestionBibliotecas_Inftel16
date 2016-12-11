/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author alberto carrion leiva
 */
public class CTRLogin {
    // COMPROBAR SI EXISTE EMAIL Y PASS EN BD, DEVOLVER TRUE EN CASO DE EXISTIR, FALSE EN CASO CONTRARIO
    public static boolean comprobarLogin(String email, String password){
        if( email.equals("0") || email.equals("1") || email.equals("2")){
            return true;
        }else {
            return false;
        }
    }
    
    // OBTENER EL TIPO DE USUARIO, DEVOLVER 0, 1 , 2 (0 - ADMIN, 1 - BIBLIOTECARIO, 2 - ESTUDIANTE) 
    public static int getTipoUsuario(String email, String password){
        if( email.equals("0")){
            return 0;
        }else if  (email.equals("1")){
            return 1;
        }else {
            return 2;
        }
    }
    
    // FUNCION PARA ENVIAR EMAIL DE RECORDAR CONTRASEÑA, DEVOLVER TRUE EN CASO DE ENVIARLO, FALSE EN OTRO CASO
    public static boolean enviarMensaje(String email) {
        if( email.equals("0")){
            return true;
        }else if  (email.equals("1")){
            return true;
        }else {
            return false;
        }
    }
}

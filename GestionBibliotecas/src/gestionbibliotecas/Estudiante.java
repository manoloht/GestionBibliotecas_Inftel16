/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbibliotecas;

/**
 *
 * @author Juan
 */
public class Estudiante extends Usuario {
    private String numExp;
    
public Estudiante(String dni, String nombre, String apellido, String sexo, String email, String password, String numExp){
     super(dni, nombre, apellido, sexo, email, password);
     this.numExp = numExp;
}

    public String getNumExp() {
        return numExp;
    }

    public void setNumExp(String numExp) {
        this.numExp = numExp;
    }

}

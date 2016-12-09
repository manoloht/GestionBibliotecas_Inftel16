/*
Escribir los metodos hechos, para consultar mas rapido
 */
package Controlador;
import Configuracion.*;
import Controlador.*;
import Modelo.*;
import java.sql.Date;


/**
 *
 * @author Manuel
 */
public class ControladorManolo {
    
    public static void main(String[] args){
        
        // Comprobar CRUE Prestamo
        // Prestamo(int id_ejem, String isbn, String dni, String nombre_cat, String nombre_bib)
        int id_ejem = 1001;
        String isbn = "isbn111";
        String dni = "00999999X";
        String categoria = "CategoriaA";
        String biblioteca = "PruebasManolo";
        Date fecha_ini = new Date(10000);

                
        Prestamo p = new Prestamo(id_ejem,isbn,dni,categoria,biblioteca);
        //System.out.println(p.insertar());
        p.setFecha_ini(fecha_ini);

        
        System.out.println(p.toString());
        
        System.out.println(p.insertar());
        
        Categoria e = new Categoria("CategoriaXXX","PruebasManolo");
        System.out.println(e.insertar());
    }
    
}

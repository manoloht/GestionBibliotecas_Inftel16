/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Manuel
 */

public class Conexion {
    
    public Conexion(){
    }
    
    public static Connection getConnection() throws Exception{
        Connection con=null;
            String cadanaConexion="jdbc:oracle:thin:inftel16_11/inftel@olimpia.lcc.uma.es:1521:edgar";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(cadanaConexion);
            
            return con;
        }


}
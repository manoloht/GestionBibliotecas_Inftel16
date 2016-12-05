/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Manuel
 */
public class Conexion {

    public Conexion() {
    }

    public Connection getConnection() throws Exception{
        Properties pr = new Properties();
        InputStream config = ClassLoader.getSystemResourceAsStream(Conexion.class.getPackage().getName()+"/bd.properties");
        pr.load(config);
        config.close();
        
        String driver = pr.getProperty("driver");
        String subprotocolo = pr.getProperty("subprotocolo");
        String usuario = pr.getProperty("usuario");
        String password = pr.getProperty("password");
        String url = pr.getProperty("url");
        int puerto = Integer.parseInt(pr.getProperty("puerto"));
        String sid = pr.getProperty("sid");        
        
        // Cargamos el driver
        Class.forName(driver);
        
        // Preparamos la conexion
        String cadConexion = subprotocolo+":"+usuario+"/"+password+"@"+url+":"+puerto+":"+sid;
        
        // Obtenemos la conexion
        Connection con = DriverManager.getConnection(cadConexion);
        return con;
        
        }
    
}

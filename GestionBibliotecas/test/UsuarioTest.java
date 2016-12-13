///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import Modelo.Usuario;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author albertocheca
// */
//public class UsuarioTest {
//
//    Usuario u, u2;
//
//    public UsuarioTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        u = new Usuario("TetstJUnit", "TetstJUnit", "TetstJUnit", "V", "TetstJUnit", "TetstJUnit");
//        u2 = new Usuario("TetstJUnit2", "TetstJUnit", "TetstJUnit", "V", "TetstJUnit", "TetstJUnit");
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void añadirTest() {
//        boolean i = u2.insertar();
//        boolean x = u.insertar();
//
//        assertEquals(i, false);
//        assertEquals(x, false);
//    }
//
//    @Test
//    public void borrarTest() {
//        boolean i = u2.borrar();
//        assertEquals(i, false);
//    }
//}

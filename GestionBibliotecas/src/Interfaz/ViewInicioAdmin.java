/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.ModificaPenalizacion;
import Controlador.Session;
import Controlador.Util;
import Modelo.Usuario;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alberto carrion leiva
 */
public class ViewInicioAdmin extends javax.swing.JFrame {

    /**
     * Creates new form InicioAdmin
     */
    private ViewUsuariosAdmin vistaUsuariosAdmin;
    private ViewLogin vistaLogin;
    private ViewBibliotecasAdmin vistaBibliotecasAdmin;
    private ViewMiPerfil vistaMiPerfil;
    private final DefaultTableModel modeloTablaLog;

    public ViewInicioAdmin() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        modeloTablaLog = (DefaultTableModel) tablaLog.getModel();
        this.setTitle("Inicio Admin");
        this.bienvenida.setText("NOMBRE: " + Session.getNombre() + " , APELLIDOS: " + Session.getApellidos() + ", ROL: ADMINISTRADOR");
        for(String s: ModificaPenalizacion.InformePenalizacion()){
            Object[]a = new Object[1];
            a[0] = s;
            modeloTablaLog.addColumn(a);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        numResultados = new javax.swing.JLabel();
        bienvenida = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLog = new javax.swing.JTable();
        jMenuBar3 = new javax.swing.JMenuBar();
        Inicio = new javax.swing.JMenu();
        MenuMiPerfil = new javax.swing.JMenuItem();
        MenuSalir = new javax.swing.JMenuItem();
        Gestion = new javax.swing.JMenu();
        MenuGestionUsuarios = new javax.swing.JMenuItem();
        MenuGestionBibliotecas = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);

        jPanel2.setBackground(java.awt.Color.white);

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 40, 40));
        jLabel4.setText("Biblioteca");

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel5.setText("Inftel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 40, 40));
        jLabel6.setText("Bienvenido de Nuevo");

        numResultados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        bienvenida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bienvenida.setText("BIENVENIDA");

        tablaLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mensaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaLog);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(numResultados))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bienvenida)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(1374, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bienvenida)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174)
                .addComponent(numResultados)
                .addContainerGap(593, Short.MAX_VALUE))
        );

        Inicio.setText("Inicio");

        MenuMiPerfil.setText("Mi Perfil");
        MenuMiPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuMiPerfilActionPerformed(evt);
            }
        });
        Inicio.add(MenuMiPerfil);

        MenuSalir.setText("Salir");
        MenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSalirActionPerformed(evt);
            }
        });
        Inicio.add(MenuSalir);

        jMenuBar3.add(Inicio);

        Gestion.setText("Gestionar");

        MenuGestionUsuarios.setText("Usuarios");
        MenuGestionUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuGestionUsuariosActionPerformed(evt);
            }
        });
        Gestion.add(MenuGestionUsuarios);

        MenuGestionBibliotecas.setText("Bibliotecas");
        MenuGestionBibliotecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuGestionBibliotecasActionPerformed(evt);
            }
        });
        Gestion.add(MenuGestionBibliotecas);

        jMenuBar3.add(Gestion);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSalirActionPerformed
        vistaLogin = new ViewLogin();
        vistaLogin.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_MenuSalirActionPerformed

    private void MenuGestionUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuGestionUsuariosActionPerformed

        vistaUsuariosAdmin = new ViewUsuariosAdmin();
        vistaUsuariosAdmin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuGestionUsuariosActionPerformed

    private void MenuGestionBibliotecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuGestionBibliotecasActionPerformed
        vistaBibliotecasAdmin = new ViewBibliotecasAdmin();
        vistaBibliotecasAdmin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuGestionBibliotecasActionPerformed

    private void MenuMiPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuMiPerfilActionPerformed
        vistaMiPerfil = new ViewMiPerfil();
        vistaMiPerfil.mensaje.setText("");
        vistaMiPerfil.setVisible(true);
        vistaMiPerfil.pack();
        vistaMiPerfil.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        vistaMiPerfil.nombre.setText(Session.getNombre());
        vistaMiPerfil.apellidos.setText(Session.getApellidos());
        vistaMiPerfil.dni.setText(Session.getDni());
        vistaMiPerfil.email.setText(Session.getEmail());
        vistaMiPerfil.pass.setText(Session.getPassword());
        vistaMiPerfil.dni.setEnabled(false);

        if (Session.getSexo().equals("H")) {
            vistaMiPerfil.sexo.setSelectedIndex(0);
        } else {
            vistaMiPerfil.sexo.setSelectedIndex(1);
        }
    }//GEN-LAST:event_MenuMiPerfilActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Gestion;
    private javax.swing.JMenu Inicio;
    private javax.swing.JMenuItem MenuGestionBibliotecas;
    private javax.swing.JMenuItem MenuGestionUsuarios;
    private javax.swing.JMenuItem MenuMiPerfil;
    private javax.swing.JMenuItem MenuSalir;
    public javax.swing.JLabel bienvenida;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel numResultados;
    private javax.swing.JTable tablaLog;
    // End of variables declaration//GEN-END:variables
}

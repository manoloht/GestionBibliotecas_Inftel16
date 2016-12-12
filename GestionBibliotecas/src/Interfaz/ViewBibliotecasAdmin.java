/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import Controlador.CTRBiblioteca;
import Controlador.CTRUsuario;
import Modelo.Biblioteca;
import Modelo.Usuario;

/**
 *
 * @author alberto carrion leiva
 */
public class ViewBibliotecasAdmin extends javax.swing.JFrame {

    private final DefaultTableModel modeloTabla;
    private ViewVerBiblioteca vistaVerBiblioteca;
    private ViewCrearBiblioteca vistaCrearBiblioteca;
    private ViewUsuariosAdmin vistaUsuariosAdmin;
    private ViewLogin vistaLogin;
    private ViewBibliotecasAdmin vistaBibliotecasAdmin;
    private ViewMiPerfil vistaMiPerfil;

    /**
     * Creates new form BibliotecasAdmin
     */
    public ViewBibliotecasAdmin() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Bibliotecas");
        modeloTabla = (DefaultTableModel) tablaBibliotecas.getModel();
        List<Biblioteca> bibliotecas = CTRBiblioteca.getTodasBibliotecas();
        for (Biblioteca b : bibliotecas) {
            Object[] fila = new Object[2];
            fila[0] = b.getNombre();
            fila[1] = b.getDni_admin();
            modeloTabla.addRow(fila);
        }
        nResultados.setText("Se han encontrado " + bibliotecas.size() + " resultados.");
        System.out.println("---->  EXITO: Se han encontrado " + bibliotecas.size() + " resultados.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBibliotecas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        campoBusqueda = new javax.swing.JTextField();
        btnBuscarBiblioteca = new javax.swing.JButton();
        btnCrearBiblioteca = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        numResultados = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nResultados = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Inicio = new javax.swing.JMenu();
        MenuMiPerfil = new javax.swing.JMenuItem();
        MenuSalir = new javax.swing.JMenuItem();
        Gestionar = new javax.swing.JMenu();
        MeniuUsuarios = new javax.swing.JMenuItem();
        MenuBibliotecas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);

        jPanel2.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 40, 40));
        jLabel6.setText("Bibliotecas");

        tablaBibliotecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "DNI ADMIN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBibliotecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBibliotecasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBibliotecas);
        if (tablaBibliotecas.getColumnModel().getColumnCount() > 0) {
            tablaBibliotecas.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("NOMBRE");

        btnBuscarBiblioteca.setText("Buscar");
        btnBuscarBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarBibliotecaActionPerformed(evt);
            }
        });

        btnCrearBiblioteca.setText("Crear Biblioteca");
        btnCrearBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearBibliotecaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Buscar Bibliotecas");

        numResultados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel7.setText("Añadir Bibliotecas");

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 40, 40));
        jLabel4.setText("Biblioteca");

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel5.setText("Inftel");

        nResultados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nResultados.setText("MENSAJE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscarBiblioteca))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nResultados)))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(btnCrearBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numResultados)))
                .addContainerGap(1233, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(numResultados))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCrearBiblioteca)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarBiblioteca))
                        .addGap(25, 25, 25)
                        .addComponent(nResultados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(327, Short.MAX_VALUE))
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

        jMenuBar1.add(Inicio);

        Gestionar.setText("Gestionar");

        MeniuUsuarios.setText("Usuarios");
        MeniuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeniuUsuariosActionPerformed(evt);
            }
        });
        Gestionar.add(MeniuUsuarios);

        MenuBibliotecas.setText("Bibliotecas");
        MenuBibliotecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBibliotecasActionPerformed(evt);
            }
        });
        Gestionar.add(MenuBibliotecas);

        jMenuBar1.add(Gestionar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void MeniuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeniuUsuariosActionPerformed
        vistaUsuariosAdmin = new ViewUsuariosAdmin();
        vistaUsuariosAdmin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MeniuUsuariosActionPerformed

    private void MenuBibliotecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBibliotecasActionPerformed
        vistaBibliotecasAdmin = new ViewBibliotecasAdmin();
        vistaBibliotecasAdmin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuBibliotecasActionPerformed

    private void MenuMiPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuMiPerfilActionPerformed
        vistaMiPerfil = new ViewMiPerfil();
        vistaMiPerfil.mensaje.setText("");
        vistaMiPerfil.setVisible(true); 
        vistaMiPerfil.pack();
        vistaMiPerfil.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_MenuMiPerfilActionPerformed

    private void MenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSalirActionPerformed
        vistaLogin = new ViewLogin();
        vistaLogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuSalirActionPerformed

    private void btnCrearBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearBibliotecaActionPerformed

        vistaCrearBiblioteca = new ViewCrearBiblioteca();
        vistaCrearBiblioteca.setVisible(true);
        vistaCrearBiblioteca.pack();
        vistaCrearBiblioteca.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnCrearBibliotecaActionPerformed

    // BOTON PARA BUSCAR USUARIOS

    private void btnBuscarBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarBibliotecaActionPerformed

        modeloTabla.getDataVector().removeAllElements();
        System.out.println("Buscando Bibliotecas con nombre: " + campoBusqueda.getText());
        List<Biblioteca> bibliotecas = CTRBiblioteca.getBibliotecas(campoBusqueda.getText());
        for (Biblioteca b : bibliotecas) {
            Object[] fila = new Object[5];
            fila[0] = b.getNombre();
            fila[1] = b.getDni_admin();
            modeloTabla.addRow(fila);
        }
        nResultados.setText("Se han encontrado " + bibliotecas.size() + " resultados.");
        System.out.println("---->  EXITO: Se han encontrado " + bibliotecas.size() + " resultados.");
    }//GEN-LAST:event_btnBuscarBibliotecaActionPerformed

    private void tablaBibliotecasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBibliotecasMouseClicked
        // TODO add your handling code here:
        int index = tablaBibliotecas.getSelectedRow();
        vistaVerBiblioteca = new ViewVerBiblioteca();
        vistaVerBiblioteca.setVisible(true);
        vistaVerBiblioteca.pack();
        vistaVerBiblioteca.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String nombre_bib = modeloTabla.getValueAt(index, 0).toString();
        String dni_admin = modeloTabla.getValueAt(index, 1).toString();

        vistaVerBiblioteca.nombre.setText(nombre_bib);
        vistaVerBiblioteca.adminSel.addItem(dni_admin);
        List<Usuario> listaAdmin = CTRUsuario.buscarUsuariosRol("administrador");
        for (Usuario u : listaAdmin) {
            vistaVerBiblioteca.adminSel.addItem(u.getDni());
        }
    }//GEN-LAST:event_tablaBibliotecasMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Gestionar;
    private javax.swing.JMenu Inicio;
    private javax.swing.JMenuItem MeniuUsuarios;
    private javax.swing.JMenuItem MenuBibliotecas;
    private javax.swing.JMenuItem MenuMiPerfil;
    private javax.swing.JMenuItem MenuSalir;
    private javax.swing.JButton btnBuscarBiblioteca;
    private javax.swing.JButton btnCrearBiblioteca;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nResultados;
    private javax.swing.JLabel numResultados;
    private javax.swing.JTable tablaBibliotecas;
    // End of variables declaration//GEN-END:variables
}
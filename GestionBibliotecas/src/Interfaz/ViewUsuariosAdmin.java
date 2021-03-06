/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Modelo.Usuario;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Controlador.CTRUsuario;
import Controlador.Session;
import Controlador.Util;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author alberto carrion leiva
 */
public class ViewUsuariosAdmin extends javax.swing.JFrame {

    private String rolBusqueda;
    private String palabraBusqueda;
    private ViewVerUsuario vistaVerUsuario;
    private ViewVerAdmin vistaVerAdmin;
    private ViewVerBibliotecario vistaVerBibliotecario;
    private ViewVerEstudiante vistaVerEstudiante;
    private ViewCrearAdmin vistaCrearAdmin;
    private ViewCrearBibliotecario vistaCrearBibliotecario;
    private ViewCrearEstudiante vistaCrearEstudiante;
    private final DefaultTableModel modeloTabla;
    private ViewUsuariosAdmin vistaUsuariosAdmin;
    private ViewLogin vistaLogin;
    private ViewBibliotecasAdmin vistaBibliotecasAdmin;
    private ViewMiPerfil vistaMiPerfil;

    /**
     * Creates new form UsuariosAdmin
     */
    public ViewUsuariosAdmin() {
        this.rolBusqueda = "Todos";
        this.palabraBusqueda = "Dni";
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Usuarios");
        modeloTabla = (DefaultTableModel) tablaUsuarios.getModel();
        List<Usuario> usuarios = CTRUsuario.getTodosUsuarios();
        for (Usuario u : usuarios) {
            Object[] fila = new Object[5];
            fila[0] = u.getDni();
            fila[1] = u.getNombre();
            fila[2] = u.getApellidos();
            fila[3] = u.getSexo();
            fila[4] = u.getEmail();
            modeloTabla.addRow(fila);
        }
        numResultados.setText("Se han encontrado " + usuarios.size() + " resultados con ROL: " + rolBusqueda);
        System.out.println("---->  EXITO: Se han encontrado " + usuarios.size() + " resultados con ROL: " + rolBusqueda);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        rolElegido = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoBusqueda = new javax.swing.JTextField();
        btnBuscarUsuario = new javax.swing.JButton();
        btnCrearAdmin = new javax.swing.JButton();
        clave = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        numResultados = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCrearBibliotecario = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuMiPerfil = new javax.swing.JMenuItem();
        MenuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuGestionUsuarios = new javax.swing.JMenuItem();
        MenuGestionBibliotecas = new javax.swing.JMenuItem();

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 40, 40));
        jLabel6.setText("Usuarios");

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "NOMBRE", "APELLIDOS", "SEXO", "EMAIL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        rolElegido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Administrador", "Bibliotecario", "Estudiante" }));
        rolElegido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rolElegidoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ROL");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("PALABRA CLAVE");

        btnBuscarUsuario.setText("Buscar");
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        btnCrearAdmin.setText("Crear Administrador");
        btnCrearAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAdminActionPerformed(evt);
            }
        });

        clave.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dni", "Nombre", "Apellidos", "Email" }));
        clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claveActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Buscar Usuarios");

        numResultados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel7.setText("Añadir Usuarios");

        btnCrearBibliotecario.setText("Crear Bibliotecario");
        btnCrearBibliotecario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearBibliotecarioActionPerformed(evt);
            }
        });

        jButton1.setText("Crear Estudiante");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numResultados)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rolElegido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscarUsuario))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCrearAdmin)
                                .addGap(18, 18, 18)
                                .addComponent(btnCrearBibliotecario)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap(768, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearAdmin)
                    .addComponent(btnCrearBibliotecario)
                    .addComponent(jButton1))
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rolElegido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarUsuario))
                .addGap(45, 45, 45)
                .addComponent(numResultados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(525, Short.MAX_VALUE))
        );

        jMenu1.setText("Inicio");

        MenuMiPerfil.setText("Mi Perfil");
        MenuMiPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuMiPerfilActionPerformed(evt);
            }
        });
        jMenu1.add(MenuMiPerfil);

        MenuSalir.setText("Salir");
        MenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(MenuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Gestionar");

        MenuGestionUsuarios.setText("Usuarios");
        MenuGestionUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuGestionUsuariosActionPerformed(evt);
            }
        });
        jMenu2.add(MenuGestionUsuarios);

        MenuGestionBibliotecas.setText("Bibliotecas");
        MenuGestionBibliotecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuGestionBibliotecasActionPerformed(evt);
            }
        });
        jMenu2.add(MenuGestionBibliotecas);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void rolElegidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rolElegidoActionPerformed

    }//GEN-LAST:event_rolElegidoActionPerformed

    // BOTON PARA BUSCAR USUARIOS

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        modeloTabla.getDataVector().removeAllElements();
        rolBusqueda = (String) rolElegido.getSelectedItem();
        if (campoBusqueda.getText().equals("")) {
            System.out.println("Buscando Usuarios: ROL:" + rolBusqueda + ", PALABRA_CLAVE: " + palabraBusqueda + ", BUSQUEDA: " + campoBusqueda.getText());
            List<Usuario> usuarios = CTRUsuario.buscarUsuariosRol(rolBusqueda);
            for (Usuario u : usuarios) {
                Object[] fila = new Object[5];
                fila[0] = u.getDni();
                fila[1] = u.getNombre();
                fila[2] = u.getApellidos();
                fila[3] = u.getSexo();
                fila[4] = u.getEmail();
                modeloTabla.addRow(fila);
            }
            numResultados.setText("Se han encontrado " + usuarios.size() + " resultados con ROL: " + rolBusqueda);
            System.out.println("---->  EXITO: Se han encontrado " + usuarios.size() + " resultados");
        } else {
            System.out.println("Buscando Usuarios: ROL:" + rolBusqueda + ", PALABRA_CLAVE: " + palabraBusqueda + ", BUSQUEDA: " + campoBusqueda.getText());
            List<Usuario> usuarios = CTRUsuario.buscarUsuarios(rolBusqueda, palabraBusqueda, campoBusqueda.getText());
            for (Usuario u : usuarios) {
                Object[] fila = new Object[5];
                fila[0] = u.getDni();
                fila[1] = u.getNombre();
                fila[2] = u.getApellidos();
                fila[3] = u.getSexo();
                fila[4] = u.getEmail();
                modeloTabla.addRow(fila);
            }
            numResultados.setText("Se han encontrado " + usuarios.size() + " resultados con ROL: " + rolBusqueda + ", PALABRA CLAVE: " + palabraBusqueda + ", BÚSQUEDA: " + campoBusqueda.getText());
            System.out.println("---->  EXITO: Se han encontrado " + usuarios.size() + " resultados con ROL: " + rolBusqueda + ", PALABRA CLAVE: " + palabraBusqueda + ", BÚSQUEDA: " + campoBusqueda.getText());
        }
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed


    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        // TODO add your handling code here:
        int index = tablaUsuarios.getSelectedRow();

        if (rolBusqueda.equals("Todos")) {
            vistaVerUsuario = new ViewVerUsuario();
            vistaVerUsuario.setVisible(true);
            vistaVerUsuario.pack();
            vistaVerUsuario.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            String dni = modeloTabla.getValueAt(index, 0).toString();
            String nombre = modeloTabla.getValueAt(index, 1).toString();
            String apellidos = modeloTabla.getValueAt(index, 2).toString();
            String sexo = modeloTabla.getValueAt(index, 3).toString();
            String email = modeloTabla.getValueAt(index, 4).toString();

            vistaVerUsuario.dni.setText(dni);
            vistaVerUsuario.nombre.setText(nombre);
            vistaVerUsuario.apellidos.setText(apellidos);
            if (sexo.equals("H")) {
                vistaVerUsuario.sexo.setSelectedIndex(0);
            } else {
                vistaVerUsuario.sexo.setSelectedIndex(1);
            }
            vistaVerUsuario.email.setText(email);
            vistaVerUsuario.dni.setEnabled(false);
        } else if (rolBusqueda.equals("Administrador")) {
            vistaVerAdmin = new ViewVerAdmin();
            vistaVerAdmin.setVisible(true);
            vistaVerAdmin.pack();
            vistaVerAdmin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            String dni = modeloTabla.getValueAt(index, 0).toString();
            String nombre = modeloTabla.getValueAt(index, 1).toString();
            String apellidos = modeloTabla.getValueAt(index, 2).toString();
            String sexo = modeloTabla.getValueAt(index, 3).toString();
            String email = modeloTabla.getValueAt(index, 4).toString();

            vistaVerAdmin.dni.setText(dni);
            vistaVerAdmin.nombre.setText(nombre);
            vistaVerAdmin.apellidos.setText(apellidos);
            if (sexo.equals("H")) {
                vistaVerAdmin.sexo.setSelectedIndex(0);
            } else {
                vistaVerAdmin.sexo.setSelectedIndex(1);
            }
            vistaVerAdmin.email.setText(email);
            vistaVerAdmin.dni.setEnabled(false);
        } else if (rolBusqueda.equals("Bibliotecario")) {
            vistaVerBibliotecario = new ViewVerBibliotecario();
            vistaVerBibliotecario.setVisible(true);
            vistaVerBibliotecario.pack();
            vistaVerBibliotecario.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            String dni = modeloTabla.getValueAt(index, 0).toString();
            String nombre = modeloTabla.getValueAt(index, 1).toString();
            String apellidos = modeloTabla.getValueAt(index, 2).toString();
            String sexo = modeloTabla.getValueAt(index, 3).toString();
            String email = modeloTabla.getValueAt(index, 4).toString();

            vistaVerBibliotecario.dni.setText(dni);
            vistaVerBibliotecario.nombre.setText(nombre);
            vistaVerBibliotecario.apellidos.setText(apellidos);
            if (sexo.equals("H")) {
                vistaVerBibliotecario.sexo.setSelectedIndex(0);
            } else {
                vistaVerBibliotecario.sexo.setSelectedIndex(1);
            }
            vistaVerBibliotecario.email.setText(email);
            vistaVerBibliotecario.biblioteca.addItem(Util.buscarBibliotecaByDni(dni));
            vistaVerBibliotecario.dni.setEnabled(false);
        } else {
            vistaVerEstudiante = new ViewVerEstudiante();
            vistaVerEstudiante.setVisible(true);
            vistaVerEstudiante.pack();
            vistaVerEstudiante.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            String dni = modeloTabla.getValueAt(index, 0).toString();
            String nombre = modeloTabla.getValueAt(index, 1).toString();
            String apellidos = modeloTabla.getValueAt(index, 2).toString();
            String sexo = modeloTabla.getValueAt(index, 3).toString();
            String email = modeloTabla.getValueAt(index, 4).toString();

            vistaVerEstudiante.dni.setText(dni);
            vistaVerEstudiante.nombre.setText(nombre);
            vistaVerEstudiante.apellidos.setText(apellidos);
            if (sexo.equals("H")) {
                vistaVerEstudiante.sexo.setSelectedIndex(0);
            } else {
                vistaVerEstudiante.sexo.setSelectedIndex(1);
            }
            vistaVerEstudiante.email.setText(email);
            vistaVerEstudiante.biblioteca.addItem(Util.buscarBibliotecaByDni(dni));
            vistaVerEstudiante.dni.setEnabled(false);
        }
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void btnCrearAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAdminActionPerformed

        vistaCrearAdmin = new ViewCrearAdmin();
        vistaCrearAdmin.setVisible(true);
        vistaCrearAdmin.pack();
        vistaCrearAdmin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnCrearAdminActionPerformed

    private void claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claveActionPerformed
        palabraBusqueda = (String) clave.getSelectedItem();
    }//GEN-LAST:event_claveActionPerformed

    private void btnCrearBibliotecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearBibliotecarioActionPerformed
        vistaCrearBibliotecario = new ViewCrearBibliotecario();
        vistaCrearBibliotecario.setVisible(true);
        vistaCrearBibliotecario.pack();
        vistaCrearBibliotecario.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnCrearBibliotecarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        vistaCrearEstudiante = new ViewCrearEstudiante();
        vistaCrearEstudiante.setVisible(true);
        vistaCrearEstudiante.pack();
        vistaCrearEstudiante.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

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
    }//GEN-LAST:event_MenuMiPerfilActionPerformed

    private void MenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSalirActionPerformed
        vistaLogin = new ViewLogin();
        vistaLogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuGestionBibliotecas;
    private javax.swing.JMenuItem MenuGestionUsuarios;
    private javax.swing.JMenuItem MenuMiPerfil;
    private javax.swing.JMenuItem MenuSalir;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnCrearAdmin;
    private javax.swing.JButton btnCrearBibliotecario;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JComboBox<String> clave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel numResultados;
    private javax.swing.JComboBox<String> rolElegido;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}

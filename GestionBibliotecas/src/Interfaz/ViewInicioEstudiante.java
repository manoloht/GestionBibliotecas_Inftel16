/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.CTRUsuario;
import Controlador.Session;
import Controlador.Util;
import Modelo.Prestamo;
import Modelo.Reservado;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alberto carrion leiva
 */
public class ViewInicioEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form ViewInicioEstudiante
     */
    private ViewBuscarLibros vistaBuscarLibros;
    private ViewLogin vistaLogin;
    private ViewMiPerfil vistaMiPerfil;
    private ViewVerReserva vistaVerReserva;
    private final DefaultTableModel modeloTablaPrestamos;
    private final DefaultTableModel modeloTablaReservas;

    public ViewInicioEstudiante() {
        initComponents();
        modeloTablaPrestamos = (DefaultTableModel) tablaPrestamos.getModel();
        modeloTablaReservas = (DefaultTableModel) tablaReservas.getModel();

        //Obtenemos el Session para obtener id
        int id_usuario = Session.getId_usuario();
        
        //Iniciamos las tablas
        List<Prestamo> prestamos = CTRUsuario.prestamosByEstudiante(id_usuario);
        for (Prestamo m : prestamos) {
            Object[] fila = new Object[4];
            fila[0] = Util.buscarNombreLibro(m.getIsbn());
            fila[1] = m.getIsbn();
            fila[2] = m.getFecha_ini();
            fila[3] = m.getFecha_fin();
            modeloTablaPrestamos.addRow(fila);
        }
        numPrestamos.setText("Tiene " + prestamos.size() + " libros en posesión.");

        List<Reservado> reservas = CTRUsuario.reservadosByEstudiante(id_usuario);
        for (Reservado m : reservas) {
            Object[] fila = new Object[3];
            fila[0] = m.getIsbn();
            fila[1] = m.getFecha_ini();
            fila[2] = m.getFecha_fin();
            modeloTablaReservas.addRow(fila);
        }
        numReservas.setText("Tiene " + prestamos.size() + " libros reservados.");

        this.bienvenida.setText("NOMBRE: "+Session.getNombre()+" , APELLIDOS: "+Session.getApellidos()+", ROL: ESTUDIANTE");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Inicio Estudiante");
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrestamos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        numPrestamos = new javax.swing.JLabel();
        numReservas = new javax.swing.JLabel();
        bienvenida = new javax.swing.JLabel();
        jMenuBar3 = new javax.swing.JMenuBar();
        Inicio = new javax.swing.JMenu();
        MenuInicio = new javax.swing.JMenuItem();
        MenuMiPerfil = new javax.swing.JMenuItem();
        MenuSalir = new javax.swing.JMenuItem();
        Libros = new javax.swing.JMenu();
        MenuBuscarLibro = new javax.swing.JMenuItem();

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
        jLabel6.setText("Mis Prestamos y Reservas");

        numResultados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Mis Prestamos");

        tablaPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo Libro", "ISBN", "Fecha Inicio", "Fecha Fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPrestamos);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Mis Reservas");

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Fecha Inicio", "Fecha Fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaReservasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaReservas);

        numPrestamos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numPrestamos.setText("Mensaje");

        numReservas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numReservas.setText("Mensaje");

        bienvenida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bienvenida.setText("MENSAJE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1651, 1651, 1651))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numPrestamos)
                                    .addComponent(numReservas)
                                    .addComponent(bienvenida))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(699, 699, 699)
                .addComponent(numResultados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bienvenida)
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(numPrestamos)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addComponent(numReservas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208)
                .addComponent(numResultados)
                .addGap(414, 414, 414))
        );

        Inicio.setText("Inicio");

        MenuInicio.setText("Reservas y Prestamos");
        MenuInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuInicioActionPerformed(evt);
            }
        });
        Inicio.add(MenuInicio);

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

        Libros.setText("Libros");

        MenuBuscarLibro.setText("Buscar");
        MenuBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBuscarLibroActionPerformed(evt);
            }
        });
        Libros.add(MenuBuscarLibro);

        jMenuBar3.add(Libros);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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

    private void MenuBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBuscarLibroActionPerformed
        vistaBuscarLibros = new ViewBuscarLibros();
        vistaBuscarLibros.setVisible(true);
        vistaBuscarLibros.pack();
        this.setVisible(false);
    }//GEN-LAST:event_MenuBuscarLibroActionPerformed

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

    private void MenuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuInicioActionPerformed

    }//GEN-LAST:event_MenuInicioActionPerformed

    private void tablaReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaReservasMouseClicked
        int index = tablaReservas.getSelectedRow();
        vistaVerReserva = new ViewVerReserva();
        vistaVerReserva.setVisible(true);
        vistaVerReserva.pack();
        vistaVerReserva.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        String titulo = modeloTablaReservas.getValueAt(index, 0).toString();
        String isbn = modeloTablaReservas.getValueAt(index, 1).toString();
        String fecha_reserva = modeloTablaReservas.getValueAt(index, 2).toString();
        
        vistaVerReserva.titulo.setText(titulo);
        vistaVerReserva.isbn.setText(isbn);
        vistaVerReserva.fechaReserva.setText(fecha_reserva);
    }//GEN-LAST:event_tablaReservasMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Inicio;
    private javax.swing.JMenu Libros;
    private javax.swing.JMenuItem MenuBuscarLibro;
    private javax.swing.JMenuItem MenuInicio;
    private javax.swing.JMenuItem MenuMiPerfil;
    private javax.swing.JMenuItem MenuSalir;
    private javax.swing.JLabel bienvenida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel numPrestamos;
    private javax.swing.JLabel numReservas;
    private javax.swing.JLabel numResultados;
    private javax.swing.JTable tablaPrestamos;
    private javax.swing.JTable tablaReservas;
    // End of variables declaration//GEN-END:variables
}

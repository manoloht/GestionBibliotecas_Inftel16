/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.CTRBiblioteca;
import Controlador.CTRUsuario;
import Modelo.Biblioteca;
import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;

/**
 *
 * @author alberto carrion leiva
 */
public class ViewCrearEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form ViewCrearEstudiante
     */
    public ViewCrearEstudiante() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Crear Estudiante");
        this.mensaje.setText("");
 
        // CARGAMOS LA LISTA DE BIBLIOTECAS EN EL JCOMBOBOX
        List<Biblioteca> bib = CTRBiblioteca.getTodasBibliotecas();
        for(Biblioteca b: bib){
            this.biblioteca.addItem(b.getNombre());
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

        jPanel1 = new javax.swing.JPanel();
        dniEditado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        dni = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        apellidos = new javax.swing.JTextField();
        sexo = new javax.swing.JComboBox<>();
        btnCrear = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        biblioteca = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        numExp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setForeground(java.awt.Color.red);

        dniEditado.setBackground(new java.awt.Color(211, 211, 211));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("DNI");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("NOMBRE");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("APELLIDOS");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("SEXO");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("EMAIL");

        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V", "H" }));

        btnCrear.setBackground(new java.awt.Color(250, 40, 40));
        btnCrear.setForeground(java.awt.Color.white);
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("BIBLIOTECA");

        biblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bibliotecaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("NUM. EXPEDIENTE");

        javax.swing.GroupLayout dniEditadoLayout = new javax.swing.GroupLayout(dniEditado);
        dniEditado.setLayout(dniEditadoLayout);
        dniEditadoLayout.setHorizontalGroup(
            dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dniEditadoLayout.createSequentialGroup()
                .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dniEditadoLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(dniEditadoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(102, 102, 102)
                                .addComponent(dni))
                            .addGroup(dniEditadoLayout.createSequentialGroup()
                                .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(10, 10, 10)
                                .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(email)
                                    .addGroup(dniEditadoLayout.createSequentialGroup()
                                        .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(459, 459, 459))
                                    .addComponent(numExp)))
                            .addGroup(dniEditadoLayout.createSequentialGroup()
                                .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(55, 55, 55)
                                .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombre)
                                    .addComponent(apellidos)))))
                    .addGroup(dniEditadoLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(btnCrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        dniEditadoLayout.setVerticalGroup(
            dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dniEditadoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(numExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(dniEditadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnCancelar))
                .addGap(29, 29, 29))
        );

        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(250, 40, 40));
        jLabel7.setText("Crear Estudiante");

        mensaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mensaje.setForeground(java.awt.Color.red);
        mensaje.setText("Mensaje");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mensaje)
                    .addComponent(dniEditado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dniEditado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mensaje)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //BOTON PARA CREAR EL ESTUDIANTE
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        System.out.println("---->  Comprobando Estudiante: " + dni.getText() + " " + nombre.getText() + " " + apellidos.getText() + " " + sexo.getSelectedItem() + " " + email.getText() + " " + biblioteca.getSelectedItem().toString()+" "+numExp.getText());

        // COMPROBAMOS QUE LOS CAMPOS NO SON VACIOS
        if (dni.getText().equals("") || nombre.getText().equals("") || apellidos.getText().equals("") || email.getText().equals("") || numExp.getText().equals("")) {
            System.err.println("---->  ERROR: Campos Vacios");
            mensaje.setText("ERROR: Faltan campos por rellenar");
            if (dni.getText().equals("")) {
                dni.setBorder(BorderFactory.createLineBorder(Color.red));
            } else if (nombre.getText().equals("")) {
                nombre.setBorder(BorderFactory.createLineBorder(Color.red));
            } else if (apellidos.getText().equals("")) {
                apellidos.setBorder(BorderFactory.createLineBorder(Color.red));
            } else if(email.getText().equals("")){
                email.setBorder(BorderFactory.createLineBorder(Color.red));
            } else {
                numExp.setBorder(BorderFactory.createLineBorder(Color.red));
            }
        } else {
            if (CTRUsuario.comprobarEstudiante(dni.getText())) {
                System.err.println("---->  ERROR: El estudiante existe");
                mensaje.setText("ERROR: El estudiante existe");
            } else {
                System.out.println("---->  Insertando Estudiante: " + dni.getText() + " " + nombre.getText() + " " + apellidos.getText() + " " + sexo.getSelectedItem().toString() + " " + email.getText() + " " + biblioteca.getSelectedItem().toString()+" "+numExp.getText());
                if (CTRUsuario.insertarEstudiante(dni.getText(), nombre.getText(), apellidos.getText(), sexo.getSelectedItem().toString(), email.getText(), biblioteca.getSelectedItem().toString(), numExp.getText())){
                    System.out.println("---->  Estudiante insertado con éxito");
                    mensaje.setText("ÉXITO: El estudiante se ha creado correctamente");
                }else{
                    System.out.println("---->  Error al insertar el estudiante");
                    mensaje.setText("ERROR: No se pudo crear el estudiante");
                }
            }
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void bibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bibliotecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bibliotecaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField apellidos;
    private javax.swing.JComboBox<String> biblioteca;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    public javax.swing.JTextField dni;
    private javax.swing.JPanel dniEditado;
    public javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mensaje;
    public javax.swing.JTextField nombre;
    private javax.swing.JTextField numExp;
    public javax.swing.JComboBox<String> sexo;
    // End of variables declaration//GEN-END:variables
}
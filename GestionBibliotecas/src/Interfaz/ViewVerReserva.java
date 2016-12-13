/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

/**
 *
 * @author albertocheca
 */
public class ViewVerReserva extends javax.swing.JFrame {

    /**
     * Creates new form ViewVerReserva
     */
    private ViewAlertaBorrarReserva vistaAlertaBorrarReserva;
    
    public ViewVerReserva() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Ver Reserva");
        this.titulo.setEnabled(false);
        this.isbn.setEnabled(false);
        this.fechaReserva.setEnabled(false);
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
        dniEditado8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        btnCancelarReserva = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        isbn = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        fechaReserva = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);

        dniEditado8.setBackground(new java.awt.Color(211, 211, 211));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("TITULO");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("ISBN");

        btnCancelarReserva.setBackground(new java.awt.Color(250, 40, 40));
        btnCancelarReserva.setForeground(java.awt.Color.white);
        btnCancelarReserva.setText("Cancelar Reserva");
        btnCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservaActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        isbn.setToolTipText("");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("FECHA RESERVA");

        javax.swing.GroupLayout dniEditado8Layout = new javax.swing.GroupLayout(dniEditado8);
        dniEditado8.setLayout(dniEditado8Layout);
        dniEditado8Layout.setHorizontalGroup(
            dniEditado8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dniEditado8Layout.createSequentialGroup()
                .addGroup(dniEditado8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dniEditado8Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(dniEditado8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addGroup(dniEditado8Layout.createSequentialGroup()
                                .addGroup(dniEditado8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28))
                                .addGap(82, 82, 82)
                                .addGroup(dniEditado8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(titulo)
                                    .addComponent(isbn)
                                    .addComponent(fechaReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)))))
                    .addGroup(dniEditado8Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(btnCancelarReserva)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        dniEditado8Layout.setVerticalGroup(
            dniEditado8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dniEditado8Layout.createSequentialGroup()
                .addGroup(dniEditado8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dniEditado8Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel28))
                    .addGroup(dniEditado8Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(dniEditado8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dniEditado8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(isbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(dniEditado8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(fechaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dniEditado8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarReserva)
                    .addComponent(btnSalir))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(250, 40, 40));
        jLabel7.setText("Ver Reserva");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(dniEditado8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dniEditado8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservaActionPerformed
        vistaAlertaBorrarReserva = new ViewAlertaBorrarReserva();
        vistaAlertaBorrarReserva.setVisible(true);
        vistaAlertaBorrarReserva.pack();
        vistaAlertaBorrarReserva.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
    }//GEN-LAST:event_btnCancelarReservaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarReserva;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel dniEditado8;
    public javax.swing.JTextField fechaReserva;
    public javax.swing.JTextField isbn;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
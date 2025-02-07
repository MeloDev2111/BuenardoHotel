/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Vistas;

import Apoyo.Mensajes;
import Apoyo.Validacion;
import Presentacion.Presentadores.PAgregarModificarClientes;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Harby
 */
public class VAgregarModificarCliente extends javax.swing.JPanel {
    private JFrame frame = new JFrame("Registro Clientes");
    private JDialog dialog;
    private PAgregarModificarClientes presentador;
    private Mensajes msg = new Mensajes();
    private Validacion validar = new Validacion();
    
    /**
     * Creates new form Cliente
     */
    public VAgregarModificarCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panelagregar = new javax.swing.JPanel();
        btnagregar = new javax.swing.JButton();
        PanelTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cboxTipos = new javax.swing.JComboBox<>();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtdoc = new javax.swing.JTextField();
        txtnrodoc = new javax.swing.JTextField();
        panelAgregarRegistroEntrada = new javax.swing.JPanel();
        btnGuardarRE = new javax.swing.JButton();
        btnVolverRE = new javax.swing.JButton();
        panelAdminModificar = new javax.swing.JPanel();
        btnModificarAdmin = new javax.swing.JButton();
        btncancelarModif = new javax.swing.JButton();
        panelAdminAgregar = new javax.swing.JPanel();
        btnGuardarAdmin = new javax.swing.JButton();
        btncancelarGuardar = new javax.swing.JButton();
        panelAgregarRegistroReserva = new javax.swing.JPanel();
        btnGuardarRR = new javax.swing.JButton();
        btnvolverRR = new javax.swing.JButton();

        Panelagregar.setBackground(new java.awt.Color(204, 255, 102));

        btnagregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/check.png"))); // NOI18N
        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelagregarLayout = new javax.swing.GroupLayout(Panelagregar);
        Panelagregar.setLayout(PanelagregarLayout);
        PanelagregarLayout.setHorizontalGroup(
            PanelagregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelagregarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnagregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelagregarLayout.setVerticalGroup(
            PanelagregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBackground(new java.awt.Color(204, 255, 102));

        PanelTitle.setBackground(new java.awt.Color(51, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro Cliente");

        javax.swing.GroupLayout PanelTitleLayout = new javax.swing.GroupLayout(PanelTitle);
        PanelTitle.setLayout(PanelTitleLayout);
        PanelTitleLayout.setHorizontalGroup(
            PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        PanelTitleLayout.setVerticalGroup(
            PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 102));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tipo:");

        cboxTipos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxTipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboxTipos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxTiposItemStateChanged(evt);
            }
        });

        lblApellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblApellidos.setText("Apellidos:");

        txtApellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Nombres:");

        txtNombres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tipo de Documento:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Nro. de Documento:");

        txtdoc.setEditable(false);
        txtdoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtnrodoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnrodoc))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdoc))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNombre))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboxTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtdoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtnrodoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelAgregarRegistroEntrada.setBackground(new java.awt.Color(204, 255, 102));

        btnGuardarRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/añadir.png"))); // NOI18N
        btnGuardarRE.setText("Guardar");

        btnVolverRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/undo.png"))); // NOI18N
        btnVolverRE.setText("Volver");
        btnVolverRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverREActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAgregarRegistroEntradaLayout = new javax.swing.GroupLayout(panelAgregarRegistroEntrada);
        panelAgregarRegistroEntrada.setLayout(panelAgregarRegistroEntradaLayout);
        panelAgregarRegistroEntradaLayout.setHorizontalGroup(
            panelAgregarRegistroEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarRegistroEntradaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnGuardarRE, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolverRE)
                .addGap(36, 36, 36))
        );

        panelAgregarRegistroEntradaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnGuardarRE, btnVolverRE});

        panelAgregarRegistroEntradaLayout.setVerticalGroup(
            panelAgregarRegistroEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAgregarRegistroEntradaLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(panelAgregarRegistroEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolverRE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarRE, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        panelAgregarRegistroEntradaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGuardarRE, btnVolverRE});

        panelAdminModificar.setBackground(new java.awt.Color(204, 255, 102));

        btnModificarAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/generar.png"))); // NOI18N
        btnModificarAdmin.setText("Modificar");
        btnModificarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAdminActionPerformed(evt);
            }
        });

        btncancelarModif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btncancelarModif.setText("Cancelar");
        btncancelarModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarModifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAdminModificarLayout = new javax.swing.GroupLayout(panelAdminModificar);
        panelAdminModificar.setLayout(panelAdminModificarLayout);
        panelAdminModificarLayout.setHorizontalGroup(
            panelAdminModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminModificarLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnModificarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncancelarModif)
                .addGap(36, 36, 36))
        );
        panelAdminModificarLayout.setVerticalGroup(
            panelAdminModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminModificarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAdminModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancelarModif, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        panelAdminAgregar.setBackground(new java.awt.Color(204, 255, 102));

        btnGuardarAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/añadir.png"))); // NOI18N
        btnGuardarAdmin.setText("Guardar");
        btnGuardarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAdminActionPerformed(evt);
            }
        });

        btncancelarGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btncancelarGuardar.setText("Cancelar");
        btncancelarGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAdminAgregarLayout = new javax.swing.GroupLayout(panelAdminAgregar);
        panelAdminAgregar.setLayout(panelAdminAgregarLayout);
        panelAdminAgregarLayout.setHorizontalGroup(
            panelAdminAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminAgregarLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnGuardarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(btncancelarGuardar)
                .addGap(36, 36, 36))
        );
        panelAdminAgregarLayout.setVerticalGroup(
            panelAdminAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminAgregarLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(panelAdminAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancelarGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        panelAgregarRegistroReserva.setBackground(new java.awt.Color(204, 255, 102));

        btnGuardarRR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/añadir.png"))); // NOI18N
        btnGuardarRR.setText("Guardar");

        btnvolverRR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/undo.png"))); // NOI18N
        btnvolverRR.setText("Volver");
        btnvolverRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverRRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAgregarRegistroReservaLayout = new javax.swing.GroupLayout(panelAgregarRegistroReserva);
        panelAgregarRegistroReserva.setLayout(panelAgregarRegistroReservaLayout);
        panelAgregarRegistroReservaLayout.setHorizontalGroup(
            panelAgregarRegistroReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarRegistroReservaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnGuardarRR, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnvolverRR, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        panelAgregarRegistroReservaLayout.setVerticalGroup(
            panelAgregarRegistroReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAgregarRegistroReservaLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(panelAgregarRegistroReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnvolverRR, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarRR, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
            .addComponent(panelAdminModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelAgregarRegistroEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelAgregarRegistroReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAdminAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAdminAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAdminModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAgregarRegistroEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAgregarRegistroReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnVolverREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverREActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverREActionPerformed

    private void btncancelarModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarModifActionPerformed
        this.cerrar();
    }//GEN-LAST:event_btncancelarModifActionPerformed

    private void btncancelarGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarGuardarActionPerformed
        this.cerrar();
    }//GEN-LAST:event_btncancelarGuardarActionPerformed

    private void btnvolverRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverRRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnvolverRRActionPerformed

    private void cboxTiposItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxTiposItemStateChanged
        presentador.establecerDatosTipoDocumento();
    }//GEN-LAST:event_cboxTiposItemStateChanged

    private void btnGuardarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAdminActionPerformed
        if (isValidatedForm()) {
            presentador.guardarCliente();
        }
    }//GEN-LAST:event_btnGuardarAdminActionPerformed

    private void btnModificarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAdminActionPerformed
        if (isValidatedForm()) {
            presentador.modificarCliente();
        }
    }//GEN-LAST:event_btnModificarAdminActionPerformed

    
    public void setPresentador(PAgregarModificarClientes p) {
        presentador = p;
    }

    public void iniciar(){       
//Llamo antes a las accioens del presentador pq el dialog pausa todo
        dialog = new JDialog(frame,true);
        dialog.setContentPane(this);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.pack();
        dialog.setSize(400, 500);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);//poner despues del null para centrar
    }
    
    public void cerrar(){
        frame.dispose();
        dialog.dispose();
    }
    
    public void deshabilitarBotones(){
        this.panelAdminAgregar.setVisible(false);
        this.panelAdminModificar.setVisible(false);
        this.panelAgregarRegistroEntrada.setVisible(false);
        this.panelAgregarRegistroReserva.setVisible(false);
    }
        
    public void habilitarBtnsAdminAgregar(){
        this.panelAdminAgregar.setVisible(true);
    }
    public void habilitarBtnsAdminModificar(){
        this.panelAdminModificar.setVisible(true);
    }
    
    public void habilitarBtnsRecepRegistroEntrada(){
        this.panelAgregarRegistroEntrada.setVisible(true);
    }
    
    public void habilitarBtnsRecepRegistroReserva(){
        this.panelAgregarRegistroReserva.setVisible(true);
    }
    
    public void POVClienteJuridico(){
        this.lblNombre.setVisible(false);
        this.txtNombres.setVisible(false);
        this.lblApellidos.setText("Empresa:");
    }
    
    public void POVClienteNatural(){
        this.lblNombre.setVisible(true);
        this.txtNombres.setVisible(true);
        this.lblApellidos.setText("Apellidos");
    }

    public String getTipoCliSeleccionado(){
        String tipo = this.cboxTipos.getSelectedItem().toString();
        return tipo;
    }
    
    public void setTipoCliente(String tipo){
        for (int i = 0; i < cboxTipos.getItemCount(); i++) {
            if (cboxTipos.getItemAt(i).equals(tipo)) {
                cboxTipos.setSelectedIndex(i);
            }
        }        
    }
    
    public String getApellidos(){
        return this.txtApellidos.getText();
    }
    
    public void setApellidos(String apellidos){
        this.txtApellidos.setText(apellidos);
    }
    
    public String getNombres(){
        return this.txtNombres.getText();
    }
    
    public void setNombres(String nombres){
        this.txtNombres.setText(nombres);
    }
    
    public String getTipoDocumento(){
        return this.txtdoc.getText();
    }
    
    public void setTipoDocumento(String tipoDoc){
        this.txtdoc.setText(tipoDoc);
    }
    
    public String getNumDocumento(){
        return this.txtnrodoc.getText();
    }
    
    public void setNumDocumento(String numDoc){
        this.txtnrodoc.setText(numDoc);
    }

    public void mostrarListaTiposCliente(String[] tipos){
        this.cboxTipos.setModel( new DefaultComboBoxModel<>( tipos ) );
    }

    
    private boolean isValidatedForm(){
        if ( txtApellidos == null ) {
            txtApellidos.requestFocus();
            msg.errorMsg("Campo Obligatorio: Apellido o nombre de la Empresa");
            return false;
        }
        
        switch (this.getTipoDocumento()) {
            case "DNI":
                if ( !validar.isDNI(this.getNumDocumento()) ) {
                    txtnrodoc.requestFocus();
                    return false;
                }
                if (!validar.isNombre(this.getNombres())) {
                    txtNombres.requestFocus();
                    return false;
                }
                if (!validar.isNombre(this.getApellidos())) {
                    txtApellidos.requestFocus();
                    return false;
                }
                break;
            case "RUC":
                if ( !validar.isRUC(this.getNumDocumento()) ) {
                    txtnrodoc.requestFocus();
                    return false;
                }
                if (!validar.isNombre(this.getApellidos())) {
                    txtApellidos.requestFocus();
                    return false;
                }
                break;
            default:
                throw new AssertionError();
        }
        
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTitle;
    private javax.swing.JPanel Panelagregar;
    private javax.swing.JButton btnGuardarAdmin;
    private javax.swing.JButton btnGuardarRE;
    private javax.swing.JButton btnGuardarRR;
    private javax.swing.JButton btnModificarAdmin;
    private javax.swing.JButton btnVolverRE;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btncancelarGuardar;
    private javax.swing.JButton btncancelarModif;
    private javax.swing.JButton btnvolverRR;
    private javax.swing.JComboBox<String> cboxTipos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel panelAdminAgregar;
    private javax.swing.JPanel panelAdminModificar;
    private javax.swing.JPanel panelAgregarRegistroEntrada;
    private javax.swing.JPanel panelAgregarRegistroReserva;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtdoc;
    private javax.swing.JTextField txtnrodoc;
    // End of variables declaration//GEN-END:variables
}

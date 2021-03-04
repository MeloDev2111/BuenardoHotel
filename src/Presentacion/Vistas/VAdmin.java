/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Vistas;


import Presentacion.Presentadores.PresentadorAdmin;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author eddyf
 */
public class VAdmin extends javax.swing.JPanel{
    private JFrame frame = new JFrame("VAdmin");
    private PresentadorAdmin presentador;
    /**
     * Creates new form VAdmin
     */
    public VAdmin() {
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

        PanelInicio = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelTitulo = new javax.swing.JPanel();
        lblBienvenida = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        panelNav = new javax.swing.JPanel();
        btnVClientes = new javax.swing.JLabel();
        btnInicio = new javax.swing.JLabel();
        btnVUsuarios = new javax.swing.JLabel();
        btnVReservaciones = new javax.swing.JLabel();
        btnVHabitaciones = new javax.swing.JLabel();
        btnVComprobantes = new javax.swing.JLabel();
        btnVServicios = new javax.swing.JLabel();
        panelBase = new javax.swing.JPanel();

        PanelInicio.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo2_Hotel.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(49, 175, 180));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MODULO DE ADMINISTRACIÓN");

        javax.swing.GroupLayout PanelInicioLayout = new javax.swing.GroupLayout(PanelInicio);
        PanelInicio.setLayout(PanelInicioLayout);
        PanelInicioLayout.setHorizontalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
        );
        PanelInicioLayout.setVerticalGroup(
            PanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInicioLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel3)
                .addGap(55, 55, 55)
                .addComponent(jLabel4)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        panelTitulo.setBackground(new java.awt.Color(51, 255, 204));

        lblBienvenida.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(48, 152, 204));
        lblBienvenida.setText(" Bienvenido DIAZ DIAZ MELIO JOSUE");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/header2_Hotel.png"))); // NOI18N

        btnCerrarSesion.setBackground(new java.awt.Color(255, 102, 102));
        btnCerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion)
                .addGap(23, 23, 23))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBienvenida)
                    .addComponent(btnCerrarSesion))
                .addContainerGap(48, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        panelNav.setBackground(new java.awt.Color(102, 204, 255));

        btnVClientes.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 1, 24)); // NOI18N
        btnVClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnVClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/habitaciones.png"))); // NOI18N
        btnVClientes.setText(" Clientes");
        btnVClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVClientesMouseClicked(evt);
            }
        });

        btnInicio.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 1, 24)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_icon.png"))); // NOI18N
        btnInicio.setText(" Inicio");
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInicioMouseClicked(evt);
            }
        });

        btnVUsuarios.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 1, 24)); // NOI18N
        btnVUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnVUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clientes.png"))); // NOI18N
        btnVUsuarios.setText(" Usuarios");
        btnVUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVUsuariosMouseClicked(evt);
            }
        });

        btnVReservaciones.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 1, 24)); // NOI18N
        btnVReservaciones.setForeground(new java.awt.Color(255, 255, 255));
        btnVReservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/habitaciones.png"))); // NOI18N
        btnVReservaciones.setText(" Hospedajes");
        btnVReservaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVReservaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVReservacionesMouseClicked(evt);
            }
        });

        btnVHabitaciones.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 1, 24)); // NOI18N
        btnVHabitaciones.setForeground(new java.awt.Color(255, 255, 255));
        btnVHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clientes.png"))); // NOI18N
        btnVHabitaciones.setText(" Habitaciones");
        btnVHabitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVHabitacionesMouseClicked(evt);
            }
        });

        btnVComprobantes.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 1, 24)); // NOI18N
        btnVComprobantes.setForeground(new java.awt.Color(255, 255, 255));
        btnVComprobantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/habitaciones.png"))); // NOI18N
        btnVComprobantes.setText(" Comprobantes");
        btnVComprobantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVComprobantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVComprobantesMouseClicked(evt);
            }
        });

        btnVServicios.setFont(new java.awt.Font("UD Digi Kyokasho NP-B", 1, 24)); // NOI18N
        btnVServicios.setForeground(new java.awt.Color(255, 255, 255));
        btnVServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clientes.png"))); // NOI18N
        btnVServicios.setText("Servicios");
        btnVServicios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVServiciosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelNavLayout = new javax.swing.GroupLayout(panelNav);
        panelNav.setLayout(panelNavLayout);
        panelNavLayout.setHorizontalGroup(
            panelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNavLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(btnVUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(btnVReservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVHabitaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(btnVComprobantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVServicios, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelNavLayout.setVerticalGroup(
            panelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNavLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVReservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVComprobantes, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBase.setBackground(new java.awt.Color(255, 255, 255));
        panelBase.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panelBase, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVClientesMouseClicked
        presentador.mostrarVClientes();
    }//GEN-LAST:event_btnVClientesMouseClicked

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        presentador.backToLogin();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseClicked
        presentador.mostrarInicio();
    }//GEN-LAST:event_btnInicioMouseClicked

    private void btnVUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVUsuariosMouseClicked
        presentador.mostrarVUsuarios();
    }//GEN-LAST:event_btnVUsuariosMouseClicked

    private void btnVReservacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVReservacionesMouseClicked
        presentador.mostrarVHospedajes();
    }//GEN-LAST:event_btnVReservacionesMouseClicked

    private void btnVHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVHabitacionesMouseClicked
        presentador.mostrarVHabitacciones();
    }//GEN-LAST:event_btnVHabitacionesMouseClicked

    private void btnVComprobantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVComprobantesMouseClicked
        presentador.mostrarVComprobantes();
    }//GEN-LAST:event_btnVComprobantesMouseClicked

    private void btnVServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVServiciosMouseClicked
        presentador.mostrarVServicios();
    }//GEN-LAST:event_btnVServiciosMouseClicked
    
    public void setPresentador(PresentadorAdmin p) {
        presentador = p;
    }

    public void iniciar(){
        frame.setContentPane(this);
        frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 730);
        frame.setLocationRelativeTo(null);
        mostrarInicio();
    }
  
    public void cerrar(){
        frame.dispose();
    }
    
    public void setNombre(String nombre){
        this.lblBienvenida.setText("Bienvenido "+nombre);
    }
    
    public void mostrarInicio() {
        cambiarVistaActual(PanelInicio);
    }
    public void cambiarVistaActual(JPanel nuevoPanel) {
        nuevoPanel.setSize(750,600);
        nuevoPanel.setVisible(true);
        this.panelBase.removeAll();
        this.panelBase.add(nuevoPanel);
        this.panelBase.revalidate();
        this.panelBase.repaint();
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelInicio;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JLabel btnInicio;
    private javax.swing.JLabel btnVClientes;
    private javax.swing.JLabel btnVComprobantes;
    private javax.swing.JLabel btnVHabitaciones;
    private javax.swing.JLabel btnVReservaciones;
    private javax.swing.JLabel btnVServicios;
    private javax.swing.JLabel btnVUsuarios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelNav;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables


}

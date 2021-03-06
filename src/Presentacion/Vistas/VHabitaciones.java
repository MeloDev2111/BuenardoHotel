/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Vistas;

import Apoyo.Formateo;
import Apoyo.Mensajes;
import Apoyo.Validacion;
import Presentacion.Presentadores.PresentadorHabitacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author eddyf
 */
public class VHabitaciones extends javax.swing.JPanel {
    private JFrame frame = new JFrame("VAdmin");
    private PresentadorHabitacion presentador;
    private Mensajes msg = new Mensajes();
    private Formateo format = new Formateo();
    private Validacion validar = new Validacion();
    /**
     * Creates new form VHabitaciones
     */
    public VHabitaciones() {
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

        btnGroupFiltros = new javax.swing.ButtonGroup();
        panelTable = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableHabitaciones = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNombreTipo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        rdBtnTodos = new javax.swing.JRadioButton();
        rdBtnDisponibles = new javax.swing.JRadioButton();
        rdBtnOcupados = new javax.swing.JRadioButton();
        panelAdmin = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        panelTitulo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        panelRegistroEntrada = new javax.swing.JPanel();
        btnElegirRE = new javax.swing.JButton();
        btnVolverRE = new javax.swing.JButton();
        panelConsultas = new javax.swing.JPanel();
        btnVolverVRecep = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        dateReserva = new com.toedter.calendar.JDateChooser();
        cboxHora = new javax.swing.JComboBox<>();
        cboxMinuto = new javax.swing.JComboBox<>();
        panelRegistroReserva = new javax.swing.JPanel();
        btnElegirRR = new javax.swing.JButton();
        btnVolverRR = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 204, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelTable.setBackground(new java.awt.Color(255, 255, 255));

        tableHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Tipo", "Descripcion", "Precio", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableHabitaciones.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableHabitaciones);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tipo");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnGroupFiltros.add(rdBtnTodos);
        rdBtnTodos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdBtnTodos.setText("Todos");

        btnGroupFiltros.add(rdBtnDisponibles);
        rdBtnDisponibles.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdBtnDisponibles.setSelected(true);
        rdBtnDisponibles.setText("Disponibles");

        btnGroupFiltros.add(rdBtnOcupados);
        rdBtnOcupados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdBtnOcupados.setText("Ocupados");

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(panelTableLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(rdBtnTodos)
                        .addGap(18, 18, 18)
                        .addComponent(rdBtnDisponibles)
                        .addGap(18, 18, 18)
                        .addComponent(rdBtnOcupados)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTableLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(rdBtnTodos)
                    .addComponent(rdBtnDisponibles)
                    .addComponent(rdBtnOcupados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        panelAdmin.setBackground(new java.awt.Color(255, 255, 255));

        jButton19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/añadir.png"))); // NOI18N
        jButton19.setText("Agregar");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modify.png"))); // NOI18N
        jButton20.setText("Modificar");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        jButton21.setText("Eliminar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        panelAdminLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton19, jButton20, jButton21});

        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panelAdminLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton19, jButton20, jButton21});

        panelTitulo.setBackground(new java.awt.Color(0, 102, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lista de Habitaciones");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        panelRegistroEntrada.setBackground(new java.awt.Color(255, 255, 255));

        btnElegirRE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnElegirRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/microscope.png"))); // NOI18N
        btnElegirRE.setText("Elegir");
        btnElegirRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirREActionPerformed(evt);
            }
        });

        btnVolverRE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVolverRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/undo.png"))); // NOI18N
        btnVolverRE.setText("Volver");
        btnVolverRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverREActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRegistroEntradaLayout = new javax.swing.GroupLayout(panelRegistroEntrada);
        panelRegistroEntrada.setLayout(panelRegistroEntradaLayout);
        panelRegistroEntradaLayout.setHorizontalGroup(
            panelRegistroEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelRegistroEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRegistroEntradaLayout.createSequentialGroup()
                    .addGap(128, 128, 128)
                    .addComponent(btnElegirRE, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(231, 231, 231)
                    .addComponent(btnVolverRE, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(128, Short.MAX_VALUE)))
        );
        panelRegistroEntradaLayout.setVerticalGroup(
            panelRegistroEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
            .addGroup(panelRegistroEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRegistroEntradaLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(panelRegistroEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnElegirRE, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVolverRE, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(23, Short.MAX_VALUE)))
        );

        panelConsultas.setBackground(new java.awt.Color(255, 255, 255));

        btnVolverVRecep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVolverVRecep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/undo.png"))); // NOI18N
        btnVolverVRecep.setText("Volver");
        btnVolverVRecep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverVRecepActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reservas-consumos.png"))); // NOI18N
        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cboxHora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboxHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        cboxMinuto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboxMinuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        javax.swing.GroupLayout panelConsultasLayout = new javax.swing.GroupLayout(panelConsultas);
        panelConsultas.setLayout(panelConsultasLayout);
        panelConsultasLayout.setHorizontalGroup(
            panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboxMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolverVRecep, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelConsultasLayout.setVerticalGroup(
            panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultasLayout.createSequentialGroup()
                .addGroup(panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultasLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVolverVRecep, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelConsultasLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(dateReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelConsultasLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnVolverVRecep, jButton1});

        panelRegistroReserva.setBackground(new java.awt.Color(255, 255, 255));

        btnElegirRR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnElegirRR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/microscope.png"))); // NOI18N
        btnElegirRR.setText("Elegir");
        btnElegirRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirRRActionPerformed(evt);
            }
        });

        btnVolverRR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVolverRR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/undo.png"))); // NOI18N
        btnVolverRR.setText("Volver");
        btnVolverRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverRRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRegistroReservaLayout = new javax.swing.GroupLayout(panelRegistroReserva);
        panelRegistroReserva.setLayout(panelRegistroReservaLayout);
        panelRegistroReservaLayout.setHorizontalGroup(
            panelRegistroReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelRegistroReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRegistroReservaLayout.createSequentialGroup()
                    .addGap(128, 128, 128)
                    .addComponent(btnElegirRR, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(231, 231, 231)
                    .addComponent(btnVolverRR, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(128, Short.MAX_VALUE)))
        );
        panelRegistroReservaLayout.setVerticalGroup(
            panelRegistroReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(panelRegistroReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRegistroReservaLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(panelRegistroReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnElegirRR, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVolverRR, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(23, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRegistroEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRegistroReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRegistroEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRegistroReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        presentador.mostrarVAgregarHabitaciones();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        if (isSelected()) {
            presentador.mostrarVModificarHabitacion();
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if (tableHabitaciones.getSelectedRow()!=-1) {            
            presentador.eliminarHabitacion();
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        presentador.establecerTablaHabitaciones();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnElegirREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirREActionPerformed
        if (isSelected()) {
            if (isDisponible()) {
                presentador.elegirHabitacionRE();
            }else{
                msg.advertenciaMsg("REGISTRO NO PERMITIDO","HABITACION NO DISPONIBLE");
            }
        }
    }//GEN-LAST:event_btnElegirREActionPerformed

    private void btnVolverREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverREActionPerformed
        presentador.VolverVRegistroEntrada();
    }//GEN-LAST:event_btnVolverREActionPerformed

    private void btnVolverVRecepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverVRecepActionPerformed
        this.cerrar();
    }//GEN-LAST:event_btnVolverVRecepActionPerformed

    private void btnElegirRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirRRActionPerformed
        if (isSelected()) {
            if (isDisponible()) {
                presentador.elegirHabitacionRR();
            }else{
                msg.advertenciaMsg("REGISTRO NO PERMITIDO","HABITACION NO DISPONIBLE");
            }
        }
    }//GEN-LAST:event_btnElegirRRActionPerformed

    private void btnVolverRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverRRActionPerformed
        presentador.VolverVRegistroReserva();
    }//GEN-LAST:event_btnVolverRRActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (isFormValidado()) {
            presentador.establecerTablaConsultada();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void setListeners() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presentador.establecerTablaHabitaciones();
            }
        };
        
        rdBtnDisponibles.addActionListener(listener);
        rdBtnOcupados.addActionListener(listener);
        rdBtnTodos.addActionListener(listener);
    } 
    
    
    
    public void setPresentador(PresentadorHabitacion p) {
        presentador = p;
    }

    public void iniciar(){
        frame.setContentPane(this);
        frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(760, 580);
        frame.setLocationRelativeTo(null);
        this.setListeners();
    }
    
    public void cerrar(){
        frame.dispose();
    }
    
    public void deshabilitarBotones(){
        this.panelAdmin.setVisible(false);
        this.panelConsultas.setVisible(false);
        this.panelRegistroEntrada.setVisible(false);
        this.panelRegistroReserva.setVisible(false);
    }
    
    public void deshabilitarFiltros(){
        this.rdBtnDisponibles.setVisible(false);
        this.rdBtnOcupados.setVisible(false);
        this.rdBtnTodos.setVisible(false);
    }
    
    public void habilitarBtnsAdmin(){
        this.panelAdmin.setVisible(true);
        this.rdBtnTodos.setSelected(true);
    }
    
    public void habilitarBtnsRecepRegistroEntrada(){
        this.panelRegistroEntrada.setVisible(true);
        this.rdBtnDisponibles.setSelected(true);
        deshabilitarFiltros();
    }
    
    public void habilitarBtnsRecepRegistroReserva(){
        this.panelRegistroReserva.setVisible(true);
        this.rdBtnDisponibles.setSelected(true);
        deshabilitarFiltros();
    }
    
    
    public void habilitarBtnsRecepConsultas(){
        this.panelConsultas.setVisible(true);
        this.rdBtnTodos.setSelected(true);
        deshabilitarFiltros();
        
    }
    
    public void setTablaHabitaciones(Object[][] listaHabitaciones){
        String[] cabezera = {"idHabita", "Tipo","Descripcion","Precio","Estado"};
        this.tableHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            listaHabitaciones,
            cabezera
        ));
    }
    
    public String getNombreTipo(){
        return txtNombreTipo.getText();
    }
    
    public String getIdSeleccionado(){
        int pos = tableHabitaciones.getSelectedRow();
        return tableHabitaciones.getValueAt(pos, 0).toString();
    }
    
    public String getFiltroSeleccionado(){

        if (rdBtnDisponibles.isSelected()) {
            return "DISPONIBLE";
        }
        if (rdBtnOcupados.isSelected()) {
            return "OCUPADO";
        }
        
        return "";
    }
    
    private boolean isSelected(){
        int pos = tableHabitaciones.getSelectedRow();
        if (pos==-1) {
            msg.errorMsg("DEBE SELECCIONAR UN HABITACION");
            return false;
        }
        return true;
    }
    
    private boolean isDisponible(){
        int pos = tableHabitaciones.getSelectedRow();
        String estado = tableHabitaciones.getValueAt(pos, 4).toString();
        return "Disponible".equals(estado);
    }
    
    public LocalDateTime getFechaReserva(){
        Date d = this.dateReserva.getDate();
        
        String enformatoTimeStamp = format.Date_to_String(d);
        
        String hour = this.cboxHora.getSelectedItem().toString();
        String minute = this.cboxMinuto.getSelectedItem().toString();
        
        enformatoTimeStamp+=" "+hour+":"+minute+":00";
        
        return format.timeStamp_to_DateTime(enformatoTimeStamp);
    }
    
    public void setFechaReserva(LocalDateTime fecha){
        this.dateReserva.setDate(format.LocalDateTime_to_Date(fecha));
        this.setHora(format.LocalDateTime_to_Horas(fecha));
        this.setMinuto(format.LocalDateTime_to_Minutos(fecha));
    }
    
    private void setHora(int hora){
        for (int i = 0; i < cboxHora.getItemCount(); i++) {
            int valorPuntero = Integer.valueOf(cboxHora.getItemAt(i));
            if (valorPuntero==hora) {
                cboxHora.setSelectedIndex(i);
                break;
            }
        }     
    }
    
    private void setMinuto(int minuto){
        for (int i = 0; i < cboxMinuto.getItemCount(); i++) {
            int valorPuntero = Integer.valueOf(cboxMinuto.getItemAt(i));
            if (valorPuntero==minuto) {
                cboxMinuto.setSelectedIndex(i);
                break;
            }
        }     
    }   
    
    private boolean isFormValidado() {
        if (this.dateReserva.getDate()==null) {
            msg.errorMsg("Fecha no seleccionada");
            return false;
        }
        
        if (!validar.isFuture(this.getFechaReserva())) {
            return false;
        }
        
        return true;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnElegirRE;
    private javax.swing.JButton btnElegirRR;
    private javax.swing.ButtonGroup btnGroupFiltros;
    private javax.swing.JButton btnVolverRE;
    private javax.swing.JButton btnVolverRR;
    private javax.swing.JButton btnVolverVRecep;
    private javax.swing.JComboBox<String> cboxHora;
    private javax.swing.JComboBox<String> cboxMinuto;
    private com.toedter.calendar.JDateChooser dateReserva;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPanel panelConsultas;
    private javax.swing.JPanel panelRegistroEntrada;
    private javax.swing.JPanel panelRegistroReserva;
    private javax.swing.JPanel panelTable;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JRadioButton rdBtnDisponibles;
    private javax.swing.JRadioButton rdBtnOcupados;
    private javax.swing.JRadioButton rdBtnTodos;
    private javax.swing.JTable tableHabitaciones;
    private javax.swing.JTextField txtNombreTipo;
    // End of variables declaration//GEN-END:variables
}

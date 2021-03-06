/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7p2_pamelaramirez_12141141;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class Principal extends javax.swing.JFrame {
    Administracion admin;
    Random r = new Random();
    
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        actualizarTabla();
    }

    public void actualizarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        String[] encabezado = new String[9];
        modelo.setColumnCount(9);
        if (admin != null) {
            if (!admin.getEquipos().isEmpty()) {
                admin.pruebaOrdenamiento();
                modelo.setRowCount(admin.getEquipos().size());
                Object[][] datos = new Object[admin.getEquipos().size()][9];
                // Llenar matriz con datos
                for (int i = 0; i < admin.getEquipos().size(); i++) {
                    datos[i][0] = admin.getEquipos().get(i).getNombre();
                    datos[i][1] = admin.getEquipos().get(i).getJugados();
                    datos[i][2] = admin.getEquipos().get(i).getGanados();
                    datos[i][3] = admin.getEquipos().get(i).getEmpatados();
                    datos[i][4] = admin.getEquipos().get(i).getPerdidos();
                    datos[i][5] = admin.getEquipos().get(i).getGolesFavor();
                    datos[i][6] = admin.getEquipos().get(i).getGolesContra();
                    datos[i][7] = admin.getEquipos().get(i).getDif();
                    datos[i][8] = admin.getEquipos().get(i).getPts();
                }
                // Llenar tabla con matriz
                for (int i = 0; i < admin.getEquipos().size(); i++) {
                    for (int j = 0; j < 9; j++) {
                        modelo.setValueAt(datos[i][j], i, j);
                    }
                }
            }
        }
        // Encabezado
        encabezado[0] = "Nombre";
        encabezado[1] = "Jugados";
        encabezado[2] = "Ganados";
        encabezado[3] = "Empatados";
        encabezado[4] = "Perdidos";
        encabezado[5] = "Goles a favor";
        encabezado[6] = "Goles en contra";
        encabezado[7] = "Diferencia";
        encabezado[8] = "Puntos";
        modelo.setColumnIdentifiers(encabezado);
        tabla.setModel(modelo);
    }
    
    public void actualizarTodo() {
        DefaultComboBoxModel cboModel = new DefaultComboBoxModel();
        DefaultComboBoxModel cboModel2 = new DefaultComboBoxModel();
        if (admin != null) {
            if (!admin.getEquipos().isEmpty()) {
                for (Equipo equipo : admin.getEquipos()) {
                    cboModel.addElement(equipo.getNombre());
                    cboModel2.addElement(equipo.getNombre());
                }
            }
        }
        if (jTabbedPane1.getSelectedIndex() == 0) {
            limpiarTab1();
            cboEditarElim.setModel(cboModel);
        }
        else if (jTabbedPane1.getSelectedIndex() == 1) {
            actualizarTabla();
        }
        else {
            cboE1.setModel(cboModel);
            cboE2.setModel(cboModel2);
        }
    }
    
    public void limpiarTab1() {
        txtNombre.setText(null);
        spJug.setValue(0);
        spGan.setValue(0);
        spPer.setValue(0);
        spEmp.setValue(0);
        spFav.setValue(0);
        spCon.setValue(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        spGan = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        spPer = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spEmp = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        spFav = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        spCon = new javax.swing.JSpinner();
        btnGuardar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cboEditarElim = new javax.swing.JComboBox<>();
        spJug = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboE1 = new javax.swing.JComboBox<>();
        cboE2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        lblGol1 = new javax.swing.JLabel();
        lblGol2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnPartido = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Registrar equipo");

        jLabel2.setText("Nombre");

        jLabel3.setText("Partidos ganados");

        spGan.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel4.setText("Partidos perdidos");

        spPer.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel5.setText("Partidos empatados");

        spEmp.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel6.setText("Goles a favor");

        spFav.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        jLabel7.setText("Goles en contra");

        spCon.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel11.setText("Para opciones de edicion");

        cboEditarElim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccionar -" }));

        spJug.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel12.setText("Partidos jugados");

        btnModificar.setText("Modificar equipo");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spPer, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spGan)
                    .addComponent(jLabel12)
                    .addComponent(spJug))
                .addGap(128, 128, 128)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboEditarElim, 0, 160, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spFav, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spCon, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(549, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spJug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spFav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboEditarElim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spGan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnModificar))))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Administrar equipos", jPanel1);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel15.setText("Tabla de posiciones");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Equipos registrados", jPanel2);

        jLabel8.setText("Equipo #1");

        jLabel9.setText("Equipo #2");

        cboE1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccionar -" }));

        cboE2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccionar -" }));

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel10.setText("Simulacion");

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("-");

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel14.setText("Resultado");

        btnPartido.setText("Comenzar partido");
        btnPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8)
                                    .addComponent(cboE1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblGol1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPartido, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                .addGap(44, 44, 44)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(cboE2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGol2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel14)))
                .addContainerGap(561, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPartido)
                .addGap(43, 43, 43)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGol2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGol1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(220, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Jugar partido", jPanel3);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Cargar archivo existente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edicion");

        jMenuItem2.setText("Llenar campos con los datos del equipo seleccionado");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Eliminar equipo seleccionado");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        File fileSeleccionado = null;
        try {
            JFileChooser jfc = new JFileChooser("./");
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");
            jfc.setFileFilter(filtro);
            int seleccion = jfc.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                fileSeleccionado = jfc.getSelectedFile();
                admin = new Administracion(fileSeleccionado);
                admin.cargarArchivo();
                actualizarTodo();
            }
        }
        catch (Exception e) {
            
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        actualizarTodo();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos.", "Error", 2);
        }
        else {
            if (admin != null) {
                admin.getEquipos().add(new Equipo(txtNombre.getText(), (Integer)spJug.getValue(),
                        (Integer)spGan.getValue(), (Integer)spEmp.getValue(), (Integer)spPer.getValue(),
                        (Integer)spFav.getValue(), (Integer)spCon.getValue()));
                try {
                    admin.escribirArchivo();
                } catch (IOException ex) {
                    
                }
            }
            actualizarTodo();
            JOptionPane.showMessageDialog(this, "Equipo agregado exitosamente.", "Operacion completada", 1);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartidoActionPerformed
        Equipo equipo1 = null;
        Equipo equipo2 = null;
        if (admin != null) {
            if (!admin.getEquipos().isEmpty()) {
                for (Equipo equipo : admin.getEquipos()) {
                    if (equipo.getNombre().equals(cboE1.getSelectedItem())) {
                        equipo1 = equipo;
                    }
                    if (equipo.getNombre().equals(cboE2.getSelectedItem())) {
                        equipo2 = equipo;
                    }
                }
                int gol1 = 0 + r.nextInt(5);
                int gol2 = 0 + r.nextInt(5);
                lblGol1.setText(Integer.toString(gol1));
                lblGol2.setText(Integer.toString(gol2));
                boolean empate = false, gano1 = true, gano2 = true;
                if (gol1 > gol2) {
                    gano2 = false;
                }
                else if (gol1 < gol2) {
                    gano1 = false;
                }
                else {
                    empate = true;
                }
                equipo1.simulacionPartido(gol1, gol2, empate, gano1);
                equipo2.simulacionPartido(gol2, gol1, empate, gano2);
                try {
                    admin.escribirArchivo();
                } catch (IOException ex) {
                    
                }
            }
        }
    }//GEN-LAST:event_btnPartidoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (admin != null) {
            if (!admin.getEquipos().isEmpty()) {
                for (Equipo equipo : admin.getEquipos()) {
                    if (equipo.getNombre().equals(cboEditarElim.getSelectedItem())) {
                        txtNombre.setText(equipo.getNombre());
                        spJug.setValue(equipo.getJugados());
                        spGan.setValue(equipo.getGanados());
                        spEmp.setValue(equipo.getEmpatados());
                        spPer.setValue(equipo.getPerdidos());
                        spFav.setValue(equipo.getGolesFavor());
                        spCon.setValue(equipo.getGolesContra());
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (admin != null) {
            if (!admin.getEquipos().isEmpty()) {
                for (Equipo equipo : admin.getEquipos()) {
                    if (equipo.getNombre().equals(cboEditarElim.getSelectedItem())) {
                        admin.getEquipos().remove(equipo);
                        try {
                            admin.escribirArchivo();
                            JOptionPane.showMessageDialog(this, "Equipo eliminado exitosamente.", "Operacion completada", 1);
                            break;
                        } catch (IOException ex) {
                            
                        }
                    }
                }
                actualizarTodo();
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (admin != null) {
            if (!admin.getEquipos().isEmpty()) {
                for (Equipo equipo : admin.getEquipos()) {
                    if (equipo.getNombre().equals(cboEditarElim.getSelectedItem())) {
                        equipo.setNombre(txtNombre.getText());
                        equipo.setJugados((Integer)spJug.getValue());
                        equipo.setGanados((Integer)spGan.getValue());
                        equipo.setEmpatados((Integer)spEmp.getValue());
                        equipo.setPerdidos((Integer)spPer.getValue());
                        equipo.setGolesFavor((Integer)spFav.getValue());
                        equipo.setGolesContra((Integer)spCon.getValue());
                        equipo.actualizarPtsDif();
                        try {
                            admin.escribirArchivo();
                            JOptionPane.showMessageDialog(this, "Equipo modificado exitosamente.", "Operacion completada", 1);
                            break;
                        } catch (IOException ex) {
                            
                        }
                    }
                }
                actualizarTodo();
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnPartido;
    private javax.swing.JComboBox<String> cboE1;
    private javax.swing.JComboBox<String> cboE2;
    private javax.swing.JComboBox<String> cboEditarElim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblGol1;
    private javax.swing.JLabel lblGol2;
    private javax.swing.JSpinner spCon;
    private javax.swing.JSpinner spEmp;
    private javax.swing.JSpinner spFav;
    private javax.swing.JSpinner spGan;
    private javax.swing.JSpinner spJug;
    private javax.swing.JSpinner spPer;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

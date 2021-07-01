/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railway_management_system;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sajee Thamanga
 */
public class Train_Info extends javax.swing.JFrame {

    String dbUserName = "root";
    String dbPassword = "";
    String dbServerUrl = "jdbc:mysql://localhost:3306/railway_management_system?autoReconnect=true&useSSL=false";
    String dbClassPathUrl = "com.mysql.cj.jdbc.Driver";

    String TrainID = "";
    int TotalCapacity = 0;
    int AvailableCapacity = 0;
    String routeID = "";
    int f_stclass = 0;
    int s_ndclass = 0;
    int t_rdclass = 0;
    String username;
    AdminMainGUI inst;
    Connection connx;
    DefaultTableModel model;

    /**
     * Creates new form Train_Info
     */
    public Train_Info() {
        initComponents();
        connx = databaseConnection();
        //populating jTable
        populateJTableFromsqlDatabase();
    }
    
    public Train_Info(String username, AdminMainGUI inst){
        this();
        this.username = username;
        this.inst = inst;
    }

    public Connection databaseConnection() {
        Connection conn;
        try {
            //Load Driver
            Class.forName(dbClassPathUrl);
            JOptionPane.showMessageDialog(null, "Driver Loaded");
            //Connect to database
            conn = DriverManager.getConnection(dbServerUrl, dbUserName, dbPassword);
            JOptionPane.showMessageDialog(null, "Connected");
            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    //store database results in ArrayList Method
    public ArrayList<Train> trainsList() {
        ArrayList<Train> trainLists = new ArrayList<Train>();
        String selectAllSQLQuery = "SELECT * FROM `train`";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = connx.createStatement();
            rs = stmt.executeQuery(selectAllSQLQuery);

            //loop through the results
            while (rs.next()) {
                Train train = new Train();
                //populate Phone Setters
                train.setTrainiD(rs.getString("train_id"));
                train.setTotCapacity(rs.getInt("total_capacity"));
                train.setAvaiCapacity(rs.getInt("available_capacity"));
                train.setF_stclass(rs.getInt("1st_class"));
                train.setS_ndclass(rs.getInt("2nd_class"));
                train.setT_rdclass(rs.getInt("3rd_class"));

                trainLists.add(train);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return trainLists;
    }

    //Populate JTable with data from database
    public void populateJTableFromsqlDatabase() {
        ArrayList<Train> dataArray = trainsList();
        model = (DefaultTableModel) jTable1.getModel();
        //clear JTable rows
        model.setRowCount(0);
        Object[] rows = new Object[6];

        //Loop through the arraylist to populate JTable
        for (int i = 0; i < dataArray.size(); i++) {
            rows[0] = dataArray.get(i).getTrainiD();
            rows[1] = dataArray.get(i).getTotCapacity();
            rows[2] = dataArray.get(i).getAvaiCapacity();
            rows[3] = dataArray.get(i).getF_stclass();
            rows[4] = dataArray.get(i).getS_ndclass();
            rows[5] = dataArray.get(i).getT_rdclass();
            model.addRow(rows);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTrainId = new javax.swing.JTextField();
        txtTotCapacity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtAvaiCapacity = new javax.swing.JTextField();
        CheckBox1stclass = new javax.swing.JCheckBox();
        CheckBox2ndclass = new javax.swing.JCheckBox();
        CheckBox3rdclass = new javax.swing.JCheckBox();
        btnClear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Train Information");

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Train Id", "Total Capacity", "Available Capacity", "1st class", "2nd class", "3rd class"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(51, 0, 51));
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Train ID :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Available Capacity : ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Type :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Total Capacity : ");

        buttonGroup1.add(CheckBox1stclass);
        CheckBox1stclass.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
        CheckBox1stclass.setText("1 st class");

        buttonGroup1.add(CheckBox2ndclass);
        CheckBox2ndclass.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
        CheckBox2ndclass.setText("2 nd class");

        buttonGroup1.add(CheckBox3rdclass);
        CheckBox3rdclass.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
        CheckBox3rdclass.setText("3 rd class");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAvaiCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CheckBox1stclass)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CheckBox2ndclass)
                                    .addGap(27, 27, 27)
                                    .addComponent(CheckBox3rdclass))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(65, 65, 65)
                                    .addComponent(txtTrainId, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(txtTotCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTrainId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAvaiCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CheckBox1stclass)
                        .addComponent(CheckBox2ndclass)
                        .addComponent(CheckBox3rdclass)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnInsert.setBackground(new java.awt.Color(153, 153, 153));
        btnInsert.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(153, 153, 153));
        btnUpdate.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(153, 153, 153));
        btnDelete.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/railway_management_system/GUI_Images/train.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate)
                                    .addComponent(btnClear))
                                .addGap(22, 22, 22)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsert)
                            .addComponent(btnUpdate))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelete)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear)))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //Display selected row on input fields
        int JTableSelectedRow = jTable1.getSelectedRow();

        txtTrainId.setText((trainsList().get(JTableSelectedRow).getTrainiD()));
        txtTotCapacity.setText(Integer.toString(trainsList().get(JTableSelectedRow).getTotCapacity()));
        txtAvaiCapacity.setText(Integer.toString(trainsList().get(JTableSelectedRow).getAvaiCapacity()));
        //txtRouteId.setText((trainsList().get(JTableSelectedRow).get()));
        int type = trainsList().get(JTableSelectedRow).getF_stclass();
        if (type == 1) {
            CheckBox1stclass.setSelected(true);
        }
        type = trainsList().get(JTableSelectedRow).getS_ndclass();
        if (type == 1) {
            CheckBox2ndclass.setSelected(true);
        }
        type = trainsList().get(JTableSelectedRow).getT_rdclass();
        if (type == 1) {
            CheckBox3rdclass.setSelected(true);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        TrainID = txtTrainId.getText();
        TotalCapacity = Integer.parseInt(txtTotCapacity.getText());
        AvailableCapacity = Integer.parseInt(txtAvaiCapacity.getText());
        if (CheckBox1stclass.isSelected()) {
            f_stclass = 1;
        } 
        if (CheckBox2ndclass.isSelected()) {
            s_ndclass = 1;
        } 
        if (CheckBox3rdclass.isSelected()) {
            t_rdclass = 1;
        }
        //String trainInsertSQLQuery = "INSERT INTO `train`(`train_id`, `total_capacity`, `available_capacity`, `route_id`, `type`) VALUES  (?,?,?,?,?) ";
        
        DB_connection connection = new DB_connection();
        DB_connection.Handle_Train train = connection.new Handle_Train(TrainID, TotalCapacity, AvailableCapacity, routeID, f_stclass, s_ndclass, t_rdclass);
        int trainInserted = train.insertInfo();
        
        if (trainInserted > 0) {
            JOptionPane.showMessageDialog(null, "Inserted Successfully");
            clearAllInputFields();
            //refresh JTable after adding new entry to mysql database
            populateJTableFromsqlDatabase();
        }
     
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
         //first check if the ID field is empty
        if (txtTrainId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Train ID Field is Empty");
        } else {
        Connection dbconnection = null;
        PreparedStatement prestmt = null;
        String updateSQLQuery = "UPDATE `train` SET `total_capacity`=?,`available_capacity`=?,`route_id`=?,`type`=? WHERE `train_id` = ? ";
        dbconnection = this.connx;

       // TrainID = txtTrainId.getText();
        TotalCapacity = Integer.parseInt(txtTotCapacity.getText());
        AvailableCapacity = Integer.parseInt(txtAvaiCapacity.getText());
        if (CheckBox1stclass.isSelected()) {
            f_stclass = 1;
        } else if (CheckBox2ndclass.isSelected()) {
            s_ndclass = 1;
        } else if (CheckBox3rdclass.isSelected()) {
            t_rdclass = 1;
        }
        
        DB_connection connection = new DB_connection();
        DB_connection.Handle_Train updateRow = connection.new Handle_Train(TrainID, TotalCapacity, AvailableCapacity, routeID, f_stclass, s_ndclass, t_rdclass);
        int trainUpdated = updateRow.updateInfo();
        }
       
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //first check if the ID field is empty
        if (txtTrainId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Train ID Field is Empty");
        } else {
            //Delete data from mysqldatabase
            Connection dbConnection = null;
            PreparedStatement pstmt = null;
            String deleteSQLQuery = "DELETE FROM `train` WHERE `train_id` = ? ";

            try {
                dbConnection = this.connx;
                pstmt = dbConnection.prepareStatement(deleteSQLQuery);
                pstmt.setInt(1, Integer.parseInt(txtTrainId.getText()));
                int deletestmt = pstmt.executeUpdate();

                if (deletestmt > 0) {
                    JOptionPane.showMessageDialog(null, "Deleted Successfully!!");
                    //clear Input fields after deleting
                    clearAllInputFields();
                    //refresh jTable to remove deleted row
                    populateJTableFromsqlDatabase();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                //close connection
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }

                    if (dbConnection != null) {
                        dbConnection.close();
                    }
                } catch (SQLException sQLException) {
                    sQLException.getMessage();
                }
            }
    }//GEN-LAST:event_btnDeleteActionPerformed
    }
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearAllInputFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AdminMainGUI returns = new AdminMainGUI();
        returns.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Train_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Train_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Train_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Train_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Train_Info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBox1stclass;
    private javax.swing.JCheckBox CheckBox2ndclass;
    private javax.swing.JCheckBox CheckBox3rdclass;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAvaiCapacity;
    private javax.swing.JTextField txtTotCapacity;
    private javax.swing.JTextField txtTrainId;
    // End of variables declaration//GEN-END:variables

    private void clearAllInputFields() {

        txtTrainId.setText("");
        txtTotCapacity.setText("");
        txtAvaiCapacity.setText("");
        buttonGroup1.clearSelection();


    }

}

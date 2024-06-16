package View;

import Controller.mData;
import Model.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class MainFrame extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public MainFrame() {
        initComponents();
        conn = DBconnect.connect();
        tableload();
    }

    public void tableload(){
    
        try{
           String sql = "SELECT id AS ID,iname AS IName,ibrand AS IBrand,iprice AS IPrice FROM instruments";
           pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
           Table1.setModel(DbUtils.resultSetToTableModel(rs));
    }   catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
    }    
}
    public void tabledata() {
        int r = Table1.getSelectedRow();
        
        String id = Table1.getValueAt(r, 0).toString();
        String name = Table1.getValueAt(r, 1).toString();
        String brand = Table1.getValueAt(r, 2).toString();
        String price = Table1.getValueAt(r, 3).toString();
        
        idbox.setText(id);
        namebox.setText(name);
        brandbox.setSelectedItem(brand);
        pricebox.setText(price);
        
                
}
    
    public void  search() {
    
        String srch = searchbox.getText();
        
        try {
            String sql = "SELECT * FROM instruments WHERE IName LIKE '%"+srch+"%' OR id LIKE '%"+srch+"%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Table1.setModel (DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
}
    
    public void update() {
    
         String id = idbox.getText();
         String name = namebox.getText();
         String brand = brandbox.getSelectedItem().toString();
         String price = pricebox.getText();
         
         try{
             String sql = "UPDATE instruments SET IName='"+name+"', IBrand='"+brand+"', IPrice='"+price+"' WHERE ID='"+id+"'";
             pst = conn.prepareStatement(sql);
             pst.execute();
             JOptionPane.showMessageDialog(null, "Updated!");
         
        } catch (Exception e) {  
             JOptionPane.showMessageDialog(null, e);
        } 
         
}
    
    public void clear(){
          
         searchbox.setText("");
         idbox.setText("ID");
         namebox.setText("");
         brandbox.setSelectedIndex(0);
         pricebox.setText("");
         
         
}         
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        srbox = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namebox = new java.awt.TextField();
        pricebox = new java.awt.TextField();
        brandbox = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        Insert = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        idbox = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        srbox.setBackground(new java.awt.Color(255, 255, 0));
        srbox.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        srbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                srboxKeyReleased(evt);
            }
        });

        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout srboxLayout = new javax.swing.GroupLayout(srbox);
        srbox.setLayout(srboxLayout);
        srboxLayout.setHorizontalGroup(
            srboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchbox)
        );
        srboxLayout.setVerticalGroup(
            srboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(srboxLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(srbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, 230, -1));

        jPanel5.setBackground(new java.awt.Color(0, 153, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Insrtument Name");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel2.setText("Brand");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel3.setText("Price");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 127, -1, -1));

        namebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameboxActionPerformed(evt);
            }
        });
        jPanel5.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 11, 85, -1));

        pricebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceboxActionPerformed(evt);
            }
        });
        jPanel5.add(pricebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 127, 94, -1));

        brandbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Yamaha", "Roland", "Gibson" }));
        brandbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandboxActionPerformed(evt);
            }
        });
        jPanel5.add(brandbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 64, -1, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 137, 230, 170));

        jPanel3.setBackground(new java.awt.Color(0, 153, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Insert.setText("Insert");
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });
        jPanel3.add(Insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 53, -1, -1));

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel3.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 53, -1, -1));

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel3.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 107, -1, -1));

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel3.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 107, -1, -1));

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jPanel3.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 157, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 230, 200));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("ID");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 104, -1, -1));

        idbox.setText("id");
        jPanel2.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 120, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 580));

        Table1.setBackground(new java.awt.Color(255, 204, 102));
        Table1.setModel(new javax.swing.table.DefaultTableModel(
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
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        Table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 760, 500));

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 530, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1030, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void brandboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brandboxActionPerformed

    private void nameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameboxActionPerformed

    private void priceboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceboxActionPerformed

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        
       
        
     String  name = namebox.getText();
     String  brand = brandbox.getSelectedItem().toString();
     String  price = pricebox.getText();
      
      try {
           
          mData controller = new mData();
            controller.getData(name, brand, price);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numerical values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
      
        
       
       
    }//GEN-LAST:event_InsertActionPerformed
        
    
    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete!");
        
        if(check==0) {
            String id = idbox.getText();
            
            try {
                String sql = "DELETE FROM instruments WHERE ID ='"+id+"' ";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                
            }
        }
        tableload();
        clear();
    }//GEN-LAST:event_DeleteActionPerformed

    private void srboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srboxKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_srboxKeyReleased

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_searchboxKeyReleased

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        update();
        tableload();
    }//GEN-LAST:event_UpdateActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
CoustomerFrame obj = new CoustomerFrame();
 obj.setVisible(true);
 this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table1KeyReleased
        // TODO add your handling code here:
        tabledata();
    }//GEN-LAST:event_Table1KeyReleased

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        // TODO add your handling code here:
        tabledata();
    }//GEN-LAST:event_Table1MouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Insert;
    private javax.swing.JTable Table1;
    private javax.swing.JButton Update;
    private javax.swing.JComboBox<String> brandbox;
    private javax.swing.JButton clear;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField namebox;
    private java.awt.TextField pricebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JPanel srbox;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author elate
 */
public class newBrand extends javax.swing.JFrame {

    /**
     * Creates new form newBrand
     */
    sqlDriverConn con=new sqlDriverConn();
    Connection connect=con.EstablishCon();
    PreparedStatement pstmt=null;
    Statement stmt = null;
    ResultSet res;
    public newBrand() {
        initComponents();
        this.setLocationRelativeTo(null);
        fillcat();
    }
    private boolean isAnyRequiredFieldEmpty() {
        return brand.getText().equals("") || email.getText().equals("")||catcombo.getSelectedItem().equals("Select Category");
    }
    public void fillcat(){
        PreparedStatement statement;     
        try {
            catcombo.removeAllItems();
                String st="SELECT * FROM INFORMATION_SCHEMA.TABLES";
                statement = connect.prepareStatement(st);
                ResultSet resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    String category=resultSet.getString(3);
                    if(category.substring(0, 2).equals("c_")){
                          catcombo.addItem(category.substring(2));
   
                    }
            }
        
        } catch (SQLException ex) {
            printStackTrace();
        }
    }
    public void Close(){
             WindowEvent WCE=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
             Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(WCE);
             
         }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        brand = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        catcombo = new javax.swing.JComboBox<>();
        newcat = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelFocusGained(evt);
            }
        });
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        brand.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                brandFocusGained(evt);
            }
        });
        panel.add(brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 120, 30));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel2.setText("Brand");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 60, 30));

        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFocusGained(evt);
            }
        });
        panel.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 120, 30));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel3.setText("Email");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 60, 30));

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        panel.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 80, 30));

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        panel.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 80, 30));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel5.setText("Category");
        panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 60, 30));

        catcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category" }));
        catcombo.setToolTipText("");
        catcombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                catcomboFocusGained(evt);
            }
        });
        catcombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catcomboMouseClicked(evt);
            }
        });
        catcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catcomboActionPerformed(evt);
            }
        });
        panel.add(catcombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 160, 30));

        newcat.setBackground(new java.awt.Color(255, 255, 255));
        newcat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/NEW.PNG"))); // NOI18N
        newcat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        newcat.setBorderPainted(false);
        newcat.setContentAreaFilled(false);
        newcat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newcatActionPerformed(evt);
            }
        });
        panel.add(newcat, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 30, 30));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel7.setText("NEW BRAND");
        panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void defaultBorder(){
        brand.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        email.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        
    }
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        if(isAnyRequiredFieldEmpty()==false){
                       String brand=this.brand.getText();
                       String email=this.email.getText();
                       String cat=(String) catcombo.getSelectedItem();
                       
                       try {
//                         
                       Statement st = connect.createStatement();
                       st.executeUpdate("insert into Brands(brandName,ProductCat,email) values('"+brand+"','"+cat+"','"+email+"')");
                                 
                                 
                       JOptionPane.showMessageDialog(this,"Brand Registered Successfully...","Registration",JOptionPane.INFORMATION_MESSAGE);
                           
                           
                       } catch (SQLException ex) {
                           Logger.getLogger(newCategory.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       
                   }else{
                brand.setBorder(BorderFactory.createLineBorder(Color.red));
                email.setBorder(BorderFactory.createLineBorder(Color.red));
//                     JOptionPane.showMessageDialog(this,"All fields are Required.");  
                   }  
    }//GEN-LAST:event_addActionPerformed

    private void newcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newcatActionPerformed

        newCategory catg=new newCategory();
        catg.setVisible(true);
    }//GEN-LAST:event_newcatActionPerformed

    private void catcomboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catcomboMouseClicked
     fillcat();        // TODO add your handling code here:
    }//GEN-LAST:event_catcomboMouseClicked

    private void catcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catcomboActionPerformed

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked
    fillcat();     // TODO add your handling code here:
    }//GEN-LAST:event_panelMouseClicked

    private void catcomboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_catcomboFocusGained
         // TODO add your handling code here:
    }//GEN-LAST:event_catcomboFocusGained

    private void panelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelFocusGained
         // TODO add your handling code here:
    }//GEN-LAST:event_panelFocusGained

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
    Close();        // TODO add your handling code here:
    }//GEN-LAST:event_closeActionPerformed

    private void brandFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brandFocusGained
    defaultBorder();        // TODO add your handling code here:
    }//GEN-LAST:event_brandFocusGained

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
    defaultBorder();        // TODO add your handling code here:
    }//GEN-LAST:event_emailFocusGained

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
            java.util.logging.Logger.getLogger(newBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newBrand().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField brand;
    private javax.swing.JComboBox<String> catcombo;
    private javax.swing.JButton close;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton newcat;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}

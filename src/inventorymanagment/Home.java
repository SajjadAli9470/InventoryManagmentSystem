/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sun.security.util.Password;

/**
 *
 * @author elate
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    sqlDriverConn con=new sqlDriverConn();
    Connection connect=con.EstablishCon();
    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        check();

    }
    public void check(){
       Admin c=new Admin();
        c.setVisible(true);
    }
    
    public void Close(){
             WindowEvent WCE=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
             Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(WCE);
             
         }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        adminname = new javax.swing.JTextField();
        adminpass = new javax.swing.JPasswordField();
        userlogin = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        userpass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        newadmin = new javax.swing.JButton();
        newuser = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        adminlogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/admin.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/user.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/head.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 310, -1));

        adminname.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        adminname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        adminname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jPanel2.add(adminname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 130, 30));

        adminpass.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        adminpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        adminpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        adminpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminpassActionPerformed(evt);
            }
        });
        jPanel2.add(adminpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 130, 30));

        userlogin.setBackground(new java.awt.Color(37, 34, 34));
        userlogin.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        userlogin.setForeground(new java.awt.Color(255, 255, 255));
        userlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/SECURITY.PNG"))); // NOI18N
        userlogin.setText("LOGIN");
        userlogin.setBorder(null);
        userlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userloginActionPerformed(evt);
            }
        });
        jPanel2.add(userlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, 230, 30));

        username.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 140, 30));

        userpass.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        userpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(userpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 140, 30));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel2.setText("Adminname");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 90, 30));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel6.setText("Pass Code");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel7.setText("Username");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel8.setText("Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("ADMIN LOGIN");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 180, 30));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel10.setText("CUSTOMER LOGIN");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 230, 20));

        newadmin.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        newadmin.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        newadmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/lockapplication.png"))); // NOI18N
        newadmin.setText("New Admin");
        newadmin.setBorder(null);
        newadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newadminActionPerformed(evt);
            }
        });
        jPanel2.add(newadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 220, 30));

        newuser.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        newuser.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        newuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/CUSTOMER.PNG"))); // NOI18N
        newuser.setText("New Customer");
        newuser.setBorder(null);
        newuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newuserActionPerformed(evt);
            }
        });
        jPanel2.add(newuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 230, 30));

        cancel.setBackground(new java.awt.Color(255, 204, 204));
        cancel.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(51, 51, 51));
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/EXIT.PNG"))); // NOI18N
        cancel.setText("Exit");
        cancel.setBorder(null);
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel2.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 170, 30));

        adminlogin.setBackground(new java.awt.Color(37, 34, 34));
        adminlogin.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        adminlogin.setForeground(new java.awt.Color(255, 255, 255));
        adminlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/SECURITY.PNG"))); // NOI18N
        adminlogin.setText("LOGIN");
        adminlogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        adminlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminloginActionPerformed(evt);
            }
        });
        jPanel2.add(adminlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 220, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void adminpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminpassActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void newuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newuserActionPerformed
       RegCust newUser=new RegCust();
        newUser.setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_newuserActionPerformed

    private void newadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newadminActionPerformed
        RegAdmin newAdmin=new RegAdmin();
//        Home home=new Home();
//        home.setVisible(false);
        newAdmin.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_newadminActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        Close();        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void adminloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminloginActionPerformed
        String adminname=this.adminname.getText();
        String passcode=adminpass.getText();
        
        
        String EmpName="";
        Statement st;
        try {
            
                        
                        
                        PreparedStatement statement;
                        String stmt1="select * from AdminAccount where AdminName='"+adminname+"' and AdminPassword='"+passcode+"'";
                        
                        statement = connect.prepareStatement(stmt1);
                        ResultSet resultSet = statement.executeQuery();
                        
                        while(resultSet.next()){
                            adminid=resultSet.getInt("Adminid");
   
                        }
                        
                        if(adminid!=0){
                            String stmt2="select * from AdminDetail where AdminID='"+adminid+"'";
                            statement=connect.prepareStatement(stmt2);
                            resultSet=statement.executeQuery();
                            while(resultSet.next()){
                                EmpName=resultSet.getString("fname")+" "+resultSet.getString("lname");
                                      
                            }
                            ImageIcon icon=new ImageIcon("src/Figures/admin.png");
                            JOptionPane.showMessageDialog(this,EmpName+"\nLogged in Successfully","Login Success",JOptionPane.INFORMATION_MESSAGE,icon);
//                            Close();
                        }
                        else{
                            JOptionPane.showMessageDialog(this,"Admin name or Passcode are incorrect","Login Error",JOptionPane.ERROR_MESSAGE);
                        }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    }//GEN-LAST:event_adminloginActionPerformed

    private void userloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userloginActionPerformed
        String username=this.username.getText();
        String password=userpass.getText();

        String UserName="";
        Statement st;
        try {
            
                        
                        
                        PreparedStatement statement;
                        String stmt1="select * from CustomerAccount where Username='"+username+"' and Userpassword='"+password+"'";
                        
                        statement = connect.prepareStatement(stmt1);
                        ResultSet resultSet = statement.executeQuery();
                        
                        while(resultSet.next()){
                            userid=resultSet.getInt("Userid");
   
                        }
                        
                        if(userid!=0){
                            String stmt2="select * from CustomerDetail where Userid='"+userid+"'";
                            statement=connect.prepareStatement(stmt2);
                            resultSet=statement.executeQuery();
                            while(resultSet.next()){
                                UserName=resultSet.getString("fname")+" "+resultSet.getString("lname");
                                      
                            }
                            
//                            Close();
                        }
                        else{
                            JOptionPane.showMessageDialog(this,"Username or Password are incorrect","Login Error",JOptionPane.ERROR_MESSAGE);
                        }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_userloginActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
//        loadData load = new loadData();
//        load.setVisible(true);
//         try{
//        for(int i = 0; i<=100; i++){
//        Thread.sleep(i);
//            
//        if(i<30){
//            load.loadtxt.setText("loading Database .....");
//        }
//        if(i>=30&&i<45){
//            load.loadtxt.setText("Reading Table's.....");
//        }
//        if(i>=45&&i<85){
//            load.loadtxt.setText("Initiating data...");
//        }
//        if(i>=85&&i<=100){
//            load.loadtxt.setText("Compeleted");
//        }
//
//        load.ProgressBar.setValue(i);
//        
//       
//       
//        }
//
//        
//        }catch(Exception e){
//        
//        }
//        load.Close();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                load.setVisible(false);
                new Home().setVisible(true);
            }
        });
    }
    int adminid=0;
    int userid=0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminlogin;
    private javax.swing.JTextField adminname;
    private javax.swing.JPasswordField adminpass;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton newadmin;
    private javax.swing.JButton newuser;
    private javax.swing.JButton userlogin;
    private javax.swing.JTextField username;
    private javax.swing.JPasswordField userpass;
    // End of variables declaration//GEN-END:variables
}

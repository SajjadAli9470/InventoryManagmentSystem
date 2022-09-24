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
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author elate
 */
public class RegCust extends javax.swing.JFrame {

    /**
     * Creates new form RegCust
     */
    sqlDriverConn con=new sqlDriverConn();
    Connection connect=con.EstablishCon();
    public RegCust() {
        initComponents();
        this.setLocationRelativeTo(null);
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis); 
        dob.setDate(date);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        dob = new com.toedter.calendar.JDateChooser();
        gender = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(251, 246, 238));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204))));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/user.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel2.setText("Customer Registration");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel3.setText("Phone # ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel5.setText("Last Name : ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel6.setText("Password :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel8.setText("DOB :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 70, 20));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel9.setText("Gender :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel10.setText("Address :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel7.setText("First Name :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 90, -1));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel12.setText("User Name :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

        fname.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                fnameFocusLost(evt);
            }
        });
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 150, 30));

        lname.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 150, 30));

        address.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        address.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 150, 30));

        phone.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        phone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 150, 30));

        password.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 150, 30));

        username.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 150, 30));

        submit.setBackground(java.awt.SystemColor.activeCaption);
        submit.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel1.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 150, 30));

        cancel.setBackground(java.awt.SystemColor.inactiveCaption);
        cancel.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/CANCEL.PNG"))); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 150, 30));
        jPanel1.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 150, 30));

        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Intersex" }));
        jPanel1.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
    Close();        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed
    public boolean checkRepeatUserName(String name){
        boolean confirm=false;
        PreparedStatement statement;     
        try {
                String st="select Username from CustomerAccount";
                statement = connect.prepareStatement(st);
                ResultSet resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    String dbname=resultSet.getString(1);
               
                    
                    if(name.equals(dbname)){
                   
                        confirm=true;
                    }
            }
                
              
        
        } catch (SQLException ex) {
            Logger.getLogger(RegCust.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return confirm;
    }  
         private boolean isAnyRequiredFieldEmpty() {
        return fname.getText().equals("") || lname.getText().equals("") || address.getText().equals("")||phone.getText().equals("")||username.getText().equals("")||password.getText().equals("");
        
    }
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
      SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
            String date=df1.format(dob.getDate());
            
            String fname=this.fname.getText();
            String lname=this.lname.getText();
            String gender=(String) this.gender.getSelectedItem();
            String address=this.address.getText();
            String phone=this.phone.getText();
            String username=this.username.getText();
            String password=this.password.getText();
            
            
        if(isAnyRequiredFieldEmpty()!=false){
               JOptionPane.showMessageDialog(this,"All fields are Required.");
           }
           else{
                
            if(checkRepeatUserName(username)==true){
                
                JOptionPane.showMessageDialog(this,"Username is already registered\nUse diffrent one..","Username",JOptionPane.ERROR_MESSAGE);
            }
            else{
                boolean signin=false;
                int userid=0;
               try {
                     Statement st = connect.createStatement();
                     st.executeUpdate("insert into CustomerAccount(username,Userpassword) values('"+username+"','"+password+"')");
                        
                        PreparedStatement statement;
                        String stmt="select Userid from CustomerAccount where Username='"+username+"'";
                        statement = connect.prepareStatement(stmt);
                        ResultSet resultSet = statement.executeQuery();
                        
                        while(resultSet.next()){
                            userid=resultSet.getInt(1);
                            
                        }
                        st.executeUpdate("insert into CustomerDetail(fname,lname,DOB,gender,CustAddress,Phoneno,Userid) values('"+fname+"','"+lname+"','"+date+"','"+gender+"','"+address+"','"+phone+"','"+userid+"')"); 
                     
                        signin=true;
               
               } catch (SQLException ex) {
                         
                     Logger.getLogger(RegCust.class.getName()).log(Level.SEVERE, null, ex);
                    }
            if(signin==true){
                        ImageIcon icon = new ImageIcon("src/Figures/MODIFY.png");
        JOptionPane.showMessageDialog(this, "Hi "+fname+"\n\tUser ID : "+userid+"\n\tUser Name : "+username+"\n\tPasscode : "+password+"","Remember this",JOptionPane.INFORMATION_MESSAGE,icon);
            
        Close();
            
            }
            } }  
        
    }//GEN-LAST:event_submitActionPerformed

    private void fnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fnameFocusLost
        String fname=this.fname.getText().toLowerCase();
            Random objGenerator = new Random();
            int randomNumber = objGenerator.nextInt(1000);
            String generatedname=fname+randomNumber;
             if(fname.equals("")){
                }
              else{
                username.setText(generatedname);

              }
    }//GEN-LAST:event_fnameFocusLost
      
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
            java.util.logging.Logger.getLogger(RegCust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegCust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegCust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegCust.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegCust().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton cancel;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField fname;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField password;
    private javax.swing.JTextField phone;
    private javax.swing.JButton submit;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}


package inventorymanagment;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elate
 */
public class newCategory extends javax.swing.JFrame {
    sqlDriverConn con=new sqlDriverConn();
    Connection connect=con.EstablishCon();
    PreparedStatement pstmt=null;
    Statement stmt = null;
    ResultSet res;
    DefaultTableModel d;
    public newCategory() {
        initComponents();
        this.setLocationRelativeTo(null);
        fillTable();
    }
  public void Close(){
             WindowEvent WCE=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
             Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(WCE);
             
         }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allcat = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        catname = new javax.swing.JTextField();
        addcat = new javax.swing.JButton();
        close = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel7.setText("NEW PRODUCT");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel8.setText("NEW CATEGORY");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, -1));

        allcat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Avaliable Category "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(allcat);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 150, 110));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel2.setText("Category Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 120, 30));
        jPanel2.add(catname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 170, 30));

        addcat.setText("Add");
        addcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcatActionPerformed(evt);
            }
        });
        jPanel2.add(addcat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 80, 30));

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        jPanel2.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     private boolean isAnyRequiredFieldEmpty() {
        return catname.getText().equals("");
    }
     public void fillTable(){
         int c;
       try {
           pstmt=connect.prepareStatement("SELECT * FROM INFORMATION_SCHEMA.TABLES");
           res=pstmt.executeQuery();
           ResultSetMetaData rsd = res.getMetaData();
           c=rsd.getColumnCount();
           d=(DefaultTableModel)allcat.getModel();
           d.setRowCount(0);
           while(res.next()){
               Vector v2=new Vector(); 
               for(int i=1;i<=c;i++){
                   String cat=res.getString(3);
                   if(cat.substring(0, 2).equals("c_")){
                     v2.add(cat.substring(2));  
                   }
               }
               d.addRow(v2);
               
           }
           
       } catch (SQLException ex) {
           printStackTrace();
       }
     }
     public boolean checkRepeatAdminName(String name){
        boolean confirm=false;
        PreparedStatement statement;     
        try {
                String st="SELECT * FROM INFORMATION_SCHEMA.TABLES";
                statement = connect.prepareStatement(st);
                ResultSet resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    String dbname=resultSet.getString(3).toLowerCase();                       
                    if(dbname.substring(2).equals(name.toLowerCase())&& dbname.substring(0, 2).equals("c_")){
                   
                        confirm=true;
                    }
            }
                
              
        
        } catch (SQLException ex) {
            printStackTrace();
        }
        
        return confirm;
    }     
    private void addcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcatActionPerformed
                   if(isAnyRequiredFieldEmpty()==false){
                       String cat="c_"+catname.getText();
                       
                       Statement st=null;
                       try {
                           st = connect.createStatement();
                           st.executeUpdate("CREATE TABLE " +cat+
                                 "(cp_id int identity(1,1) primary key , " +
                                 " cproduct varchar(20), " + 
                                 " pr_id int foreign key references Products(pr_id))");
                                 
                                 
                           
                           fillTable();
                           newBrand br=new newBrand();
                           br.fillcat();
                       } catch (SQLException ex) {
                           Logger.getLogger(newCategory.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       
                   }else{
                       catname.setBorder(BorderFactory.createLineBorder(Color.red));
                
//                     JOptionPane.showMessageDialog(this,"All fields are Required.");  
                   }             
    }//GEN-LAST:event_addcatActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
    Close();        // TODO add your handling code here:
    }//GEN-LAST:event_closeActionPerformed

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
            java.util.logging.Logger.getLogger(newCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newCategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addcat;
    private javax.swing.JTable allcat;
    private javax.swing.JTextField catname;
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

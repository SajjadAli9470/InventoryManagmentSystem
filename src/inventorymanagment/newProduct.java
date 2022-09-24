/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author elate
 */
public class newProduct extends javax.swing.JFrame {

    /**
     * Creates new form newProduct
     */
    
     sqlDriverConn con=new sqlDriverConn();
    Connection connect=con.EstablishCon();
    PreparedStatement pstmt=null;
    Statement stmt = null;
    ResultSet res;
    public newProduct() {
        initComponents();
        this.setLocationRelativeTo(null);
        fillBrand();
        fillCategory();
        fillSupplier();
        defaultBorder();
    }
    public void Close(){
             WindowEvent WCE=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
             Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(WCE);
             
         }
    private boolean isAnyRequiredFieldEmpty() {
        return product.getText().equals("") || quantity.getText().equals("") || price.getText().equals("");
    }
    
    public void fillBrand(){
    PreparedStatement statement;     
        try {
                brand.removeAllItems();
                String st="SELECT brandName FROM brands";
                statement = connect.prepareStatement(st);
                ResultSet resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    String br=resultSet.getString(1);
                    
                        brand.addItem(br);
   
                    
            }
        
        } catch (SQLException ex) {
            printStackTrace();
        }
    }
    public void fillCategory(){
        PreparedStatement statment;
        String selectedBrand=(String) brand.getSelectedItem();
        String st="select productCat from brands where brandName='"+selectedBrand+"'";
        try {
                cat.removeAllItems();
                
                statment = connect.prepareStatement(st);
                res = statment.executeQuery();
                
                while(res.next()){
                    String category=res.getString(1);
                    
                        cat.addItem(category);
   
                    
            }
        
        } catch (SQLException ex) {
            printStackTrace();
        }
        
    }
    public void fillSupplier(){
    PreparedStatement statement;     
        try {
                sup.removeAllItems();
                String st="SELECT supplierName FROM suppliers";
                statement = connect.prepareStatement(st);
                ResultSet resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    String su=resultSet.getString(1);
                    
                        sup.addItem(su);
   
                    
            }
        
        } catch (SQLException ex) {
            printStackTrace();
        }
    }
    public void setFormatPrice(){
        price.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        e.consume();
      }
    }
  });
    }
    public void setFormatQuantity(){
 quantity.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
      char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        getToolkit().beep();
        e.consume();
      }
    }
  });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton12 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        close = new javax.swing.JButton();
        add = new javax.swing.JButton();
        newbr = new javax.swing.JButton();
        cat = new javax.swing.JComboBox<>();
        brand = new javax.swing.JComboBox<>();
        newcat = new javax.swing.JButton();
        newsup = new javax.swing.JButton();
        sup = new javax.swing.JComboBox<>();
        product = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/NEW.PNG"))); // NOI18N
        jButton12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setText("Close");
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 80, 30));

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 80, 30));

        newbr.setBackground(new java.awt.Color(255, 255, 255));
        newbr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/NEW.PNG"))); // NOI18N
        newbr.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        newbr.setBorderPainted(false);
        newbr.setContentAreaFilled(false);
        newbr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newbr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newbrActionPerformed(evt);
            }
        });
        jPanel1.add(newbr, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 30, 30));

        cat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category" }));
        jPanel1.add(cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 120, 30));

        brand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Brand" }));
        brand.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                brandFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                brandFocusLost(evt);
            }
        });
        brand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                brandMouseClicked(evt);
            }
        });
        jPanel1.add(brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 120, 30));

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
        jPanel1.add(newcat, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 30, 30));

        newsup.setBackground(new java.awt.Color(255, 255, 255));
        newsup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/NEW.PNG"))); // NOI18N
        newsup.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        newsup.setBorderPainted(false);
        newsup.setContentAreaFilled(false);
        newsup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newsup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newsupActionPerformed(evt);
            }
        });
        jPanel1.add(newsup, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 30, 30));

        sup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Supplier" }));
        jPanel1.add(sup, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 120, 30));

        product.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                productFocusGained(evt);
            }
        });
        jPanel1.add(product, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 120, 30));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel2.setText("Product ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 60, 30));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel3.setText("Quantity");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 60, 30));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel4.setText("Price");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 60, 30));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel1.setText("Supplier");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 60, 30));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel6.setText("Brand");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 60, 30));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel5.setText("Category");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 60, 30));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel7.setText("NEW PRODUCT");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        price.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                priceFocusGained(evt);
            }
        });
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 120, 30));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 120, 30));

        quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                quantityFocusGained(evt);
            }
        });
        jPanel1.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 120, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void priceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_priceFocusGained
    setFormatPrice();        // TODO add your handling code here:
    defaultBorder();
    }//GEN-LAST:event_priceFocusGained

    private void quantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityFocusGained
    setFormatQuantity();
    defaultBorder();// TODO add your handling code here:
    }//GEN-LAST:event_quantityFocusGained

    private void brandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brandMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_brandMouseClicked

    private void brandFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brandFocusGained
    fillCategory();        // TODO add your handling code here:
    }//GEN-LAST:event_brandFocusGained

    private void brandFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brandFocusLost
    fillCategory();// TODO add your handling code here:
    }//GEN-LAST:event_brandFocusLost
    public void defaultBorder(){
        product.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        quantity.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        price.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        
    }
    public boolean checKDuplicate(String product,int supID,int brand){
        boolean confirm=false;
        
        PreparedStatement statement;     
        try {
                
                String st="SELECT productName FROM products";
                
                statement = connect.prepareStatement(st);
                ResultSet resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    if(resultSet.getString(1).equals(product)){
                        
                        String st1="SELECT sup_id FROM products where productName='"+product+"'";
                        statement = connect.prepareStatement(st1);
                        resultSet = statement.executeQuery();
                        
                        while(resultSet.next()){
                            if(resultSet.getString(1).equals(supID)){
                               
                                String st2="SELECT br_id FROM products where productName='"+product+"' and sup_id='"+supID+"'";
                                statement = connect.prepareStatement(st2);
                                resultSet = statement.executeQuery();
                                
                                if(resultSet.getString(1).equals(brand)){
                                    confirm=true;
                                }
                            }
                        }
                        
                    }
                    
            }
        
        } catch (SQLException ex) {
            printStackTrace();
        }
        
        
        
        
        
        return confirm;
    }
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
        if(isAnyRequiredFieldEmpty()==false){
            String product=this.product.getText();
        int price=Integer.parseInt(this.price.getText());        // TODO add your handling code here:
        int Quantity=Integer.parseInt(this.quantity.getText());
        String brand=(String)this.brand.getSelectedItem();
        String cat=(String)this.cat.getSelectedItem();
        String sup=(String)this.sup.getSelectedItem();
        
        System.out.println(brand);
        System.out.println(cat);
        System.out.println(sup);
        
        int supID=0;
        int brandID=0;
        int total=price*Quantity;
        int productID=0;
        PreparedStatement statement;     
        try {
                
                String st="SELECT sup_id FROM suppliers where supplierName='"+sup+"'";
                statement = connect.prepareStatement(st);
                ResultSet resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    supID=resultSet.getInt(1);
                }
                st="SELECT br_id FROM Brands where brandName='"+brand+"'";
                statement = connect.prepareStatement(st);
                resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    brandID=resultSet.getInt(1);
                }
                
                if(checKDuplicate(product, supID, brandID)==false){
                    
                
                try {
//                         
                       stmt = connect.createStatement();
                       stmt.executeUpdate("insert into Products(ProductName,quantity,price,category,sup_id,br_id) values('"+product+"','"+Quantity+"','"+price+"','"+cat+"','"+supID+"','"+brandID+"')");
   
                       } catch (SQLException ex) {
                           ex.printStackTrace();
                       }
                
                st="SELECT pr_id FROM Products where br_id='"+brandID+"' and sup_id='"+supID+"' and productName='"+product+"' and category='"+cat+"'";
                statement = connect.prepareStatement(st);
                resultSet = statement.executeQuery();
                
                while(resultSet.next()){
                    productID=resultSet.getInt(1);
                }
                
                 stmt = connect.createStatement();
                 stmt.executeUpdate("insert into c_"+cat+"(cproduct,pr_id) values('"+product+"','"+productID+"')");
               
                
                try {
                    
//                         
                       stmt = connect.createStatement();
                       stmt.executeUpdate("insert into SupTransaction(transactions,pr_id,category,sup_id) values('"+total+"','"+productID+"','"+cat+"','"+supID+"')");
   
                       } catch (SQLException ex) {
                           ex.printStackTrace();
                       }
                }else{
                    JOptionPane.showConfirmDialog(null, "Product already Registered");
                }
                
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        }else{
            product.setBorder(BorderFactory.createLineBorder(Color.red));
             quantity.setBorder(BorderFactory.createLineBorder(Color.red));
               price.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void productFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productFocusGained
    defaultBorder();        // TODO add your handling code here:
    }//GEN-LAST:event_productFocusGained

    private void newbrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbrActionPerformed
    newBrand br=new newBrand();
    br.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_newbrActionPerformed

    private void newcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newcatActionPerformed
      newCategory br=new newCategory();
    br.setVisible(true);  // TODO add your handling code here:
    }//GEN-LAST:event_newcatActionPerformed

    private void newsupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newsupActionPerformed
    newSupplier su=new newSupplier();
    su.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_newsupActionPerformed

   
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
            java.util.logging.Logger.getLogger(newProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JComboBox<String> brand;
    private javax.swing.JComboBox<String> cat;
    private javax.swing.JButton close;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton newbr;
    private javax.swing.JButton newcat;
    private javax.swing.JButton newsup;
    private javax.swing.JTextField price;
    private javax.swing.JTextField product;
    private javax.swing.JTextField quantity;
    private javax.swing.JComboBox<String> sup;
    // End of variables declaration//GEN-END:variables
}

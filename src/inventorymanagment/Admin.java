/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagment;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elate
 */
public class Admin extends javax.swing.JFrame {

    sqlDriverConn con=new sqlDriverConn();
    Connection connect=con.EstablishCon();
    PreparedStatement pstmt=null;
    Statement stmt = null;
    ResultSet res;
    public Admin() {
        initComponents();
        fillproducts();
        fillbrands();
        fillSupplier();
        fillCatCombo();
    }
    public void fillCatCombo(){
         int c;
       try {
           pstmt=connect.prepareStatement("SELECT * FROM INFORMATION_SCHEMA.TABLES");
           res=pstmt.executeQuery();
           catcom.removeAllItems();
           catcom.addItem("All");
           while(res.next()){
                
                   String cat=res.getString(3);
                   if(cat.substring(0, 2).equals("c_")){
                      catcom.addItem(cat.substring(2));
                   }   
           }
           
       } catch (SQLException ex) {
           printStackTrace();
       }
     }
    public void fillbrands(){
        try{
            
            int c;
            DefaultTableModel d;
            pstmt=connect.prepareStatement("select * from Brands");
            res=pstmt.executeQuery();
            
            
           ResultSetMetaData rsd = res.getMetaData();
           c=rsd.getColumnCount();
           d=(DefaultTableModel)brandTable.getModel();
           d.setRowCount(0);
           while(res.next()){
               Vector v2=new Vector(); 
               for(int i=1;i<=c;i++){
                   
                     v2.add(res.getString(1));  
                     v2.add(res.getString(2));  
                     v2.add(res.getString(3));  
                     v2.add(res.getString(4));  
                      
                      
                   
               }
               d.addRow(v2);
               
           }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void fillSupplier(){
        try{
            
            int c;
            DefaultTableModel d;
            pstmt=connect.prepareStatement("select * from Suppliers");
            res=pstmt.executeQuery();
            
            
           ResultSetMetaData rsd = res.getMetaData();
           c=rsd.getColumnCount();
           d=(DefaultTableModel)supplierTable.getModel();
           d.setRowCount(0);
           while(res.next()){
               Vector v2=new Vector(); 
               for(int i=1;i<=c;i++){
                   
                     v2.add(res.getString(1));  
                     v2.add(res.getString(2));  
                     v2.add(res.getString(3));    
                   
               }
               d.addRow(v2);
               
           }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void searchSupplier(){
        if(searchsup.getText().equals("")){
            fillSupplier();
        }else{
            try{
            
            int c;
            DefaultTableModel d;
            pstmt=connect.prepareStatement("select * from Suppliers where supplierName='"+searchsup.getText()+"'");
            res=pstmt.executeQuery();
            
            
           ResultSetMetaData rsd = res.getMetaData();
           c=rsd.getColumnCount();
           d=(DefaultTableModel)supplierTable.getModel();
           d.setRowCount(0);
           while(res.next()){
               Vector v2=new Vector(); 
               for(int i=1;i<=c;i++){
                   
                     v2.add(res.getString(1));  
                     v2.add(res.getString(2));  
                     v2.add(res.getString(3));    
                   
               }
               d.addRow(v2);
               
           }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        }
    }
    public void searchBrand(){
        if(searchbrand.getText().equals("")){
            fillbrands();
        }else{
            try{
            
            int c;
            DefaultTableModel d;
            pstmt=connect.prepareStatement("select * from Brands where brandName='"+searchbrand.getText()+"'");
            res=pstmt.executeQuery();
            
            
           ResultSetMetaData rsd = res.getMetaData();
           c=rsd.getColumnCount();
           d=(DefaultTableModel)brandTable.getModel();
           d.setRowCount(0);
           while(res.next()){
               Vector v2=new Vector(); 
               for(int i=1;i<=c;i++){
                   
                     v2.add(res.getString(1));  
                     v2.add(res.getString(2));  
                     v2.add(res.getString(3));    
                     v2.add(res.getString(4));    
                   
               }
               d.addRow(v2);
               
           }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        }
    }
    
    public void filterproducts(){
         if(catcom.getSelectedItem().equals("All")){
             fillproducts();
         }else{
             try{
                 System.out.println(catcom.getSelectedItem());
            int c;
            DefaultTableModel d;
            pstmt=connect.prepareStatement("select p.pr_id, p.productName,p.quantity,p.price,p.category,s.supplierName,b.brandName \n" +
"from Products p,Brands b,Suppliers s where p.sup_id=s.sup_id and p.br_id=b.br_id and p.category='"+catcom.getSelectedItem()+"'");
            res=pstmt.executeQuery();
            
            
           ResultSetMetaData rsd = res.getMetaData();
           c=rsd.getColumnCount();
           d=(DefaultTableModel)productTable.getModel();
           d.setRowCount(0);
           while(res.next()){
               Vector v2=new Vector(); 
               for(int i=1;i<=c;i++){
                   
                     v2.add(res.getString(1));  
                     v2.add(res.getString(2));  
                     v2.add(res.getString(3));  
                     v2.add(res.getString(4));  
                     v2.add(res.getString(5));  
                     v2.add(res.getString(7));  
                     v2.add(res.getString(6));  
                      
                   
               }
               d.addRow(v2);
               
           }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
         }
    }
    public void fillproducts(){
        try{
            
            int c;
            DefaultTableModel d;
            pstmt=connect.prepareStatement("select p.pr_id, p.productName,p.quantity,p.price,p.category,s.supplierName,b.brandName \n" +
"from Products p,Brands b,Suppliers s where p.sup_id=s.sup_id and p.br_id=b.br_id");
            res=pstmt.executeQuery();
            
            
           ResultSetMetaData rsd = res.getMetaData();
           c=rsd.getColumnCount();
           d=(DefaultTableModel)productTable.getModel();
           d.setRowCount(0);
           while(res.next()){
               Vector v2=new Vector(); 
               for(int i=1;i<=c;i++){
                   
                     v2.add(res.getString(1));  
                     v2.add(res.getString(2));  
                     v2.add(res.getString(3));  
                     v2.add(res.getString(4));  
                     v2.add(res.getString(5));  
                     v2.add(res.getString(7));  
                     v2.add(res.getString(6));  
                      
                   
               }
               d.addRow(v2);
               
           }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void searchproducts(){
       if(searchpr.getText().equals("")){
           
       }else{
            try{
            
            int c;
            DefaultTableModel d;
            pstmt=connect.prepareStatement("select p.pr_id, p.productName,p.quantity,p.price,p.category,s.supplierName,b.brandName \n" +
"from Products p,Brands b,Suppliers s where p.sup_id=s.sup_id and p.br_id=b.br_id and p.productName='"+searchpr.getText()+"'");
            res=pstmt.executeQuery();
            
            
           ResultSetMetaData rsd = res.getMetaData();
           c=rsd.getColumnCount();
           d=(DefaultTableModel)productTable.getModel();
           d.setRowCount(0);
           while(res.next()){
               Vector v2=new Vector(); 
               for(int i=1;i<=c;i++){
                   
                     v2.add(res.getString(1));  
                     v2.add(res.getString(2));  
                     v2.add(res.getString(3));  
                     v2.add(res.getString(4));  
                     v2.add(res.getString(5));  
                     v2.add(res.getString(7));  
                     v2.add(res.getString(6));  
                      
                   
               }
               d.addRow(v2);
               
           }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        supplierTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        brandTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        searchorder = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        searchsup = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        searchbrand = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        searchpr = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        catcom = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        searchcust = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        supplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Supplier ID", "Supplier ", "Supplier Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        supplierTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(supplierTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 291, 163));

        brandTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Brand ID", "Brand", "Product Category", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        brandTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(brandTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, 302, 163));

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product ", "Quantity", "Price", "Category", "Brand", "Supplier"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setViewportView(productTable);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 163));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane4.setViewportView(jTable4);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 294, 163));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "DOB", "Gender", "Address", "Phone no", "Username"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane5.setViewportView(jTable5);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 440, 163));
        getContentPane().add(searchorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 150, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/SEARCH.PNG"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 30, 30));

        searchsup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchsupActionPerformed(evt);
            }
        });
        getContentPane().add(searchsup, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 150, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/SEARCH.PNG"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 30, 30));

        searchbrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbrandActionPerformed(evt);
            }
        });
        getContentPane().add(searchbrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 150, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/SEARCH.PNG"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 360, 30, 30));
        getContentPane().add(searchpr, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, 30));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/SEARCH.PNG"))); // NOI18N
        jButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 30, 30));

        catcom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        catcom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                catcomItemStateChanged(evt);
            }
        });
        catcom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                catcomFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                catcomFocusLost(evt);
            }
        });
        catcom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catcomMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                catcomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                catcomMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                catcomMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                catcomMouseReleased(evt);
            }
        });
        catcom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catcomActionPerformed(evt);
            }
        });
        catcom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                catcomKeyPressed(evt);
            }
        });
        getContentPane().add(catcom, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 140, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 150, 30));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/SEARCH.PNG"))); // NOI18N
        jButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 30, 30));
        getContentPane().add(searchcust, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 110, 30));

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/NEW.PNG"))); // NOI18N
        jButton11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 360, 30, 30));

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/NEW.PNG"))); // NOI18N
        jButton12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 30, 30));

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figures/NEW.PNG"))); // NOI18N
        jButton13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 30, 30));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jLabel1.setText("Administration Operations");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel2.setText("Brands");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel3.setText("Products");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel4.setText("Customers");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel5.setText("Orders");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel6.setText("Suppliers");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchsupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchsupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchsupActionPerformed

    private void searchbrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbrandActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void catcomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_catcomFocusLost
          // TODO add your handling code here:
    }//GEN-LAST:event_catcomFocusLost

    private void catcomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_catcomFocusGained
           // TODO add your handling code here:
    }//GEN-LAST:event_catcomFocusGained

    private void catcomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catcomMouseClicked
//    filterproducts();        // TODO add your handling code here:
    }//GEN-LAST:event_catcomMouseClicked

    private void catcomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_catcomItemStateChanged
          // TODO add your handling code here:
    }//GEN-LAST:event_catcomItemStateChanged

    private void catcomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_catcomKeyPressed
       // TODO add your handling code here:
    }//GEN-LAST:event_catcomKeyPressed

    private void catcomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catcomMouseEntered
       // TODO add your handling code here:
    }//GEN-LAST:event_catcomMouseEntered

    private void catcomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catcomMouseExited
       // TODO add your handling code here:
    }//GEN-LAST:event_catcomMouseExited

    private void catcomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catcomMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_catcomMousePressed

    private void catcomMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catcomMouseReleased
       // TODO add your handling code here:
    }//GEN-LAST:event_catcomMouseReleased

    private void catcomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catcomActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_catcomActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    searchproducts();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
searchSupplier();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    searchBrand();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable brandTable;
    private javax.swing.JComboBox<String> catcom;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField searchbrand;
    private javax.swing.JTextField searchcust;
    private javax.swing.JTextField searchorder;
    private javax.swing.JTextField searchpr;
    private javax.swing.JTextField searchsup;
    private javax.swing.JTable supplierTable;
    // End of variables declaration//GEN-END:variables
}

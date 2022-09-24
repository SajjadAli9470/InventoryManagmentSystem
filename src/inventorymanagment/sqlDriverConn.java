
package inventorymanagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;




public class sqlDriverConn {


    public Connection EstablishCon(){
        Connection connection=null;
        String dburl="jdbc:sqlserver://DESKTOP-9NADN5T;databasename=inventorydb;IntegratedSecurity=true";
        try {
            
                connection=DriverManager.getConnection(dburl);
                System.out.println("Connection Established...");
                

            
        } catch (Exception e) {
            System.out.println("Connection Failed");
                e.printStackTrace();
        }
        return connection;
    }

      
    
} 


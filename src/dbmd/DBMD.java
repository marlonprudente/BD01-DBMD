package dbmd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marlon Prudente <marlonmateuspr@gmail.com>
 */
import java.sql.*;
import java.util.ArrayList;

public class DBMD {

    public static void main(String[] args) throws Exception{                    
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://100.43.1.76/livraria";
            String usuario = "root";
            String senha = "mpo121991";
            Connection con = DriverManager.getConnection(url, usuario, senha);
             DatabaseMetaData metadata = con.getMetaData();
            System.out.println("Driver: " + metadata.getDriverVersion());
            
            
        String table[] = {"TABLE"};
        ResultSet rs = null;
        ArrayList tables = null;
        rs = metadata.getTables(null, null, null, table);
        tables = new ArrayList();
        while(rs.next()){
            tables.add(rs.getString("TABLE_NAME"));
        }
        for(Object actualTable: tables){
            rs = metadata.getColumns(null, null, (String) actualTable, null);
            System.out.println(actualTable.toString().toUpperCase());
            while(rs.next()){
            System.out.println(rs.getString("COLUMN_NAME") +" "+ rs.getString("TYPE_NAME") +" "+ rs.getString("COLUMN_SIZE"));
        
        }
        }
        
    con.close();
    }    

public static ArrayList getTablesMetaData() throws SQLException{
        
    
    return null;           
        }

}

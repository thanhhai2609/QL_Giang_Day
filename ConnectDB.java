/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_java;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author DELL
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public Connection getConnection() throws ClassNotFoundException{
        Connection conn = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url ="jdbc:sqlserver://DESKTOP-ILSN9T4\\SQLEXPRESS:1433;databaseName=QLTK";
            String user = "sa";
            String pass = "12";
            conn = DriverManager.getConnection(url, user, pass);
            if(conn!=null){
                System.out.println("Connect sucessful!");
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return conn;
    }
}

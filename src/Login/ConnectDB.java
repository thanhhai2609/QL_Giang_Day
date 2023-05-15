
package Login;

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

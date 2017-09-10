package utils;



import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
    static final String driver = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://123.207.242.40:3306/flowonitor";
    static final String username = "root";
    static final String password = "root";
    public static Connection getCon(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection =  (Connection) DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}

package utils;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;

public class JDBCConnection {
    static final String driver = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/FlowMonitor";
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

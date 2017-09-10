package test;

import org.junit.Test;
import utils.JDBCConnection;

public class JDBCConnectTest {

    @Test
    public void testConntect(){
        if(JDBCConnection.getCon()!=null){
            System.out.println("连接数据库成功");
        }
    }
}

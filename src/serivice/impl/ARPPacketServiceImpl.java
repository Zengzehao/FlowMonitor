package serivice.impl;

import entity.ARPPacket;
import entity.ICMPPacket;
import serivice.ARPPacketService;
import serivice.ICMPPacketService;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class ARPPacketServiceImpl implements ARPPacketService {
    static Connection connection = JDBCConnection.getCon();
    Statement statement = null;
    ResultSet resultSet = null;

    @Override
    public void addARPPacket(ARPPacket arpPacket) throws Exception {
        statement = connection.createStatement();
        String sql = "INSERT INTO ARPPacket VALUES (null,"+arpPacket.getLength()+")";
        System.out.println(sql);
        //String sql = "INSERT INTO Protocol VALUES (null,'TCP',200)";
        int flag = statement.executeUpdate(sql);
        if(flag==1){
            System.out.println("插入数据库成功！");
        }else {
            System.out.println("插入数据库失败！");
        }
    }

    @Override
    public HashMap<String, Object> queryARPPacketAndCount() throws Exception {
        statement = connection.createStatement();
        String sql = "SELECT count(1) count FROM ARPPacket";
        ResultSet result = statement.executeQuery(sql);
        int count =0;
        HashMap<String,Object> res = new HashMap<>();
        while (result.next()){
            count = result.getInt("count");
        }
        res.put("ARP",count);
        return res;
    }

    @Override
    public HashMap<String, Object> queryAllLength() throws Exception {
        statement = connection.createStatement();
        String sql = "SELECT sum(length) sum FROM ARPPacket";
        ResultSet result = statement.executeQuery(sql);
        int sum =0;
        HashMap<String,Object> res = new HashMap<>();
        while (result.next()){
            sum = result.getInt("sum");
        }
        res.put("ARP",sum);
        return res;
    }

    @Override
    public void deleteAll() throws Exception {
        statement = connection.createStatement();
        String sql = "DELETE FROM ARPPacket ";
        statement.executeUpdate(sql);
    }
}

package serivice.impl;

import entity.ICMPPacket;
import serivice.ICMPPacketService;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class ICMPPacketServiceImpl implements ICMPPacketService {
    static Connection connection = JDBCConnection.getCon();
    Statement statement = null;
    ResultSet resultSet = null;
    @Override
    public void addICMPPacket(ICMPPacket icmpPacket) throws Exception {
        statement = connection.createStatement();
        String sql = "INSERT INTO ICMPPacket VALUES (null,"+icmpPacket.getLength()+")";
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
    public HashMap<String, Object> queryICMPPacketAndCount() throws Exception {
        statement = connection.createStatement();
        String sql = "SELECT count(1) count FROM ICMPPacket";
        ResultSet result = statement.executeQuery(sql);
        int count =0;
        HashMap<String,Object> res = new HashMap<>();
        while (result.next()){
            count = result.getInt("count");
        }
        res.put("ICMP",count);
        return res;
    }

    @Override
    public HashMap<String, Object> queryAllLength() throws Exception {
        statement = connection.createStatement();
        String sql = "SELECT sum(length) sum FROM ICMPPacket";
        ResultSet result = statement.executeQuery(sql);
        int sum =0;
        HashMap<String,Object> res = new HashMap<>();
        while (result.next()){
            sum = result.getInt("sum");
        }
        res.put("ICMP",sum);
        return res;
    }

    @Override
    public void deleteAll() throws Exception {
        statement = connection.createStatement();
        String sql = "DELETE FROM ICMPPacket ";
        statement.executeUpdate(sql);
    }
}

package serivice.impl;

import entity.TCPPacket;
import entity.UDPPacket;
import serivice.TCPPacketService;
import serivice.UDPPacketService;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class UDPPacketServiceImpl implements UDPPacketService {
    static Connection connection = JDBCConnection.getCon();
    Statement statement = null;
    ResultSet resultSet = null;

    @Override
    public void addTCPPacket(UDPPacket udpPacket) throws Exception {
        statement = connection.createStatement();
        String sql = "INSERT INTO UDPPacket VALUES (null,"+udpPacket.getSrc_port()+","+udpPacket.getDst_port()+","+udpPacket.getLength()+")";
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
    public HashMap<String, Object> queryUDPPacketAndCount() throws Exception {
        statement = connection.createStatement();
        String sql = "SELECT count(1) count FROM UDPPacket";
        ResultSet result = statement.executeQuery(sql);
        int count =0;
        HashMap<String,Object> res = new HashMap<>();
        while (result.next()){
            count = result.getInt("count");
        }
        res.put("UDP",count);
        return res;
    }

    @Override
    public HashMap<String, Object> queryAllLength() throws Exception {
        statement = connection.createStatement();
        String sql = "SELECT sum(length) sum FROM UDPPacket";
        ResultSet result = statement.executeQuery(sql);
        int sum =0;
        HashMap<String,Object> res = new HashMap<>();
        while (result.next()){
            sum = result.getInt("sum");
        }
        res.put("UDP",sum);
        return res;
    }

    @Override
    public void deleteAll() throws Exception {
        statement = connection.createStatement();
        String sql = "DELETE FROM UDPPacket ";
        statement.executeUpdate(sql);
    }

}

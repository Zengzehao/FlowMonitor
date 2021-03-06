package serivice.impl;

import entity.Protocol;
import entity.TCPPacket;
import serivice.TCPPacketService;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TCPPacketServiceImpl implements TCPPacketService {
    static Connection connection = JDBCConnection.getCon();
    Statement statement = null;
    ResultSet resultSet = null;
    @Override
    public void addTCPPacket(TCPPacket tcpPacket) throws Exception {
        statement = connection.createStatement();
        String sql = "INSERT INTO TCPPacket VALUES (null,"+tcpPacket.getSrc_port()+","+tcpPacket.getDst_port()+","+tcpPacket.getLength()+")";
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
    public HashMap<String, Object> queryTCPPacketAndCount() throws Exception {
        statement = connection.createStatement();
        String sql = "SELECT count(1) count FROM TCPPacket";
        ResultSet result = statement.executeQuery(sql);
        int count =0;
        HashMap<String,Object> res = new HashMap<>();
        while (result.next()){
            count = result.getInt("count");
        }
        res.put("TCP",count);
        return res;
    }

    @Override
    public HashMap<String, Object> queryAllLength() throws Exception {
        statement = connection.createStatement();
        String sql = "SELECT sum(length) sum FROM TCPPacket";
        ResultSet result = statement.executeQuery(sql);
        int sum =0;
        HashMap<String,Object> res = new HashMap<>();
        while (result.next()){
            sum = result.getInt("sum");
        }
        res.put("TCP",sum);
        return res;
    }

    @Override
    public void deleteAll() throws Exception {
        statement = connection.createStatement();
        String sql = "DELETE FROM TCPPacket ";
        statement.executeUpdate(sql);
    }
}

package serivice.impl;


import entity.Protocol;
import serivice.ProtocalService;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProtocalServiceImpl implements ProtocalService {

    static Connection connection = JDBCConnection.getCon();
    Statement statement = null;
    ResultSet resultSet = null;
    @Override
    public void addProtocal(Protocol protocol) throws Exception{
        statement = connection.createStatement();
        String sql = "INSERT INTO Protocol VALUES (null,"+"\""+protocol.getProtocolType()+"\""+","+protocol.getCount()+")";
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
    public List<Protocol> queryAllProtocal() throws Exception{
        statement = connection.createStatement();
        String sql = "SELECT * FROM Protocol";
        List<Protocol> protocols = new ArrayList<>();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            Protocol protocol = new Protocol();
            protocol.setId(result.getLong("id"));
            protocol.setProtocolType(result.getString("protocol"));
            protocol.setCount(result.getLong("count"));
            protocols.add(protocol);
        }
        return protocols;
    }
}

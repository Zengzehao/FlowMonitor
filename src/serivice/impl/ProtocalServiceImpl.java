package serivice.impl;


import entity.Protocol;
import serivice.ProtocalService;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ProtocalServiceImpl implements ProtocalService {

    static Connection connection = JDBCConnection.getCon();
    Statement statement = null;
    ResultSet resultSet = null;
    @Override
    public void addProtocal(Protocol protocol) throws Exception{
        statement = connection.createStatement();
        Boolean flag = statement.execute("INSERT INTO IpAddress VALUES ("+protocol.getProtocolType()+","+protocol.getCount()+")");
        if(flag){
            System.out.println("插入数据库与成功！");
        }else{
            System.out.println("插入数据库与成功！");
        }
    }

    @Override
    public List<Protocol> queryAllProtocal() throws Exception{
        statement = connection.createStatement();

        return null;
    }
}

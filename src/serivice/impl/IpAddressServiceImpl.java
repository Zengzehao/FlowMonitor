package serivice.impl;

import entity.IpAddress;
import entity.Protocol;
import serivice.IpAddressService;
import utils.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IpAddressServiceImpl implements IpAddressService {
    static Connection connection = JDBCConnection.getCon();
    Statement statement = null;
    ResultSet resultSet = null;
    @Override
    public void addIpAddress(IpAddress ipAddress) throws Exception{
        statement = connection.createStatement();
        String sql = "INSERT INTO IpAddress VALUES (null,"+"\""+ipAddress.getIpAddress()+"\""+","+ipAddress.getCount()+")";
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
    public List<IpAddress> queryAllIpAddress() throws Exception{
        statement = connection.createStatement();
        String sql = "SELECT * FROM IpAddress";
        List<IpAddress> ipAddresses = new ArrayList<>();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            IpAddress ipAddress = new IpAddress();
            ipAddress.setCount(result.getLong("id"));
            ipAddress.setIpAddress(result.getString("ipaddress"));
            ipAddress.setCount(result.getLong("count"));
            ipAddresses.add(ipAddress);
        }
        return ipAddresses;
    }
}

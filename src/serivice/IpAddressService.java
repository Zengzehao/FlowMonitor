package serivice;

import entity.IpAddress;

import java.util.List;

public interface IpAddressService {
    public void addIpAddress(IpAddress ipAddress) throws Exception;  //增加
    public List<IpAddress> queryAllIpAddress() throws Exception;    //查询所有IP地址
}

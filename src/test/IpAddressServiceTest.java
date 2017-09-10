package test;

import entity.IpAddress;
import org.junit.Before;
import org.junit.Test;
import serivice.IpAddressService;
import serivice.impl.IpAddressServiceImpl;

import java.util.List;

public class IpAddressServiceTest {
    IpAddressService service = null;
    @Before
    public void before(){
        service = new IpAddressServiceImpl();
    }
    @Test
    public void testInsert() throws Exception{
        IpAddress ipAddress = new IpAddress();
        ipAddress.setIpAddress("172.0.0.1");
        ipAddress.setCount(100L);
        service.addIpAddress(ipAddress);
    }

    @Test
    public void testQueryAll() throws Exception{
        List<IpAddress> ipAddresses = service.queryAllIpAddress();
        for (IpAddress ipAddress:ipAddresses){
            System.out.println(ipAddress);
        }
    }
}

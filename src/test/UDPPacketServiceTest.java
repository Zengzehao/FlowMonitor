package test;

import entity.TCPPacket;
import entity.UDPPacket;
import org.junit.Before;
import org.junit.Test;
import serivice.TCPPacketService;
import serivice.UDPPacketService;
import serivice.impl.TCPPacketServiceImpl;
import serivice.impl.UDPPacketServiceImpl;

import java.util.HashMap;

public class UDPPacketServiceTest {
    UDPPacketService service = null;
    @Before
    public void bofore(){
        service = new UDPPacketServiceImpl();
    }

    @Test
    public void testInsert() throws Exception{
        UDPPacket udpPacket = new UDPPacket();
        udpPacket.setDst_port(123);
        udpPacket.setSrc_port(345);
        udpPacket.setLength(100);
        service.addTCPPacket(udpPacket);
    }

    @Test
    public void testQueryAll() throws Exception{
        HashMap<String,Object> res = service.queryUDPPacketAndCount();
        System.out.println(res.get("UDP"));
    }

    @Test
    public void testAllLength() throws Exception{
        HashMap<String,Object> res = service.queryAllLength();
        System.out.println(res.get("UDP"));
    }
}

package test;

import entity.ARPPacket;
import entity.ICMPPacket;
import org.junit.Before;
import org.junit.Test;
import serivice.ARPPacketService;
import serivice.ICMPPacketService;
import serivice.impl.ARPPacketServiceImpl;
import serivice.impl.ICMPPacketServiceImpl;

import java.util.HashMap;

public class ARPPacketServiceTest {
    ARPPacketService service = null;
    @Before
    public void bofore(){
        service = new ARPPacketServiceImpl();
    }

    @Test
    public void testInsert() throws Exception{
        ARPPacket arpPacket = new ARPPacket();
        arpPacket.setLength(100);
        service.addARPPacket(arpPacket);
    }

    @Test
    public void testQueryAll() throws Exception{
        HashMap<String,Object> res = service.queryARPPacketAndCount();
        System.out.println(res.get("ARP"));
    }

    @Test
    public void testAllLength() throws Exception{
        HashMap<String,Object> res = service.queryAllLength();
        System.out.println(res.get("ARP"));
    }
}

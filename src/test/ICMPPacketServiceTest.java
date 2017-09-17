package test;

import entity.ICMPPacket;
import entity.UDPPacket;
import org.junit.Before;
import org.junit.Test;
import serivice.ICMPPacketService;
import serivice.UDPPacketService;
import serivice.impl.ICMPPacketServiceImpl;
import serivice.impl.UDPPacketServiceImpl;

import java.util.HashMap;

public class ICMPPacketServiceTest {
    ICMPPacketService service = null;
    @Before
    public void bofore(){
        service = new ICMPPacketServiceImpl();
    }

    @Test
    public void testInsert() throws Exception{
        ICMPPacket icmpPacket = new ICMPPacket();
        icmpPacket.setLength(100);
        service.addICMPPacket(icmpPacket);
    }

    @Test
    public void testQueryAll() throws Exception{
        HashMap<String,Object> res = service.queryICMPPacketAndCount();
        System.out.println(res.get("ICMP"));
    }

    @Test
    public void testAllLength() throws Exception{
        HashMap<String,Object> res = service.queryAllLength();
        System.out.println(res.get("ICMP"));
    }
}

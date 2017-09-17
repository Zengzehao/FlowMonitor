package test;

import entity.Protocol;
import entity.TCPPacket;
import org.junit.Before;
import org.junit.Test;
import serivice.ProtocalService;
import serivice.TCPPacketService;
import serivice.impl.ProtocalServiceImpl;
import serivice.impl.TCPPacketServiceImpl;

import java.util.HashMap;
import java.util.List;

public class TCPPacketServiceTest {
    TCPPacketService service = null;
    @Before
    public void bofore(){
        service = new TCPPacketServiceImpl();
    }

    @Test
    public void testInsert() throws Exception{
        TCPPacket tcpPacket = new TCPPacket();
        tcpPacket.setDst_port(123);
        tcpPacket.setSrc_port(345);
        tcpPacket.setLength(100);
        service.addTCPPacket(tcpPacket);
    }

    @Test
    public void testQueryAll() throws Exception{
        HashMap<String,Object> res = service.queryTCPPacketAndCount();
        System.out.println(res.get("TCP"));
    }

    @Test
    public void testAllLength() throws Exception{
        HashMap<String,Object> res = service.queryAllLength();
        System.out.println(res.get("TCP"));
    }

    @Test
    public void testDeleteAll() throws Exception{
        service.deleteAll();
    }
}

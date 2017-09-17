package serivice.impl;

import serivice.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TotalSericeImpl implements TotalService {
    TCPPacketService tcpPacketService = new TCPPacketServiceImpl();
    UDPPacketService udpPacketService = new UDPPacketServiceImpl();
    ICMPPacketService icmpPacketService = new ICMPPacketServiceImpl();
    ARPPacketService arpPacketService = new ARPPacketServiceImpl();
    @Override
    public List<HashMap<String, Object>> queryCount() throws Exception{
        List<HashMap<String,Object>> list = new ArrayList<>();
        list.add(tcpPacketService.queryTCPPacketAndCount());
        list.add(udpPacketService.queryUDPPacketAndCount());
        list.add(icmpPacketService.queryICMPPacketAndCount());
        list.add(arpPacketService.queryARPPacketAndCount());
        return list;
    }

    @Override
    public List<HashMap<String, Object>> queryLength() throws Exception {
        List<HashMap<String,Object>> list = new ArrayList<>();
        list.add(tcpPacketService.queryAllLength());
        list.add(udpPacketService.queryAllLength());
        list.add(icmpPacketService.queryAllLength());
        list.add(arpPacketService.queryAllLength());
        return list;
    }

    @Override
    public void deleteAll() throws Exception {
        tcpPacketService.deleteAll();
        udpPacketService.deleteAll();
        icmpPacketService.deleteAll();
        arpPacketService.deleteAll();
    }
}

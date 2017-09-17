package serivice;

import entity.TCPPacket;
import entity.UDPPacket;

import java.util.HashMap;

public interface UDPPacketService {
    public void addTCPPacket(UDPPacket udpPacket) throws Exception;  //增加
    public HashMap<String,Object> queryUDPPacketAndCount() throws Exception;  //查询所有
    public HashMap<String,Object> queryAllLength() throws Exception; //计算长度
    public void deleteAll() throws Exception; //删除所有记录
}

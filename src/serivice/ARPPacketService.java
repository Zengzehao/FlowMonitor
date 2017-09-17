package serivice;

import entity.ARPPacket;
import entity.ICMPPacket;

import java.util.HashMap;

public interface ARPPacketService {
    public void addARPPacket(ARPPacket arpPacket) throws Exception;  //增加
    public HashMap<String,Object> queryARPPacketAndCount() throws Exception;  //查询所有
    public HashMap<String,Object> queryAllLength() throws Exception; //计算长度
    public void deleteAll() throws Exception; //删除所有记录
}

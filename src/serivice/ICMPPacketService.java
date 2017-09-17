package serivice;

import entity.ICMPPacket;

import java.util.HashMap;

public interface ICMPPacketService {
    public void addICMPPacket(ICMPPacket icmpPacket) throws Exception;  //增加
    public HashMap<String,Object> queryICMPPacketAndCount() throws Exception;  //查询所有
    public HashMap<String,Object> queryAllLength() throws Exception; //计算长度
    public void deleteAll() throws Exception; //删除所有记录
}

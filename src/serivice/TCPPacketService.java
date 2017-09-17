package serivice;

import entity.Protocol;
import entity.TCPPacket;

import java.util.HashMap;
import java.util.List;

public interface TCPPacketService {
    public void addTCPPacket(TCPPacket tcpPacket) throws Exception;  //增加
    public HashMap<String,Object> queryTCPPacketAndCount() throws Exception;  //查询所有
    public HashMap<String,Object> queryAllLength() throws Exception; //计算长度
    public void deleteAll() throws Exception; //删除所有记录
}

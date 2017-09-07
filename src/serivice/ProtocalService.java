package serivice;

import entity.Protocol;

import java.util.List;

public interface ProtocalService {
    public void addProtocal(Protocol protocol) throws Exception;  //增加
    public List<Protocol> queryAllProtocal() throws Exception;  //查询所有
}

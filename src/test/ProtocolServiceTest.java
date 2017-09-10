package test;

import entity.Protocol;
import org.junit.Before;
import org.junit.Test;
import serivice.ProtocalService;
import serivice.impl.ProtocalServiceImpl;

import java.util.List;

public class ProtocolServiceTest {
    ProtocalService service = null;
    @Before
    public void bofore(){
        service = new ProtocalServiceImpl();
    }

    @Test
    public void testInsert() throws Exception{
        Protocol protocol = new Protocol();
        protocol.setProtocolType("TCP");
        protocol.setCount(200L);
        service.addProtocal(protocol);
    }

    @Test
    public void testQueryAll() throws Exception{
        List<Protocol> protocols = service.queryAllProtocal();
        for(Protocol protocol:protocols){
            System.out.println(protocol);
        }
    }
}

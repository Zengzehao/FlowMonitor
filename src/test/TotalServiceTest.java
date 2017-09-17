package test;

import org.junit.Before;
import org.junit.Test;
import serivice.TotalService;
import serivice.impl.TotalSericeImpl;

import java.util.HashMap;
import java.util.List;

public class TotalServiceTest {
    TotalService service = null;
    @Before
    public void bofore(){
        service = new TotalSericeImpl();
    }

    @Test
    public void testCount() throws Exception{
        List<HashMap<String,Object>> list = service.queryCount();
        for(HashMap<String,Object> map:list){
            System.out.println(map);
        }
    }


    @Test
    public void testAllLength() throws Exception{
        List<HashMap<String,Object>> list = service.queryLength();
        for(HashMap<String,Object> map:list){
            System.out.println(map);
        }
    }

    @Test
    public void testDeleteAll() throws Exception{
        service.deleteAll();
    }
}

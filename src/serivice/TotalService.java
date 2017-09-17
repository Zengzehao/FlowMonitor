package serivice;

import java.util.HashMap;
import java.util.List;

public interface TotalService {
    public List<HashMap<String,Object>> queryCount() throws Exception;
    public List<HashMap<String,Object>> queryLength() throws Exception;
    public void deleteAll() throws Exception; //删除所有记录
}

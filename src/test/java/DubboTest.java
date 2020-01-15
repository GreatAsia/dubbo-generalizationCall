import com.noriental.moco.DubboServiceFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DubboTest {

    @Test
    public void test() {

        DubboServiceFactory dubbo = DubboServiceFactory.getInstance();

        Map map = new HashMap<String, Object>();
        map.put("ParamType", "long");  //后端接口参数类型
        //用以调用后端接口的实参

        Map<String, Object> getDataRequest = new HashMap<String, Object>();
        getDataRequest.put("", "1");
        map.put("Object", getDataRequest);

        List<Map<String, Object>> paramInfos = new ArrayList<Map<String, Object>>();
        paramInfos.add(map);

        Object result = dubbo.genericInvoke("com.noriental.productsvr.product.service.ProductService", "getProductById", paramInfos);

        System.out.println("result===" + result);


    }


    @Test
    public void test1() {

        DubboServiceFactory dubbo1 = DubboServiceFactory.getInstance();

        Map map = new HashMap<String, Object>();
        map.put("ParamType", "com.noriental.usersvr.bean.request.SchoolRequest");  //后端接口参数类型
        //用以调用后端接口的实参

        Map<String, Object> getDataRequest = new HashMap<String, Object>();
        getDataRequest.put("orgId", "119");
        getDataRequest.put("orgType", "2");
//        getDataRequest.put("name", "abc");
        getDataRequest.put("reqId", "123456789");
        map.put("Object", getDataRequest);

        List<Map<String, Object>> paramInfos = new ArrayList<Map<String, Object>>();
        paramInfos.add(map);
        System.out.println("paramInfos:" + paramInfos);
        Object result = dubbo1.genericInvoke("com.noriental.usersvr.service.okuser.SchoolYearService", "findFutureYear", paramInfos);

        System.out.println("result===" + result);


    }
}

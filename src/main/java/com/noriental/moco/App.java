package com.noriental.moco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pengjun on 16/11/7.
 */
public class App {

    public static void main(String[] args) {
        DubboServiceFactory dubbo = DubboServiceFactory.getInstance();

        Map map = new HashMap<String, Object>();
        map.put("ParamType", "com.noriental.usersvr.bean.request.SchoolRequest");  //后端接口参数类型
         //用以调用后端接口的实参

        Map<String, Object> getDataRequest = new HashMap<String, Object>();
        getDataRequest.put("orgId", "119");
        getDataRequest.put("orgType","2");
//        getDataRequest.put("name", "abc");
        getDataRequest.put("reqId","123456789");
        map.put("Object", getDataRequest);

        List<Map<String, Object>> paramInfos= new ArrayList<Map<String, Object>>();
        paramInfos.add(map);
        System.out.println("上行参数==="+paramInfos);
        Object result =  dubbo.genericInvoke("com.noriental.usersvr.service.okuser.SchoolYearService", "findFutureYear", paramInfos);

        System.out.println("result==="+result);

    }
}

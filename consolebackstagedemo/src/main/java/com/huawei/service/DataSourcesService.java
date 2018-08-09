package com.huawei.service;

import com.alibaba.fastjson.JSONObject;
import com.huawei.Utils.CommonUtils;
import com.huawei.Utils.JSONAnalysis;
import com.huawei.bean.ManagerServicesConfigBean;
import com.huawei.projo.Goods;
import com.huawei.projo.Orders;
import com.huawei.projo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("dataSourcesService")
public class DataSourcesService {

    @Autowired
    private ManagerServicesConfigBean managerServicesConfigBean;

    @Autowired
    private HttpClientService httpClientService;

    public List<Goods> getNorMalGoodsList(){
        String url = managerServicesConfigBean.getGoodsListMethodUrl(CommonUtils.GOODS_TYPE_NORMAL);
        JSONObject resultJson = httpClientService.getDataFromManagerServices(url,HttpClientService.GET_Method_TYPE);
        return JSONAnalysis.analysisGoodsList(resultJson);
    }
    public Goods getRushToBuyGoodsList(){
        String url = managerServicesConfigBean.getGoodsListMethodUrl(CommonUtils.GOODS_TYPE_RUSH_TO_BUY);
        JSONObject resultJson = httpClientService.getDataFromManagerServices(url,HttpClientService.GET_Method_TYPE);
        return JSONAnalysis.analysisRushToBuyGoodsList(resultJson);
    }

    public Goods getGoodsDetail(String goodsId,String goodsType){
        String url = managerServicesConfigBean.getGoodsDetailMethodUrl(goodsId,goodsType);
        JSONObject resultJson = httpClientService.getDataFromManagerServices(url,HttpClientService.GET_Method_TYPE);
        return JSONAnalysis.analysisGoodsDetail(resultJson);
    }

    public List<User> addUser(String userNum){
        List<User> userList = new LinkedList<>();
        for (int i=0;i<Integer.parseInt(userNum);i++){
            String userName = String.valueOf(i);
            String userPwd = String.valueOf(i);
            String url=managerServicesConfigBean.getAddUserMethodUrl();
            Map<String,Object>  map = new HashMap<>();
            map.put("userName",userName);
            map.put("userPwd",userPwd);
            JSONObject resultJson = httpClientService.getDataFromManagerServices(url,map,HttpClientService.POST_Method_TYPE);
            User user = JSONAnalysis.analysisSimpleUserForSignUp(resultJson);
            userList.add(user);
            }
            return  userList;
    }
}


package com.huawei;

import com.huawei.Utils.CommonUtils;
import com.huawei.bean.ManagerServicesConfigBean;
import com.huawei.projo.Goods;
import com.huawei.projo.User;
import com.huawei.service.DataSourcesService;
import com.huawei.service.HttpClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/*.xml"})
public class DemoTest {

    @Autowired
    private ManagerServicesConfigBean managerServicesConfigBean;

    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    DataSourcesService dataSourcesService;


    @Test
    public void goodsTest(){
        List<Goods> goods = dataSourcesService.getNorMalGoodsList();
        System.out.println(goods.toString());
    }
    @Test
    public void goodsDetailTest(){
        long goodsId = 1;
        String goodsType = CommonUtils.GOODS_TYPE_NORMAL;
        Goods goods = dataSourcesService.getGoodsDetail(String.valueOf(goodsId),goodsType);
        System.out.println(goods.toString());
    }

    @Test
    public void addUser(){
        String userNum = "15";
        List<User> userList=dataSourcesService.addUser(userNum);
        System.out.println(userList.toString());
    }
}

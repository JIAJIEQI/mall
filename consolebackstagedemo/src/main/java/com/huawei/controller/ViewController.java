package com.huawei.controller;

import com.huawei.Utils.CommonUtils;
import com.huawei.projo.Goods;
import com.huawei.projo.Orders;
import com.huawei.projo.User;
import com.huawei.service.DataSourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ViewController {
    @Autowired
    DataSourcesService dataSourcesService;


    @RequestMapping(value = "mall",method = RequestMethod.GET)
    @ResponseBody
    public String mall(HttpServletRequest request){
        List<Goods> goodsList = dataSourcesService.getNorMalGoodsList();
        return  goodsList.toString();
    }


    @RequestMapping(value = "goodsDetail",method = RequestMethod.GET)
    @ResponseBody
    public String normalgoodsDetail(HttpServletRequest request){
        String goodsId = request.getParameter("goodsId");
        String goodsType = CommonUtils.GOODS_TYPE_NORMAL;
        Goods goods = dataSourcesService.getGoodsDetail(goodsId,goodsType);
        return  goods.toString();

    }

    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    @ResponseBody
    public String addUser(HttpServletRequest request){
        String userNum = request.getParameter("usernum");
        if (Integer.parseInt(userNum)>0){
            List<User> userList=dataSourcesService.addUser(userNum);
            return  userList.toString();
    }
    else {
            return  "failed";
        }
    }


}

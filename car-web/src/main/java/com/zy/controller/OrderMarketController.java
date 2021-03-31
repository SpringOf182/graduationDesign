package com.zy.controller;

import com.alibaba.fastjson.JSONObject;
import com.zy.entity.Order;
import com.zy.service.OrderService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Order控制器.
 * @author Ying
 */
@RestController
@Slf4j
public class OrderMarketController{

    /**
     * 业务服务接口对象.
     */
    @Autowired
    @Setter
    private OrderService orderService;

    @RequestMapping(path = "/OrderMarket",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject orderMarket(){
        JSONObject jsonObject = new JSONObject();

        List<Order> orderList = orderService.queryNotAcceptedOrder();
        jsonObject.put("orderList", orderList);
        //   jsonObject.put("params", params);
        if (orderList!= null) {
            jsonObject.put("Result", "success");
        } else {
            jsonObject.put("Result", "failed");
        }
        return jsonObject;
    }

    @RequestMapping(path = "/OrderSelect",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject OrderSelect(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();

        String pickUp = request.getParameter("pickUp").trim();
        String delivery = request.getParameter("delivery").trim();
        String company = request.getParameter("company").trim();
        if("请选择".equals(pickUp)) {
            pickUp = "%";
        }
        if("请选择".equals(delivery)) {
            delivery = "%";
        }
        if("请选择".equals(company)) {
            company = "%";
        }
        List<Order> orderList = orderService.querySelectedOrder(pickUp, delivery, company);
        jsonObject.put("orderList", orderList);
        //   jsonObject.put("params", params);
        if (orderList!= null) {
            jsonObject.put("Result", "success");
        } else {
            jsonObject.put("Result", "failed");
        }
        return jsonObject;
    }
}

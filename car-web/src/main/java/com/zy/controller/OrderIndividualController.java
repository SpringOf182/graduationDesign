package com.zy.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.zy.service.OrderService;
import com.zy.entity.Order;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Order控制器.
 * @author Ying
 */
@RestController
@Slf4j
public class OrderIndividualController {

    /**
     * 业务服务接口对象.
     */
    @Autowired
    @Setter
    private OrderService orderService;

    @RequestMapping(path = "/ShowUserAcceptOrder",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject showUserAcceptOrder(HttpServletRequest request){
        String recipentUID = request.getParameter("recipentUID");
        //   	Map<String, JSONArray> params = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        List<Order> orderList = orderService.queryUserAcceptOrder(recipentUID);
        jsonObject.put("orderList", orderList);
        if (orderList != null) {
            jsonObject.put("Result", "success");
        } else {
            jsonObject.put("Result", "failed");
        }
        return jsonObject;
    }

    @RequestMapping(path = "/ShowUserPublishOrder",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject showUserPublishOrder(HttpServletRequest request){
        String UID = request.getParameter("UID");
        //	Map<String, JSONArray> params = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        List<Order>  orderList = orderService.queryUserPublishOrder(UID);
        jsonObject.put("orderList", orderList);
        if (orderList != null) {
            jsonObject.put("Result", "success");
        } else {
            jsonObject.put("Result", "failed");
        }
        return jsonObject;
    }

}
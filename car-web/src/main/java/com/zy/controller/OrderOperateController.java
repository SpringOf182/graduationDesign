package com.zy.controller;

import com.alibaba.fastjson.JSONObject;
import com.zy.entity.Order;
import com.zy.service.OrderService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Ying
 */
public class OrderOperateController {

    /**
     * 业务服务接口对象.
     */
    @Autowired
    @Setter
    private OrderService orderService;

    @RequestMapping(path = "/PublishOrder",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject publishOrder(HttpServletRequest request) throws ParseException {
        Order order = new Order();
        order.setUid(request.getParameter("UID").trim());
        order.setPickUp(request.getParameter("pickUp").trim());
        order.setDelivery(request.getParameter("delivery").trim());
        order.setCompany(request.getParameter("company").trim());
        order.setPrice(Double.parseDouble(request.getParameter("price")));
        order.setWeight(Double.parseDouble(request.getParameter("weight")));
        order.setVerificationCode(request.getParameter("verificationCode").trim());
        order.setContactNumber(request.getParameter("contactNumber").trim());
        order.setMemo(request.getParameter("memo").trim());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = request.getParameter("latestTime").trim();
        Date date = simpleDateFormat.parse(dateStr);
        order.setLatestTime(date);

        JSONObject jsonObject = new JSONObject();

        if (orderService.insertOrder(order)) {
            jsonObject.put("Result", "success");
        } else {
            jsonObject.put("Result", "failed");
        }
        return jsonObject;
    }

    @RequestMapping(path = "/AcceptOrder",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject acceptOrder(HttpServletRequest request){
        Order order = new Order();
        order.setOid(Integer.parseInt(request.getParameter("OID").trim()));
        order.setRecipentUid(request.getParameter("recipentUID").trim());
        order.setRecipentPhoneNumber(request.getParameter("recipentPhoneNumber").trim());

        //Map<String, String> params = new HashMap<>();
        JSONObject jsonObject = new JSONObject();

        if (orderService.changeOrderState(order)) {
            jsonObject.put("Result", "success");
        } else {
            jsonObject.put("Result", "failed");
        }
        return jsonObject;
    }

    @RequestMapping(path = "/CancelOrder",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject cancelOrder(HttpServletRequest request){
        Order order = new Order();
        order.setOid(Integer.parseInt(request.getParameter("OID").trim()));
        order.setState(0);

        //Map<String, String> params = new HashMap<>();
        JSONObject jsonObject = new JSONObject();

        if (orderService.changeOrderState(order)) {
            jsonObject.put("Result", "success");
        } else {
            jsonObject.put("Result", "failed");
        }
        return jsonObject;
    }

    @RequestMapping(path = "/FinishOrder",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject finishOrder(HttpServletRequest request){
        Order order = new Order();
        order.setOid(Integer.parseInt(request.getParameter("OID").trim()));
        order.setState(2);

        //Map<String, String> params = new HashMap<>();
        JSONObject jsonObject = new JSONObject();

        if (orderService.changeOrderState(order)) {
            jsonObject.put("Result", "success");
        } else {
            jsonObject.put("Result", "failed");
        }
        return jsonObject;
    }
}

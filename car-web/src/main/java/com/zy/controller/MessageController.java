package com.zy.controller;

import com.alibaba.fastjson.JSONObject;
import com.zy.entity.MessageList;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.zy.service.MessageService;
import com.zy.entity.Message;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Message控制器.
 * @author Helen
 */
@RestController
@Slf4j
public class MessageController {

    /**
     * 业务服务接口对象.
     */
    @Autowired
    @Setter
    private MessageService messageService;

    @RequestMapping(path = "/ShowNewMessage",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject showNewMessage(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String receiverUID = request.getParameter("receiverUID");

        List<MessageList> messageList = messageService.queryNewMessage(receiverUID);
        if (messageList != null) {
            jsonObject.put("Result", "success");
            jsonObject.put("messageList", messageList);
        } else {
            jsonObject.put("Result", "failed");
        }
        return jsonObject;
    }

    @RequestMapping(path = "/GetMessage",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getMessage(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String senderUID = request.getParameter("senderUID");
        String receiverUID = request.getParameter("receiverUID");

        List<Message> messageList = messageService.queryMessage(senderUID,receiverUID);
        if (messageList != null) {
            jsonObject.put("Result", "success");
            jsonObject.put("messageList", messageList);
        } else {
            jsonObject.put("Result", "failed");
        }
        return jsonObject;
    }

    @RequestMapping(path = "/SendMessage",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject sendMessage(HttpServletRequest request) throws ParseException {
        Message message = new Message();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = request.getParameter("time");
        Date time = simpleDateFormat.parse(timeStr);
        message.setTime(time);
        message.setMessage(request.getParameter("message"));
        message.setSenderUid(request.getParameter("senderUID"));
        message.setReceiverUid(request.getParameter("receiverUID"));
        //   	Map<String, JSONArray> params = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        if (messageService.insertMessage(message)) {
            jsonObject.put("Result", "success");
        } else {
            jsonObject.put("Result", "failed");
        }
        return jsonObject;
    }

}
package com.zy.controller;

import com.alibaba.fastjson.JSONObject;
import com.zy.service.UserService;
import com.zy.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ying
 */
public class IdentifyController {

    /**
     * 业务服务接口对象.
     */
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/CheckIdentifier",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject checkIdentifier(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String uid = request.getParameter("UID");
        if(userService.queryIdentifier(uid)){
            jsonObject.put("result", "success");
        }else {
            jsonObject.put("result", "failed");
        }
        return jsonObject;
    }

    @RequestMapping(path = "/Identifier",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject Identifier(HttpServletRequest request){
        String name = request.getParameter("name").trim();
        String uid = request.getParameter("UID").trim();
        String id = request.getParameter("id").trim();
        String host = "https://idenauthen.market.alicloudapi.com";
        String path = "/idenAuthentication";
        String method = "POST";
        String appCode = "06e2159da1204568bfda34bd25b4788d";
        System.out.println(name);
        System.out.println(id);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appCode);
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> query = new HashMap<String, String>();
        Map<String, String> body = new HashMap<String, String>();
        body.put("idNo", id);
        body.put("name", name);
        JSONObject jsonObject = new JSONObject();
        try{
            HttpResponse response1 = HttpUtils.doPost(host, path, method, headers, query, body);
            System.out.println(response1.toString());
            JSONObject json = (JSONObject) JSONObject.toJSON(EntityUtils.toString(response1.getEntity()));
            if("0000".equals(json.getString("respCode"))){
                if(userService.alterIdentifier(uid)) {
                    jsonObject.put("Result", "success");
                } else{
                    jsonObject.put("Result", "failed");
                }
            }else{
                jsonObject.put("Result", "failed");
            }
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}

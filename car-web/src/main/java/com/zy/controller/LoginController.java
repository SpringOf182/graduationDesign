package com.zy.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zy.entity.User;
import com.zy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @author Ying
 */
@RestController
@Slf4j
public class LoginController {

    /**
     * 业务服务接口对象.
     */
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/Login",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(HttpServletRequest request) throws IOException {
        /*String nickName = request.getParameter("nickName").trim();
        String image = request.getParameter("image").trim();
        JSONObject jsonObject = userService.insertUser(nickName, image);
        return jsonObject;*/

        String resultData = new String();
        String isRegister = new String();
        JSONObject result = new JSONObject();
        String appid = request.getParameter("appid").trim();
        String secret = request.getParameter("secret").trim();
        String js_code = request.getParameter("js_code").trim();
        String grant_type = "authorization_code";

        String requestURL = "https://api.weixin.qq.com/sns/jscode2session";
        String URL = requestURL + "?appid=" + appid + "&secret=" + secret + "&js_code=" + js_code + "&grant_type=" + grant_type;

        HttpClient httpClient = new HttpClient();
        // 设置连接超时
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(3000);
        // 设置读取数据超时
        httpClient.getHttpConnectionManager().getParams().setSoTimeout(180000);
        httpClient.getParams().setContentCharset("UTF-8");
        GetMethod get = new GetMethod(URL);
        int status = httpClient.executeMethod(get);
        if (status == HttpStatus.SC_OK) {
            resultData = get.getResponseBodyAsString();
            ObjectMapper mapper = new ObjectMapper();
            Map json = null;
            json = mapper.readValue(resultData, Map.class);

            String openid = (String) json.get("appid");
            String errmsg = (String)json.get("errmsg");
            if(userService.queryUser(openid) != null) {
                isRegister = "true";
            } else {
                isRegister = "flase";
            }
            result.put("openid", openid);
            result.put("errmsg", errmsg);
            result.put("isRegister", isRegister);
        }else {
            throw new RuntimeException("微信接口连接失败！");
        }
        return result;
    }

    @RequestMapping(path = "/ShowUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject showUserInfo(HttpServletRequest request){
        String UID = request.getParameter("UID").trim();
        JSONObject jsonObject = new JSONObject();
        User user = userService.queryUser(UID);
        if (user != null) {
            jsonObject.put("Result", "success");
            jsonObject.put("user", user);
        } else {
            jsonObject.put("Result", "failed");
        }
        return jsonObject;
    }
}

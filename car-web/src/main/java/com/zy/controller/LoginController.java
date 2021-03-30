package com.zy.controller;

import com.zy.service.UserService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    @Setter
    private UserService userService;

    @RequestMapping(path = "/Login",method = RequestMethod.POST)
    public JSONObject login(HttpServletRequest request) {
        String nickName = request.getParameter("nickName").trim();
        String image = request.getParameter("image").trim();

    }
}

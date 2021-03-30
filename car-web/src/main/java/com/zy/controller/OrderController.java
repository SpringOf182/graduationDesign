package com.zy.controller;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.zy.service.OrderService;
import com.zy.entity.Order;

/**
 * Order控制器.
 * @author Ying
 */
@RestController
@Slf4j
public class OrderController {

    /**
     * 业务服务接口对象.
     */
    @Autowired
    @Setter
    private OrderService orderService;

}
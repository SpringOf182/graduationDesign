package com.zy.controller;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.zy.service.MessageService;
import com.zy.entity.Message;

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

}
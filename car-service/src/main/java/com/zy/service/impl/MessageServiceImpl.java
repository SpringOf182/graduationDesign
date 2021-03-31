package com.zy.service.impl;

import com.zy.entity.Message;
import com.zy.entity.MessageList;
import com.zy.service.MessageService;
import mapper.MessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * Message业务服务实现类.
 * @author Ying
 */
@Service("messageService")
@Slf4j
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<MessageList> queryNewMessage(String receiverUID){
        return (List<MessageList>) messageMapper.queryNewMessage(receiverUID);
    }

    @Override
    public List<Message> queryMessage(String senderUID,String receiverUID){
        Example example = new Example(Message.class);
        //排序使用的是列名，数据库里面的列名
        example.orderBy("latestTime").asc();
        Example.Criteria criteriaA = example.createCriteria();
        criteriaA.andEqualTo("senderUID", senderUID).andEqualTo("receiverUID",receiverUID);
        Example.Criteria criteriaB = example.createCriteria();
        criteriaB.andEqualTo("senderUID", receiverUID).andEqualTo("receiverUID",senderUID);
        example.or(criteriaB);
        return messageMapper.selectByExample(example);
    }

    @Override
    public Boolean insertMessage(Message message){
        try{
            messageMapper.insert(message);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}

package com.zy.service;

import com.zy.entity.Message;
import com.zy.entity.MessageList;

import java.util.List;


/**
 * Message服务类.
 *
 */
public interface MessageService {
    public List<MessageList> queryNewMessage(String receiverUID);
    public List<Message> queryMessage(String senderUID, String receiverUID);
    public Boolean insertMessage(Message message);
}

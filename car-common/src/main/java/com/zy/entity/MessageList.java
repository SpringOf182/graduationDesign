package com.zy.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Ying
 */
@Data
public class MessageList {

    /**
     * 消息发送者ID.
     */
    private String senderUID;

    /**
     * 消息接收者ID.
     */
    private String receiverUID;

    /**
     * 最新一条消息发送时间.
     */
    private Date time;

    /**
     * 最新一条消息内容.
     */
    private String message;

    /**
     * 对方用户头像url.
     */
    private String image;

    /**
     * 对方用户昵称.
     */
    private String nickName;
}

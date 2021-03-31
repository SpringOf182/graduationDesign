package com.zy.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Ying
 */
@Data
public class MessageList {

    private String senderUID;

    private String receiverUID;

    private Date time;

    private String message;

    private String image;

    private String nickName;
}

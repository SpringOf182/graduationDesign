package com.zy.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Message.
 */
@Data
@Table(name = "message_record")
public class Message implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键.
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private java.lang.Integer mid;

    /**
     * 消息发送时间.
     */
    private java.util.Date time;

    /**
     * 消息内容.
     */
    private java.lang.String message;

    /**
     * 消息发送者ID.
     */
    private java.lang.String senderUid;

    /**
     * 消息接收者ID.
     */
    private java.lang.String receiverUid;
    
    /** 字段名称枚举. */
    public enum FieldNames {
        /** mid. */
        mid,
        /** 消息发送时间. */
        time,
        /** 消息内容. */
        message,
        /** 消息发送者ID. */
        senderUid,
        /** 消息接收者ID. */
        receiverUid
    }



}

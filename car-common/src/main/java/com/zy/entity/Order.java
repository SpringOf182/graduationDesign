package com.zy.entity;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Order.
 */
@Data
@Table(name = "order_list")
public class Order implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键.
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private java.lang.Integer oid;

    /**
     * 发单人ID.
     */
    private java.lang.String uid;

    /**
     * 取货点.
     */
    private java.lang.String pickUp;

    /**
     * 送达点.
     */
    private java.lang.String delivery;

    /**
     * 快递公司.
     */
    private java.lang.String company;

    /**
     * 价格.
     */
    private java.lang.Double price;

    /**
     * 重量.
     */
    private java.lang.Double weight;

    /**
     * 验证码.
     */
    private java.lang.String verificationCode;

    /**
     * 用户自主填写的联系电话.
     */
    private java.lang.String contactNumber;

    /**
     * 接单人ID.
     */
    private java.lang.String recipentUid;

    /**
     * 接单人联系电话.
     */
    private java.lang.String recipentPhoneNumber;

    /**
     * 备注信息,一般用于用户写详细地址.
     */
    private java.lang.String memo;

    /**
     * 用户填写的订单失效日期(默认为7日后).
     */
    private java.util.Date latestTime;

    /**
     * 0表示订单未被接受,1表示已被接受但未完成,2表示已被完成,3表示订单失效.
     */
    private java.lang.Integer state;
    
    /** 字段名称枚举. */
    public enum FieldNames {
        /** 订单号(主键). */
        oid,
        /** 发单人ID. */
        uid,
        /** 取货点. */
        pickUp,
        /** 送达点. */
        delivery,
        /** 快递公司. */
        company,
        /** 价格. */
        price,
        /** 重量. */
        weight,
        /** 验证码. */
        verificationCode,
        /** 用户自主填写的联系电话. */
        contactNumber,
        /** 接单人ID. */
        recipentUid,
        /** 接单人联系电话. */
        recipentPhoneNumber,
        /** 备注信息,一般用于用户写详细地址. */
        memo,
        /** 用户填写的订单失效日期(默认为7日后). */
        latestTime,
        /** 0表示订单未被接受,1表示已被接受但未完成,2表示已被完成,3表示订单失效. */
        state
    }



}

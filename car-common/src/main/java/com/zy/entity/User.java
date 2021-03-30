package com.zy.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User.
 */
@Data
@Table(name = "user_list")
public class User implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键.
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private java.lang.Integer uid;
    /**
     * 用户昵称.
     */
    private java.lang.String nickName;

    /**
     * 用户头像URL.
     */
    private java.lang.String image;

    /**
     * 是否认证，1已认证，0未认证.
     */
    private java.lang.Integer identifier;
    
    /** 字段名称枚举. */
    public enum FieldNames {
        /** id(主键). */
        uid,
        /** 用户昵称. */
        nickName,
        /** 用户头像URL. */
        image,
        /** 是否认证，1已认证，0未认证. */
        identifier
    }



}

package com.zy.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import com.ztesoft.bss.base.entity.BaseEntity;


/**
 * Message.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@javax.persistence.Table(name = "message_record")
public class Message extends BaseEntity<java.lang.Integer> implements java.io.Serializable {
    /** 表名常量. */
    public static final String TNAME = "message_record";
    private static final long serialVersionUID = 1L;


    //属性 begin
    @javax.persistence.Transient
    public java.lang.Integer getId() {
        return super.getId();
    }
    /**
     * 获取 mid.
     */
    @javax.persistence.Id
    public java.lang.Integer getMid() {
          return super.getId();
    }
    /**
     * 设置 mid.
     */
    public void setMid(java.lang.Integer mid) {
          super.setId(mid);
    }
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


    /**
     * 没有statusCd字段返回null.
     * @return null
     */
    @javax.persistence.Transient
    public String getStatusCd() {
        return null;
    }
    /**
     * 没有statusCd字段，无需调用这个方法.
     * @param statusCd 状态
     */
    public void setStatusCd(String statusCd) {
        return;
    }
    /**
     * 没有statusDate字段返回null.
     * @return null
     */
    @javax.persistence.Transient
    public java.util.Date getStatusDate() {
        return null;
    }
    /**
     * 没有statusDate字段，无需调用这个方法.
     * @param statusDate 状态
     */
    public void setStatusDate(java.util.Date statusDate) {
        return;
    }
    /**
     * 没有statusCd字段返回null.
     * @return null
     */
    @javax.persistence.Transient
    public java.util.Date getCreateDate() {
        return null;
    }
    /**
     * 没有createDate字段，无需调用这个方法.
     * @param createDate 创建时间
     */
    public void setCreateDate(java.util.Date createDate) {
        return;
    }
    /**
     * 没有createStaff字段返回null.
     * @return null
     */
    @javax.persistence.Transient
    public Long getCreateStaff() {
        return null;
    }
    /**
     * 没有createStaff字段，无需调用这个方法.
     * @param createStaff 创建人工号
     */
    public void setCreateStaff(Long createStaff) {
        return;
    }
    /**
     * 没有updateDate字段返回null.
     * @return null
     */
    @javax.persistence.Transient
    public java.util.Date getUpdateDate() {
        return null;
    }
    /**
     * 没有updateDate字段，无需调用这个方法.
     * @param updateDate 修改时间
     */
    public void setUpdateDate(java.util.Date updateDate) {
        return;
    }
    /**
     * 没有updateStaff字段返回null.
     * @return null
     */
    @javax.persistence.Transient
    public Long getUpdateStaff() {
        return null;
    }
    /**
     * 没有updateStaff字段，无需调用这个方法.
     * @param updateStaff 修改人工号
     */
    public void setUpdateStaff(Long updateStaff) {
        return;
    }
    //属性 end
    
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

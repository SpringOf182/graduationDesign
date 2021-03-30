package com.zy.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import com.ztesoft.bss.base.entity.BaseEntity;


/**
 * Order.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@javax.persistence.Table(name = "order_list")
public class Order extends BaseEntity<java.lang.Integer> implements java.io.Serializable {
    /** 表名常量. */
    public static final String TNAME = "order_list";
    private static final long serialVersionUID = 1L;


    //属性 begin
    @javax.persistence.Transient
    public java.lang.Integer getId() {
        return super.getId();
    }
    /**
     * 获取 订单号(主键).
     */
    @javax.persistence.Id
    public java.lang.Integer getOid() {
          return super.getId();
    }
    /**
     * 设置 订单号(主键).
     */
    public void setOid(java.lang.Integer oid) {
          super.setId(oid);
    }
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

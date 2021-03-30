package com.zy.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import com.ztesoft.bss.base.entity.BaseEntity;


/**
 * User.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@javax.persistence.Table(name = "user_list")
public class User extends BaseEntity<java.lang.String> implements java.io.Serializable {
    /** 表名常量. */
    public static final String TNAME = "user_list";
    private static final long serialVersionUID = 1L;


    //属性 begin
    @javax.persistence.Transient
    public java.lang.String getId() {
        return super.getId();
    }
    /**
     * 获取 id(主键).
     */
    @javax.persistence.Id
    public java.lang.String getUid() {
          return super.getId();
    }
    /**
     * 设置 id(主键).
     */
    public void setUid(java.lang.String uid) {
          super.setId(uid);
    }
    /**
     * 用户昵称.
     */
    private java.lang.String nickName;

    /**
     * 用户头像URL.
     */
    private java.lang.String image;


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
        /** id(主键). */
        uid,
        /** 用户昵称. */
        nickName,
        /** 用户头像URL. */
        image
    }



}

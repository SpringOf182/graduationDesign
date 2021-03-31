package com.zy.service;

import com.alibaba.fastjson.JSONObject;
import com.zy.entity.User;


/**
 * User服务类.
 * @author Helen
 */
public interface UserService {
    /**
     * 用uid查用户
     * @param uid 用户id
     * @return 查询到的用户完整信息
     */
    public User queryUser(String uid);
    /**
     * 查询用户
     * @param userQ 用户查询条件
     * @return 插入结果
     */
    public User queryUser(User userQ);
    public JSONObject insertUser(String nickName,String image);
    public Boolean alterIdentifier(String UID);
    public Boolean queryIdentifier(String UID);
}

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
    public User queryUser(int uid);
    /**
     * 用昵称查用户
     * @param nickName 用户昵称
     * @return 查询到的用户完整信息
     */
    public User queryUser(String nickName);
    /**
     * 用uid查用户
     * @param nickName 用户昵称
     * @param image 用户头像url
     * @return 插入结果
     */
    public JSONObject insertUser(String nickName,String image);
}

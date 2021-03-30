package com.zy.service;

import com.zy.entity.User;

/**
 * @author Ying
 */
public interface ProcessUserService {
    public User queryUser(int UID);
    public User queryUser(String nickName);
    public Boolean insertUser(String nickName,String image);
}

package com.sfzjh.service;

import com.sfzjh.entity.User;

/**
 * @Author 孙飞
 * @Date 2021年04月30日  10:53
 * @PackageName com.sfzjh.service
 * @Name UserService
 * @Version 1.0
 * @Description TODO
 * Created with IntelliJ IDEA.
 */
public interface UserService {
    /**
     * 根据用户id查找用户信息
     * @author 孙飞
     * @date 2021年04月30日  10:54
     * @param id 用户id
     * @return com.sfzjh.entity.User
     */
    User getUserById(Long id);
}

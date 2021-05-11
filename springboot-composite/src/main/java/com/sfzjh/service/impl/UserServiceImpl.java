package com.sfzjh.service.impl;

import com.sfzjh.dao.UserMapper;
import com.sfzjh.entity.User;
import com.sfzjh.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 孙飞
 * @Date 2021年04月30日  10:55
 * @PackageName com.sfzjh.service.impl
 * @Name UserServiceImpl
 * @Version 1.0
 * @Description TODO
 * Created with IntelliJ IDEA.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }
}

package com.sfzjh.dao;

import com.sfzjh.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * @Author 孙飞
 * @Date 2021年04月30日  9:23
 * @PackageName com.sfzjh.dao
 * @Name UserMapper
 * @Version 1.0
 * @Description TODO
 * Created with IntelliJ IDEA.
 */
public interface UserMapper {
    /**
     * 根据用户ID查找用户信息
     * @author 孙飞
     * @date 2021年04月30日  09:24
     * @param id 用户id
     * @return com.sfzjh.entity.User
     */
    @Select("select * from tb_user where id = #{id}")
    User getUserById(Long id);
}

package com.sfzjh.controller;

import com.sfzjh.entity.JsonResult;
import com.sfzjh.entity.User;
import com.sfzjh.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 孙飞
 * @Date 2021年04月30日  11:00
 * @PackageName com.sfzjh.controller
 * @Name UserController
 * @Version 1.0
 * @Description TODO
 * Created with IntelliJ IDEA.
 */
@RestController
@Api(value = "用户信息接口")
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/getUserById/{id}")
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    public JsonResult<User> getUserById(@PathVariable @ApiParam(value = "用户唯一标识") Long id){
        JsonResult<User> result = new JsonResult<>();
        result.setCode("200");
        result.setMessage("查询成功");
        result.setData(userService.getUserById(id));
        return result;
    }
}

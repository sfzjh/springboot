package com.sfzjh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 孙飞
 * @Date 2021年05月21日  21:03
 * @PackageName com.sfzjh.controller
 * @Name HelloController
 * @Version 1.0
 * @Description TODO
 * Created with IntelliJ IDEA.
 */
@RestController
@RequestMapping("/demo")
public class HelloController {

    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin!";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user!";
    }

    @GetMapping("/db/hello")
    public String dba() {
        return "hello dba!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello security!";
    }
}

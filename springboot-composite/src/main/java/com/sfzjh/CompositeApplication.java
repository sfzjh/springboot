package com.sfzjh;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 孙飞
 * @Date 2021年04月29日  17:32
 * @PackageName com.sfzjh
 * @Name CompositeApplication
 * @Version 1.0
 * @Description TODO
 * Created with IntelliJ IDEA.
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.sfzjh.dao")
public class CompositeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompositeApplication.class, args);
        log.info("\n----------------------------------------------------------\n\t" +
                "接口地址:\n\t" +
                "swagger-ui: http://127.0.0.1:8080/swagger-ui.html\n\t" +
                "----------------------------------------------------------");
    }
}

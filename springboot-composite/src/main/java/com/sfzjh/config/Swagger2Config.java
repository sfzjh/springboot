package com.sfzjh.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author 孙飞
 * @Date 2021年04月30日  8:50
 * @PackageName com.sfzjh.config
 * @Name Swagger2Config
 * @Version 1.0
 * @Description TODO
 * Created with IntelliJ IDEA.
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sfzjh.controller"))
                //加了ApiOperation注解的方法，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("个人博客")
                .description("博客相关接口API")
                .contact(new Contact("微信公众号：码农博客", "https://www.sfzjh.com", "939763776@qq.com"))
                .version("API 1.0")
                .build();
    }

}

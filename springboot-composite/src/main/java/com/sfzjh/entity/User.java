package com.sfzjh.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author 孙飞
 * @Date 2021年04月29日  17:45
 * @PackageName com.sfzjh.entity
 * @Name User
 * @Version 1.0
 * @Description TODO
 * Created with IntelliJ IDEA.
 */
@Table
@ApiModel(value = "用户实体类")
@Data
public class User {

    @ApiModelProperty(value = "用户ID", example = "1")
    @Id
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", example = "admin", required = true)
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",example = "123456",required = true)
    private String password;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名",example = "admin", required = true)
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄", example = "36", required = true)
    private Integer age;

    /**
     * 性别 1：男性  2：女性
     */
    @ApiModelProperty(value = "性别", example = "1", required = true)
    private Integer sex;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期", example = "2018-03-06")
    private Date birthday;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", example = "2018-03-06", required = true)
    private Date created;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "修改时间",example = "2018-03-06",required = true)
    private Date updated;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", example = "备注")
    private String note;
}

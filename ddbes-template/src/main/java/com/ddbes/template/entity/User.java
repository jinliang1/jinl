package com.ddbes.template.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @ProjectName: ddbes-template
 * @Package: com.ddbes.template.entity
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/6 15:02
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 5737524872235196623L;
    @ApiModelProperty(value = "用户id")
    private String id;
    @ApiModelProperty(value = "姓名")
    @NonNull
    private String name;
    @ApiModelProperty(value = "年龄")
    @NonNull
    private Integer age;
    @ApiModelProperty(value = "手机号")
    private String phone;
}

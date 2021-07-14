package ddbes.exam.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.entity
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/7 10:12
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -7182879067204746417L;
    @ApiModelProperty(value = "用户id")
    @TableId
    private String uId;
    @ApiModelProperty("姓名")
    private String uName;
    @ApiModelProperty("类型")
    private  Integer uType;
    @ApiModelProperty("密码")
    private  String uPassword;
    @ApiModelProperty("性别")
    private  String uSex;


}

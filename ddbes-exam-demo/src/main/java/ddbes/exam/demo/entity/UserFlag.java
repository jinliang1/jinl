package ddbes.exam.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.entity
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/7 14:45
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserFlag implements Serializable {
    private static final long serialVersionUID = 3520173390970839998L;
    @ApiModelProperty("用户id")
    @TableId
    private String  uId;
    @ApiModelProperty("课程")
    private  String course;
    @ApiModelProperty("0未提交，1提交")
    @NotNull(message = "提交信息错误")
    private  Integer flag;
}

package ddbes.exam.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.entity
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/7 14:20
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Test implements Serializable {
    private static final long serialVersionUID = 5059382247564162560L;
    @ApiModelProperty("用户id")
    @TableId
    private String uId;
    @ApiModelProperty("课程")
    private String course;
    @ApiModelProperty(value = "试卷的id")
    private int paId;
    @ApiModelProperty(value = "试卷的名")
    private int paName;
    @ApiModelProperty("总分")
    private Integer score;


}

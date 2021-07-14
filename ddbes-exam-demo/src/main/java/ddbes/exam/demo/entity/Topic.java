package ddbes.exam.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.entity
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/9 10:43
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */

public class Topic implements Serializable {
    private static final long serialVersionUID = -4688439014761611631L;

    @ApiModelProperty("题目的编号")
    @TableId
    private  Integer tId;
    @ApiModelProperty("题目的类型")
    private Integer tType;
    @ApiModelProperty("题目的分值")
    private Integer tValue;
    @ApiModelProperty("题目的答案")
    private Integer tAnswer;


}

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
 * @CreateDate: 2021/7/9 10:43
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Topic implements Serializable {
    private static final long serialVersionUID = -4688439014761611631L;
    @ApiModelProperty("在试卷中的编号")
    @TableId
    private String id;
    @ApiModelProperty("在题库中题目的编号")
    private String questionId;
    @ApiModelProperty("题目的类型")
    private String type;
    @ApiModelProperty("试卷的id")
    private String paperId;
    @ApiModelProperty("用户的答案")
    private String value;


}

package ddbes.exam.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.entity
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/7 14:30
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName(value = "题表")
public class Question implements Serializable {
    private static final long serialVersionUID = 1471834500129355875L;
    @ApiModelProperty("题目的id")
    @TableId
    private String id;
    @ApiModelProperty("题目的类型：1单选2多选3判断4简答题")
    private String type;
    @ApiModelProperty("题目")
    private String ques;
    @ApiModelProperty("选项")
    private String option;
    @ApiModelProperty("试卷id")
    private String paperId;
    @ApiModelProperty("答题值")
    private String value;



}

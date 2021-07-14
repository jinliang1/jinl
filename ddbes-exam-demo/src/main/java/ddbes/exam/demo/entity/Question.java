package ddbes.exam.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.omg.CORBA.PRIVATE_MEMBER;

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
public class Question implements Serializable {
    private static final long serialVersionUID = 1471834500129355875L;
    @ApiModelProperty("题目的id")
    @TableId
    private int qId;
    @ApiModelProperty("题目的类型：1单选2多选")
    private int qType;
    @ApiModelProperty("科目")
    private String courseId;
    @ApiModelProperty("题目")
    private String ques;
    @ApiModelProperty("选项A")
    private String keyA;
    @ApiModelProperty("选项B")
    private String keyB;
    @ApiModelProperty("选项C")
    private String keyC;
    @ApiModelProperty("选项D")
    private String keyD;
    @ApiModelProperty("答案")
    private String answer;





}

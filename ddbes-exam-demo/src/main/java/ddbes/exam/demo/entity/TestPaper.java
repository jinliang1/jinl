package ddbes.exam.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.entity
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/7 13:48
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestPaper  implements Serializable {
    private static final long serialVersionUID = 1859620114985735126L;
    @ApiModelProperty(value = "试卷的id")
    @TableId
    private int paId;
    @ApiModelProperty(value = "试卷的名称")
    private int paName;
    @ApiModelProperty(value = "用户id")
    private  String uId;
    @ApiModelProperty(value = "题库的id")
    private  int qId;
    @ApiModelProperty("科目")
    private String course;
    @ApiModelProperty("总成绩")
    private float score;
    @ApiModelProperty("用户标记表")
    private UserFlag userFlag;
    @ApiModelProperty("试卷全部题")
    private List<Topic> topics;




}

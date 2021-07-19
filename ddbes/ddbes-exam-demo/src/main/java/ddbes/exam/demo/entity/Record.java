package ddbes.exam.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * @CreateDate: 2021/7/14 13:20
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record implements Serializable {
    private static final long serialVersionUID = -3558901187347200577L;
    @ApiModelProperty("记录数的id")
    @TableId
    private String id;
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("试卷的id")
    private String paperId;
    @ApiModelProperty("总分")
    private String score;
    @ApiModelProperty("开始时间")
    private Long startTime;
    @ApiModelProperty("完成时间")
    private Long completionTime;
    @ApiModelProperty("状态: 0为提交 1正常提交 2超时提交 ")
    private Integer status;

}

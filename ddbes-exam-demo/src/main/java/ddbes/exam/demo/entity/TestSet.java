package ddbes.exam.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.entity
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/7 14:51
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestSet implements Serializable {
    private static final long serialVersionUID = -6045490692045556905L;
    @ApiModelProperty("课程")
    @TableId
    private String course;
    @ApiModelProperty("考试时间")
    private Long totalTime;

}

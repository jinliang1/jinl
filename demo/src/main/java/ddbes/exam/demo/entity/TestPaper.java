package ddbes.exam.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.entity
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/20 15:08
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Data
@Document(collection = "test_paper")
public class TestPaper {
    @ApiModelProperty(value = "试卷的id")
    private String id;
    @ApiModelProperty("试卷的名称")
    private String name;
    @ApiModelProperty("科目")
    private String course;
    @ApiModelProperty("时间")
    private Long time;
    @ApiModelProperty("总成绩")
    private String score;
    @ApiModelProperty("试卷全部题")
    private List<Topic> listTopics;
}

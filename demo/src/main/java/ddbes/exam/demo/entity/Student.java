package ddbes.exam.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.entity
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/19 16:23
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Data
@Document(collection = "student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String id;
    private String name;
    private String sex;
    private String gradeId;
}

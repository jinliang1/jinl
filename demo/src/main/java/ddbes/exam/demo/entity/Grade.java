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
 * @CreateDate: 2021/7/19 16:25
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "grade")
public class Grade {
    private String id;
    private  String gradeName;

}


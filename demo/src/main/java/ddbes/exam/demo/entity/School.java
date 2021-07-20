package ddbes.exam.demo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.entity
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/20 13:21
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Data
@Document(collection = "School")
public class School {
    private String id;
    private String name;

}

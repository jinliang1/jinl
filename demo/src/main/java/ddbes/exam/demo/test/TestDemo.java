package ddbes.exam.demo.test;

import ddbes.exam.demo.entity.Grade;
import ddbes.exam.demo.entity.School;
import springfox.documentation.service.ApiListing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.test
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/20 13:33
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
public class TestDemo {
    //测试demo
    public static void main(String[] args) {
        HashMap<String, Grade> map = new HashMap<>();
        Grade grade1 = new Grade("1", "一年级");
        Grade grade2 = new Grade("2", "二年级");
        Grade grade3 = new Grade("3", "三年级");
        Grade grade4 = new Grade("4", "四年级");
        Grade grade5 = new Grade("5", "五年级");
        Grade grade6 = new Grade("6", "六年级");
        map.put("1", grade1);
        map.put("2", grade2);
        map.put("3", grade3);
        map.put("4", grade4);
        map.put("5", grade5);
        map.put("6", grade6);
        // todo 根据键取值
        for (String s : map.keySet()) {
            System.out.println("key:" + s + "value: " + map.get(s));
        }
        // todo 遍历所有的value，不遍历key
        for (Grade grade : map.values()) {
            System.out.println("值 :" + grade);
        }
        // todo  通过entry.getKey() 获取键 在获取值entry.getValue()获取到值   推荐尤其大容量
        for (Map.Entry<String, Grade> entry : map.entrySet()) {
            System.out.println("键key： " + entry.getKey() + "值value： " + entry.getValue());
        }
        // todo 通过迭代器 iterator 获得entry
        Iterator<Map.Entry<String, Grade>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Grade> gradeEntry = iterator.next();
            System.out.println("键key： " + gradeEntry.getKey() + "值value： " + gradeEntry.getValue());
            Grade value = gradeEntry.getValue();
            System.out.println("id" + value.getId() + "    name" + value.getGradeName());
            System.out.println("==============");
            if ("6".equals(value.getId())) {
                value.setGradeName("最大的年级");
                System.out.println("id" + value.getId() + "    name" + value.getGradeName());
            }
        }
    }
}

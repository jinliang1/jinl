package ddbes.exam.demo.test;

import com.google.common.collect.Lists;
import ddbes.exam.demo.entity.Grade;
import ddbes.exam.demo.entity.School;
import ddbes.exam.demo.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.crypto.tls.MACAlgorithm;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * @ProjectName: demo
 * @Package: ddbes.exam.demo.test
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/21 8:51
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
@Slf4j
public class TestSecond {
    public static void main(String[] args) {
        List<Student> list = Lists.newArrayList();
        list.add(new Student("1", "测试", "男", "1"));
        list.add(new Student("2", "开发", "男", "1"));
        list.add(new Student("3", "运维", "男", "1"));
        list.add(new Student("4", "运维", "女", "1"));
        list.add(new Student("5", "运营", "男", "1"));
        list.add(new Student("6", "产品", "女", "1"));
        list.add(new Student("7", "经理", "女", "1"));

        // todo 求性别为男得学生集合
        list.stream().filter(student -> student.getSex().equals("男")).forEach(System.out::println);

        //todo map的key值true为男，false 为女的集合
        Map<Boolean, List<Student>> map = list.stream().collect(partitioningBy(student -> student.getSex().equals("男")));

        for (Boolean s : map.keySet()
        ) {
            System.out.println("key   " + s + "value " + map.get(s));
        }

        // todo 按性别进行 分组取hashCode
        Integer sum = list.stream().filter(student -> student.getSex().equals("男")).mapToInt(Student::hashCode).sum();
        System.out.println(sum);

        // todo  按性别进行分组统计人数
        Map<String, Integer> collect = list.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.summingInt(p -> 1)));
        for (String s : collect.keySet()
        ) {
            System.out.println("key :" + s + "value :" + collect.get(s));
        }

        // todo 获取所有学生的姓名 集合
        List<String> collect1 = list.stream().map(Student::getName).collect(Collectors.toList());
        for (String s : collect1
        ) {
            System.out.println(s);
        }

        // todo 获取所有的名字，组成一条语句
        String s = list.stream().map(Student::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(s);

        // todo 对流进行排序  升序
        List<Student> studentList = list.stream().sorted(Comparator.comparing(Student::getId))
                .collect(Collectors.toList());
        for (Student student : studentList
        ) {
            System.out.println(student);
        }

        // todo 降序
        list.stream().sorted(Comparator.comparing(Student::getId).reversed())
                .forEach(System.out::println);
        // todo 数字排序
        List<Integer> listInteger = Arrays.asList(3, 5, 7, 9, 1, 2);

        listInteger.stream().sorted().forEach(System.out::println);

        // todo 降序
        listInteger.stream().sorted((x, y) -> y - x).forEach(System.out::println);

        System.out.println("--------------------------------Map-----------------------------");
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "123");
        hashMap.put("b", "456");
        hashMap.put("z", "234");
        hashMap.put("c", "789");
        //HashMap 是无序的,当我们需要有顺序的存储key-value时,就需要用到LinkedHashMap了,排序后在转成HashMap。
        // LinkedHashMap是继承于HashMap,是基于HashMap和双向链表来实现的
        // LinkedHashMap 是线成不安全的

        //todo map 根据value 正序排除
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        hashMap.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue()))
                .forEach(x -> linkedHashMap.put(x.getKey(), x.getValue()));

        // todo map根据value 倒叙排序
        LinkedHashMap<String, String> linkedHashMap1 = new LinkedHashMap<>();
        hashMap.entrySet().stream().sorted(Collections.reverseOrder(HashMap.Entry
                .comparingByValue())).forEach(x -> linkedHashMap1.put(x.getKey(), x.getValue()));


        // todo map根据key正序排序
        LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
        hashMap.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey()))
                .forEach(x -> linkedHashMap2.put(x.getKey(), x.getValue()));

        // todo map根据key倒序排序
        LinkedHashMap<String, String> linkedHashMap3 = new LinkedHashMap<>();
        hashMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .forEach(x -> linkedHashMap3.put(x.getKey(), x.getValue()));

        System.out.println("-----------------------------map-------------------------------");
        //todo list 转map 根据对象中的某个属性值
        Map<String, String> collect2 = list.stream().collect(Collectors.toMap(Student::getId, Student::getName));
        for (String ss : collect2.keySet()
        ) {
            System.out.println(ss + collect2.get(ss));
        }

        // todo 指定的key-value value是对象本身，Student ->student 是返回本身的lambda 表达式
        Map<String, Student> collect3 = list.stream().collect(Collectors.toMap(Student::getId, Student -> Student));
        for (Map.Entry<String, Student> entry : collect3.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }


        // todo  指定key-value，value是对象本身，Function.identity()是简洁写法，也是返回对象本身
        Map<String, Student> collect4 = list.stream().collect(Collectors.toMap(Student::getId, Function.identity()));
        for (Student student : collect4.values()
        ) {
            System.out.println(student);
        }

        //todo key冲突的解决办法, 可以用第二个key覆盖第一个key
        Map<String, Student> collect5 = list.stream()
                .collect(Collectors.toMap(Student::getId, Function.identity(), (key1, key2) -> key2));
        Iterator<Map.Entry<String, Student>> iterator = collect5.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next = iterator.next();
            System.out.println(next.getKey() + next.getValue());
        }

        // todo 根据某个属性进行分组,放入map 然后组装成,key-value格式的数据,分组后集合的顺序会被改变，先设置顺序，在进行排序，保证顺序不变
        List<Grade> gradeList = new ArrayList<>();
        gradeList.add(new Grade("1", "尖刀"));
        gradeList.add(new Grade("2", "响箭"));
        gradeList.add(new Grade("3", "狼牙"));
        Map<String, List<Grade>> collect6 = gradeList.stream().collect(Collectors.groupingBy(Grade::getId));
        List<Student> ls = collect6.keySet().stream().map(key -> {
            Student student = new Student();
            student.setGradeId(key);
            if (collect6.get(key) != null && collect6.get(key).size() > 0) {
                student.setName(collect6.get(key).get(0).getGradeName());
                student.setId(collect6.get(key).get(0).getId());
            }
            return student;
        }).collect(Collectors.toList());
        ls.stream().sorted(Comparator.comparing(Student::getId)).forEach(System.out::println);

        // todo 根据用户性别分手
        Map<String, List<Student>> collect7 = list.stream().collect(Collectors.groupingBy(Student::getSex));
        for (String sss:collect7.keySet()
             ) {
            System.out.println(sss+ collect7.get(sss));
        }



        //todo Map转List
        Map<String,String >  map1= new HashMap<>();
        map1.put("a","123");
        map1.put("b","456");
        map1.put("z","789");
        map1.put("c","234");

        // todo 默认排序
         map1.entrySet().stream()
                .map(e -> new School(e.getValue(), e.getKey())).forEach(System.out :: println);

         // todo 根据key排序
        map1.entrySet().stream().sorted(Comparator.comparing( e -> e.getKey()))
                .map(e -> new Grade(e.getKey() ,e.getValue())).forEach(System.out :: println);

        // todo 根据value 排序
        map1.entrySet().stream().sorted(Comparator.comparing(Map.Entry :: getValue))
                .map(e -> new Grade(e.getKey() ,e.getValue()))
                .forEach(System.out :: println);

        // todo  根据key 排序
        map1.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(e -> new Grade(e.getKey(), e.getValue()))
                .forEach(System.out :: println);

        // todo 从list中取出某个属性
        list.stream().map(Student::getName).forEach(System.out :: println);
        // todo 拿出所有gradeId 去从
        list.stream().map(Student::getGradeId).collect(Collectors.toList())
                .stream().distinct().forEach(System.out::println);


    }


}

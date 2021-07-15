package ddbes.exam.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: ddbes-exam-demo
 * @Package: ddbes.exam.demo.utils
 * @Description: java类作用描述
 * @Author: 王琛瑞
 * @CreateDate: 2021/7/14 15:51
 * @Version: 1.0
 * Copyright: Copyright (c) 2021
 */
public class Time {

    private static final ThreadLocal<SimpleDateFormat> sdftl = new ThreadLocal<>();

    public static SimpleDateFormat getSDF() {
        SimpleDateFormat simpleDateFormat = sdftl.get();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdftl.set(simpleDateFormat);
        }
        return simpleDateFormat;
    }

    /**
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String time) {
        SimpleDateFormat sdf = getSDF();
        String stamp = "";
        if (!"".equals(time)) {//时间不为空
            try {
                stamp = String.valueOf(sdf.parse(time).getTime() / 1000);
            } catch (Exception e) {
                System.out.println("参数为空！");
            }
        } else {    //时间为空
            long current_time = System.currentTimeMillis();  //获取当前时间
            stamp = getSDF().format(current_time);
        }
        return stamp;
    }


    /**
     * 将时间戳转换为时间
     */
    public static String stampToDate(Long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time_Date = sdf.format(new Date(time * 1000L));
        return time_Date;
    }

    public static void main(String[] args) {
        String time1 = "2021-7-14 12:30:56";
        Long time2 = 1626237056L;
        System.out.println("将时间转为时间戳：" + dateToStamp(time1));
        System.out.println("将时间戳转为时间：" + stampToDate(time2));
        System.out.println(System.currentTimeMillis());
    }

}

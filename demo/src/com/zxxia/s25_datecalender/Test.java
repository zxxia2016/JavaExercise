package com.zxxia.s25_datecalender;

import com.zxxia.iTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期与时间
 * 1. Date类(java.util.date)：当前系统所在时间;用法 Date(long time) Date() before（时间比较）
 * 2. SimpleDateFormat:将Date对象格式化成需要的，将字符串时间格式化成Date对象
 * 3. Calendar：抽象类
 */

/**
 * JDK8 日期与时间：返回新对象，不会修改之前的对象
 * 1.LocalDate、LocalTime、LocalDateTime（更全），例子：对应Test
 * 2.
 * 3.
 */

class DateTest implements iTest {
    public void run() {
        Date d = new Date();
        // Wed Mar 02 05:50:38 CST 2022
        System.out.println(d);
        // 获取时间戳 1646171502165
        System.out.println(d.getTime());
        // 案例
        long time = System.currentTimeMillis();
        time += 1000 * 60 * 60;
        Date date = new Date();
        // Wed Mar 02 05:56:00 CST 2022
        System.out.println(date);
        date.setTime(time);
        // Wed Mar 02 06:56:00 CST 2022
        System.out.println(date);

        if (date.before(d)) {
            System.out.println("时间之前判断");
        } else {
            System.out.println("时间之后判断");
        }
    }
}

class SimpleDateFormatTest {
    public void run() throws ParseException {
        // 构造器，有参 无参
        // SimpleDateFormat s = new SimpleDateFormat();
        // 参数：格式化形式(yyyy年MM月dd日 HH:mm:ss）-> 2021年11月11日 13:27:36
        String pattern = "yyyy年MM月dd日 HH:mm:ss EEE a";
        SimpleDateFormat s1 = new SimpleDateFormat(pattern);
        Date date = new Date();
        String s = s1.format(date);
        System.out.println(s);

        // 字符串转时间
        String dateStr = "2022年03月02日 11:11:11";
        SimpleDateFormat s2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date1 = s2.parse(dateStr);
        System.out.println(s2.format(date1));
    }
}

class CalendarTest implements iTest {
    public void run() {
        Calendar c = Calendar.getInstance();
        // 获取日历信息
        System.out.println(c);
        // 获取日历信息
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH) + 1);
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        //周天是第一天
        System.out.println(c.get(Calendar.DAY_OF_WEEK));

        //修改小时,一般不修改
        c.set(Calendar.HOUR, 12);

        //64 天后是什么时间
        c.add(Calendar.DAY_OF_YEAR, 64);
        System.out.println(c.getTime());

        //获取时间毫秒值
        System.out.println(c.getTimeInMillis());
    }
}

class LocalDateTest implements iTest {
    @Override
    public void run() {
        LocalDate nowDate = LocalDate.now();
        // 获取日期相关
        nowDate.getYear();
        nowDate.getDayOfWeek();
        // 指定时间

        LocalDate localDate = LocalDate.of(1997, 7 , 1);
        // 1997-07-01
        System.out.println(localDate);
        // 比时间
        localDate.equals(nowDate);
        localDate.isBefore(nowDate);
        localDate.isAfter(nowDate);
        //案例，是否生日
        MonthDay birthday = MonthDay.of(3, 2);
        MonthDay today = MonthDay.from(nowDate);
        today.equals(birthday);
    }
}

class LocalTimeTest implements iTest {
    @Override
    public void run() {
        //获取时间
        LocalTime localTime = LocalTime.now();
        localTime.getHour();

        //加1小时
        localTime.minusHours(1);
        localTime.plusHours(1);

        //指定时间
        LocalTime localTime1 = LocalTime.of(8,20, 3);
        System.out.println(localTime1);
    }
}

class LocalDateTimeTest implements iTest {
    @Override
    public void run() {
        //获取时间
        LocalDateTime localTime = LocalDateTime.now();
        localTime.getHour();

        LocalDate localDate = localTime.toLocalDate();
        LocalTime localTime1 = localTime.toLocalTime();
    }
}
public class Test {
    public static void main(String[] args) throws ParseException {
        DateTest test1 = new DateTest();
        test1.run();
        SimpleDateFormatTest test2 = new SimpleDateFormatTest();
        test2.run();
        CalendarTest test3 = new CalendarTest();
        test3.run();
        LocalDateTest t4 = new LocalDateTest();
        t4.run();
        LocalTimeTest t5 = new LocalTimeTest();
        t5.run();
        LocalDateTimeTest t6 = new LocalDateTimeTest();
        t5.run();
    }
}

package com.zxxia.s25_datecalender;

import com.zxxia.iTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
 * 1. LocalDate、LocalTime、LocalDateTime（更全），例子：对应Test
 * 2. Instant 获取时间戳
 * 3. DateTimeFormatter 日期时间格式化、线程安全
 * 4. Period 日期间隔,差多少年，多少天，多少月 ,用于LocalDate比较
 * 5. Duration 时间间隔：差多少天，多少小时，多少分， 用LocalDateTime比较
 * 6. ChronoUnit 计时单元
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

class InstantTest implements iTest {
    @Override
    public void run() {
        Instant instant = Instant.now();
        // UTC时间
        System.out.println(instant);
        // 获得系统时间
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);
        //如何去返回Date对象，系统时间
        Date date = Date.from(instant);
        System.out.println(date);
        // Date convert Instant
        Instant instant1 = date.toInstant();
    }
}

class DateTimeFormatterTest implements iTest {
    @Override
    public void run() {
        LocalDateTime localDateTime = LocalDateTime.now();
        // 按格式输出时间 2022-03-02 09:26:19
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(localDateTime));
        System.out.println(localDateTime.format(dateTimeFormatter));
        // 解析时间字符串
        String strTime = "2022-03-02 09:26:19";
        LocalDateTime localDateTime1 = LocalDateTime.parse(strTime, dateTimeFormatter);
        System.out.println(localDateTime1);
    }
}

class PeriodTest implements iTest {

    @Override
    public void run() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate localDate1 = LocalDate.of(1987, 11, 2);
        System.out.println(localDate1);
        Period period = Period.between(localDate1, localDate);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }
}

class DurationTest implements iTest {

    @Override
    public void run() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(1987, 11, 2, 0,0,0);
        Duration duration = Duration.between(localDateTime1, localDateTime);
        duration.toDays();
        duration.toHours();
        duration.toMinutes();
        duration.toMillis();
    }
}

class ChronoUnitTest implements iTest {

    @Override
    public void run() {
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

        // 生日时间
        LocalDateTime birthDate = LocalDateTime.of(1990,10,1,
                10,50,59);
        System.out.println(birthDate);

        System.out.println("相差的年数：" + ChronoUnit.YEARS.between(birthDate, today));
        System.out.println("相差的月数：" + ChronoUnit.MONTHS.between(birthDate, today));
        System.out.println("相差的周数：" + ChronoUnit.WEEKS.between(birthDate, today));
        System.out.println("相差的天数：" + ChronoUnit.DAYS.between(birthDate, today));
        System.out.println("相差的时数：" + ChronoUnit.HOURS.between(birthDate, today));
        System.out.println("相差的分数：" + ChronoUnit.MINUTES.between(birthDate, today));
        System.out.println("相差的秒数：" + ChronoUnit.SECONDS.between(birthDate, today));
        System.out.println("相差的毫秒数：" + ChronoUnit.MILLIS.between(birthDate, today));
        System.out.println("相差的微秒数：" + ChronoUnit.MICROS.between(birthDate, today));
        System.out.println("相差的纳秒数：" + ChronoUnit.NANOS.between(birthDate, today));
        System.out.println("相差的半天数：" + ChronoUnit.HALF_DAYS.between(birthDate, today));
        System.out.println("相差的十年数：" + ChronoUnit.DECADES.between(birthDate, today));
        System.out.println("相差的世纪（百年）数：" + ChronoUnit.CENTURIES.between(birthDate, today));
        System.out.println("相差的千年数：" + ChronoUnit.MILLENNIA.between(birthDate, today));
        System.out.println("相差的纪元数：" + ChronoUnit.ERAS.between(birthDate, today));
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
        t6.run();
        InstantTest t7 = new InstantTest();
        t7.run();
        DateTimeFormatterTest t8 = new DateTimeFormatterTest();
        t8.run();
        PeriodTest t9 = new PeriodTest();
        t9.run();
        DurationTest t10 = new DurationTest();
        t10.run();
        ChronoUnitTest t11 = new ChronoUnitTest();
        t11.run();
    }
}

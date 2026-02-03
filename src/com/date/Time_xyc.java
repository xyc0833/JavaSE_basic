package com.date;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Time_xyc {

	public static void main(String[] args) {
		//获取当前日期和时间
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		//+5天
		LocalDateTime ldt2 = ldt.plusDays(5);
		System.out.println(ldt2.toString());
		//如果想指定格式输出 需要一个日期时间格式的类
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(formatter.format(ldt2));
		
		LocalDateTime ldt3 = ldt2.minusHours(2);
		System.out.println(ldt3);
		// 获得当月第一天:
		LocalDate firstDay = LocalDate.now().withDayOfMonth(1);
		LocalDate firstDay2 = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(firstDay.equals(firstDay2));
		System.out.println(firstDay);
		// 获得当月最后一天:
		LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(lastDay);
		// 获得当月第一个星期日：
		LocalDate firstSunday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
		System.out.println(firstSunday);
		// 判断两个日期哪个在前:
		System.out.println(firstSunday.isBefore(LocalDate.now()));
		// 两个日期相差？年？月？天:
		//这个period对象 可以表示两个日期之差
		Period p = LocalDate.now().until(LocalDate.of(2050, 1, 1));
		System.out.println(p);//P23Y10M29D  表示相差23年10个月 29天
		// 两个日期一共相差多少天:
		System.out.println(LocalDate.of(2050, 1, 1).toEpochDay() - LocalDate.now().toEpochDay());
		
		System.out.println(LocalDate.of(2050, 1, 1).toEpochDay());
		/***
		 * LocalDate.of(int year, int month, int dayOfMonth)
		作用：LocalDate.of() 是一个静态工厂方法，用于创建一个 LocalDate 对象。
		它通过给定的年、月、日来创建一个代表具体日期的 LocalDate 实例。
		 */
		
		/***
		 * toEpochDay()
        作用：toEpochDay() 是 LocalDate 类的方法，它返回自 1970年1月1日（也称为 Unix 纪元）以来的 天数。
		注意，这个方法返回的是一个 long 类型的值，表示从 Unix 纪元到当前日期所经过的天数。
		返回值：返回一个 long 类型的数字，表示自 1970年1月1日 UTC 到指定日期之间的天数。
		 */
		System.out.println("==========================================");
		
		
		// 获取当前默认时区的日期和时间:
		ZonedDateTime now = ZonedDateTime.now();
		System.out.println(now);
		// 打印时区:
		System.out.println("时区" + now.getZone());
		// 获取Instant:
		Instant ins = now.toInstant();
		System.out.println(ins.getEpochSecond());
		// 按指定时区获取当前日期和时间:
		ZonedDateTime london = ZonedDateTime.now(ZoneId.of("Europe/London")); // 伦敦时间
		System.out.println("指定时区获取当前日期和时间" + london);
		// 把伦敦时间转换到纽约时间:
		ZonedDateTime newyork = london.withZoneSameInstant(ZoneId.of("America/New_York")); // 纽约时间
		System.out.println("伦敦时间转换到纽约时间" + newyork);
		
		//把当前时间关联到默认时区
		//LocalDateTime ldt = LocalDateTime.now();
		ZonedDateTime bj = ldt.atZone(ZoneId.systemDefault());
		System.out.println(ZoneId.systemDefault());
		System.out.println(bj);
		
		//关联到纽约时区
		ZonedDateTime ny = ldt.atZone(ZoneId.of("America/New_York"));
		System.out.println(ny);
		
		// 转换到纽约时区:
		ZonedDateTime ny02 = bj.withZoneSameInstant(ZoneId.of("America/New_York"));
		System.out.println(ny02);

	}

}

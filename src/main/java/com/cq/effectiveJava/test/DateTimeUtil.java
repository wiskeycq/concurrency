package com.cq.effectiveJava.test;


import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

    public static Time toTimeFromDate(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        return Time.valueOf(String.format(
                "%s:%s:%s",
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND))
        );
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static Date makeDate(int year, int month, int day, int hour, int minute, int second) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day, hour, minute, second);
        return cal.getTime();
    }

    /**
     * 取日期
     * 将时分秒抹掉
     * @param datetime
     * @return
     */
    public static Date datetimeToDate(Date datetime) {
        Calendar datetimeCal = Calendar.getInstance();
        datetimeCal.setTime(datetime);

        return makeDate(
                datetimeCal.get(Calendar.YEAR),
                datetimeCal.get(Calendar.MONTH),
                datetimeCal.get(Calendar.DAY_OF_MONTH),
                0,
                0,
                0
        );
    }

    public static String getCurrentTimeString(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(System.currentTimeMillis());
    }

    public static String formatDate(Date d) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
    }

    public static String formatDay(Date d) {
        return new SimpleDateFormat("yyyy-MM-dd").format(d);
    }

    public static String getCurrentTimeString() {
        String format = "yyyy-MM-dd HH:mm:ss";

        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(System.currentTimeMillis());
    }

    public static Byte getWeekOfDate(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        Byte week = (byte) (cal.get(Calendar.DAY_OF_WEEK) - 1);
        return week;
    }

    public static Date getByString(String strTime){
        Date date=null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = formatter.parse(strTime);
            return date;
        } catch (ParseException e) {
        }
        return date;
    }

    public static Date getDateBeforeGivenDate(Date d, Integer hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.HOUR_OF_DAY, hours);

        return calendar.getTime();
    }

    public static Date getDateSecondsBeforeGivenDate(Date d, Integer seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.SECOND, seconds);

        return calendar.getTime();
    }

    public static Date getDayWithDelta(Date day, int calendarField, int delta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.add(calendarField, delta);

        return calendar.getTime();
    }

    public static Date getDayWithDeltaSeconds(Date d, int deltaSeconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.SECOND, deltaSeconds);

        return calendar.getTime();
    }

    /**
     *  获取时间 时:分:秒 HH:mm:ss
     * @param d
     * @return
     */
    public static String getTimeShort(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(d);
        return dateString;
    }

    /**
     * 查询时间差
     * @param endDate
     * @param nowDate
     * @return
     */
    public static long getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        long diff = endDate.getTime() - nowDate.getTime();
//        // 计算差多少天
//        long day = diff / nd;
//        // 计算差多少小时
//        long hour = diff % nd / nh;
//        // 计算差多少分钟
//        long min = diff % nd % nh / nm;
        long sec = diff/ns;
        return sec;
    }

    public static Date getNeedTime(int hour,int minute,int second,int addDay){
        Calendar calendar = Calendar.getInstance();
        if(addDay != 0){
            calendar.add(Calendar.DATE,addDay);
        }
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,second);

        return calendar.getTime();
    }

    //获取日期的年月日
    public static String getDateYMD(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    //获取本周周一
    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    //获取上周周一
    public static Date getLastWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }

    //获取上周周日
    public static Date getLastWeekSunday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    //获取当前时间的前一天
    public static Date getLastDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    //获取当前时间的后一天
    public static Date getAfterDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    public static Date getCurrentYMD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String endTime = sdf.format(date);
        Date now = new Date();
        try {
            now = DateTimeUtil.getByString(endTime + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    public static Integer hoursToSeconds(Integer hours) {
        return hours * 24 * 3600;
    }


    public static void main(String[] args) {

    }
}

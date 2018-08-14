package com.dengzhy.common.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @ClassName: DateUtils
 * @Description:
 * @Author dengzhy
 * @Date 2018 05 12:06
 */
public class DateUtils {

    private static final Logger log = LoggerFactory.getLogger(DateUtils.class);

    public static final String DATE_FORMAT_STANDARD = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_TIME_STAMP = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_SIMPLE_DAY_TIME_STAMP = "yyMMdd";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT_A = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_C = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final String TIME_FORMAT_D = "yyyyMMdd";
    public static final String TIME_FORMAT_E = "yyyy年MM月dd日";
    public static final String TIME_FORMAT_F = "yyyyMMddHHmm";
    public static final String TIME_FORMAT_G = "yyyy年MM月dd日HH时mm分ss秒";
    public static final String YEAR_MONTH_FORMAT = "yyyy-MM";

    /**
     * 获取当前时间，格式：yyyy-MM-dd HH:mm:SS
     *
     * @param
     * @Author dengzhy
     * @Date 18/5/8 13:45
     * @Return java.lang.String
     */
    public static String getCurrentDateWithFormat(String format){
        Date date = getCurrentDate();
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 获取当前时间
     *
     * @Author dengzhy
     * @Date 18/5/9 11:38
     * @param
     * @Return java.util.Date
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 获取指定时间的后X小时的时间
     *
     * @Author dengzhy
     * @Date 18/5/9 14:22
     * @param currentDate
     * @param hour
     * @Return java.util.Date
     */
    public static Date getAfterHoursDate(Date currentDate, int hour) {
        Date date;
        if (currentDate == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.HOUR, hour);
        date = cal.getTime();
        return date;
    }

    /**
     * 获取当天时间的开始时间
     *
     * @Author dengzhy
     * @Date 18/5/10 09:56
     * @param
     * @Return java.util.Date
     */
    public static Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取当天时间的结束时间
     *
     * @Author dengzhy
     * @Date 18/5/10 09:56
     * @param
     * @Return java.util.Date
     */
    public static Date getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 获取以当天为基础往前几天或往后几天的那天的开始时间
     * days为正数时往后几天，days为负数时往前几天
     *
     * @Author dengzhy
     * @Date 18/5/10 09:58
     * @param
     * @Return java.util.Date
     */
    public static Date getBeginDayOfDays(int days) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
     }

     /**
      * 获取以当天为基础往前几天或往后几天的那天的结束时间
      * days为正数时往后几天，days为负数时往前几天
      *
      * @Author dengzhy
      * @Date 18/5/10 09:58
      * @param
      * @Return java.util.Date
      */
    public static Date getEndDayOfDays(int days) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

    /**
     * @methodName:getTimeByHour
     * @author: dengzhy
     * @description: 【获取当前时间之后n小时的时间】
     * @date:Created in 2018/5/9 17:30
     * <li> @param hour 小时数</li>
     * @return: java.lang.String
     */
    public static String getTimeByHour(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
        return new SimpleDateFormat(TIME_FORMAT_A).format(calendar.getTime());
    }

    /**
     * @methodName:string2Date
     * @author: dengzhy
     * @description: 【字符串日期转时间类型】
     * @date:Created in 2018/5/9 17:36
     * <li> @param dateStr TODO</li>
     * <li> @param format TODO</li>
     * @return: java.util.Date
     */
    public static Date string2Date(String dateStr, String format) {
        if (!StringUtils.isBlank(dateStr) && !StringUtils.isBlank(format)) {
            Date date = null;
            try {
                SimpleDateFormat ex = new SimpleDateFormat(format);
                date = ex.parse(dateStr);
            } catch (ParseException var4) {
                log.error("string to date failure. The detail information is ", var4);
            }
            return date;
        } else {
            return null;
        }
    }

    public static String date2String(Date date, String format) {
        String dateStr = null;
        try {
            if(date != null) {
                SimpleDateFormat ex = new SimpleDateFormat(format);
                dateStr = ex.format(date);
            }
        } catch (Exception var4) {
            log.error("date to string failure. The detail information is: ", var4);
        }
        return dateStr;
    }

    /**
     * 获取传入日期所在月的第一天
     * @param date
     * @return
     */
    public static Date getFirstDayDateOfMonth(final Date date){
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();
    }

    /**
     * 获取传入日期所在月的最后一天（变通一下， < 去下个月的第一天）
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last+1);
        return cal.getTime();
    }

    public static Date date2date(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String dateStr = simpleDateFormat.format(date);
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取下一天的日期（如今天是2018-05-24，调用getLastDay得到2018-05-25）
     * @param date
     * @return
     */
    public static Date getLastDay(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        return date2date(date,DATE_FORMAT);
    }
}

package com.kd.platform.web.sms.util.task.archive;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtils {
    public SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");
    public SimpleDateFormat formatOfDay = new SimpleDateFormat("yyyy-MM-dd");

    String getBeforeDayMaxTime(Date date) {
        return getBeforeDay(date) + ":59:59";
    }

    String getBeforeDayMinTime(Date date) {
        return getBeforeDay(date) + ":00:00";
    }

    public String getBeforeDay(Date date) {
        Calendar calendar = getCalendar(date,Calendar.DAY_OF_MONTH);
        date = calendar.getTime();
        return format.format(date);
    }

    public Date getBeforeDayDate(Date date){
        Calendar calendar = getCalendar(date,Calendar.DAY_OF_MONTH);
        date = calendar.getTime();
        return date;
    }
    public String getBeforeHour(Date date){
        Calendar calendar = getCalendar(date,Calendar.HOUR_OF_DAY);
        date = calendar.getTime();
        return format.format(date);
    }

    Calendar getCalendar(Date date ,int condition) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(condition, -1);
        return calendar;
    }

    public Date getBeforeHourDate(Date date){
        Calendar calendar = getCalendar(date,Calendar.HOUR_OF_DAY);
        date = calendar.getTime();
        return date;
    }

    public String getBeforeDayOfDay(Date date ){
        Calendar calendar = getCalendar(date,Calendar.DAY_OF_MONTH);
        date = calendar.getTime();
        return formatOfDay.format(date);
    }

    public String getCurrentDayOfDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        date = calendar.getTime();
        return formatOfDay.format(date);
    }

    public Date getDateOfDay(String dateStr) throws ParseException {
        Date date = formatOfDay.parse(dateStr);
        return date;
    }

    public Date getDateAddDay(Date date , int i ){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,i);
        date = calendar.getTime();
        return date;
    }

    public String formatDateOfDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        date = calendar.getTime();
        return formatOfDay.format(date);
    }

}
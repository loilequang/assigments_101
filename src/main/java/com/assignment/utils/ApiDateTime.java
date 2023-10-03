package com.assignment.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class ApiDateTime {
    private ApiDateTime() {
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static String getCurrentTimeString(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        long current = System.currentTimeMillis();
        return sdf.format(current);
    }

    public static Date getDateByString(String value, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(value);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Date getStartMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int day = cal.get(Calendar.DATE);
        cal.set(year, month, day, 0, 0, 0);
        return cal.getTime();

    }

    public static Date getEndOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);

        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DATE, -1);

        int day = cal.get(Calendar.DATE);
        cal.set(year, month, day, 23, 59, 59);
        return cal.getTime();
    }

    public static Date getStartYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);
        cal.set(year, month, day, 0, 0, 0);
        return cal.getTime();

    }

    public static Date getEndOfYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, 11, 31, 23, 59, 59);
        return cal.getTime();
    }
    private  static ZoneId zoneId = ZoneId.systemDefault();
    public static ZonedDateTime getTime(Long time)
    {
        Instant instant = Instant.ofEpochMilli(time);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime.atZone(zoneId);
    }
}

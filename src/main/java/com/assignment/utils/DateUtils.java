package com.assignment.utils;

import java.time.*;

public class DateUtils {
    private  static ZoneId zoneId = ZoneId.systemDefault();
    public static ZonedDateTime getTime(Long time)
    {
        Instant instant = Instant.ofEpochMilli(time);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime.atZone(zoneId);
    }
}

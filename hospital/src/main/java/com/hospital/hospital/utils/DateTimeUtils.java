package com.hospital.hospital.utils;

import java.util.Date;

public class DateTimeUtils {

    public static String getStringDateWithoutTime(Date date) {
        String[] dateComponents = date.toString().split(" ");
        return dateComponents[0]+" "+ dateComponents[1] +" "+ dateComponents[2] +" "+ dateComponents[5];
    }

    public static String getStringTimeWithoutDate(Date date) {
        return date.toString().split(" ")[3];
    }
}

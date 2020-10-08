package com.facility.rsv.utils;

public class StringUtils {

    public static boolean isNotEmpty(String str) {
        if (str == null) {
            return false;
        }
        return str.length() != 0;
    }

    public static boolean isEmpty(String str) {
        if (str == null) {
            return false;
        }
        return str.length() == 0;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("[0-9]*");
    }

    public static boolean checkLength(int length, String str) {
        if (str == null) {
            return false;
        }
        return str.length() == length;
    }

    public static boolean checkRangeOfLength(int min, int max, String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        return length >= min && length <= max;
    }

    public static String formatTimeForView(String inputTime) {
        return inputTime.substring(0, 19);
    }

    public static String formatTimeForDB(String inputTime) {
        return inputTime + ":00";
    }
}

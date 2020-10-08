package com.facility.rsv.utils;

import java.time.LocalDateTime;

import com.facility.rsv.beans.UserAccount;

public class Validator {

    private Validator() {
    }

    public static boolean isAdmin(UserAccount userAccount) {
        if (userAccount == null) {
            return false;
        }
        return userAccount.getAuthority() == UserAccount.ADMINISTRATOR;
    }

    public static boolean isReserveUser(UserAccount userAccount) {
        if (userAccount == null) {
            return false;
        }
        return userAccount.getAuthority() == UserAccount.RESERVER;
    }

    public static boolean validateRequiredItem(String targetStr, String itemName) throws ValidationException {
        if (!StringUtils.isNotEmpty(targetStr)) {
            throw new ValidationException(itemName + "は必須項目です。");
        }
        return true;
    }

    public static boolean validateLoginName(String loginName) throws ValidationException {
        if (!validateRequiredItem(loginName, "ログイン名")) {
            return false;
        }
        return withinRange(loginName, "ログイン名", 3, 10);
    }

    public static boolean validatePassword(String password) throws ValidationException {
        if (!validateRequiredItem(password, "パスワード")) {
            return false;
        }
        return withinRange(password, "パスワード", 3, 10);
    }

    private static boolean withinRange(String targetStr, String itemName, int min, int max) throws ValidationException {
        if (!StringUtils.checkRangeOfLength(min, max, targetStr)) {
            throw new ValidationException(itemName + "は" + min + "桁以上" + max + "桁以下で入力してください。");
        }
        return true;
    }

    public static boolean validateEquipment(String targetStr) throws ValidationException{
        if (!validateRequiredItem(targetStr, "施設名")) {
            return false;
        }
        return true;
    }

    public static boolean validateTargetDate(String targetStr) throws ValidationException{
        if (!validateRequiredItem(targetStr, "利用日")) {
            return false;
        }
        return true;
    }


    public static boolean isDateAndTimeFormat(String dateAndTime) {
        return dateAndTime.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}");
    }

public static boolean validateExtensionNumber(String extensionNumber) {
        if (StringUtils.checkLength(0, extensionNumber)) {
            return true;
        }

        if (!StringUtils.checkLength(4, extensionNumber)) {
            System.out.println("内線番号は4桁の数値で入力してください。");
            return false;
        }

        if (!StringUtils.isNumeric(extensionNumber)) {
            System.out.println("内線番号は4桁の数値で入力してください。");
            return false;
        }

        return true;
    }

    public static boolean isFutureDateTime(LocalDateTime dateTime) {
        if (!dateTime.isAfter(LocalDateTime.now())) {
            System.out.println("日時は未来の日付を入力してください。");
            return false;
        }
        return true;
    }

    public static boolean isValidTerm(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (!startDateTime.isBefore(endDateTime)) {
            return false;
        }
        return true;
    }

    public static boolean validateAuthority(int authority) throws ValidationException {
        if (!isAuthority(authority)) {
            throw new ValidationException("権限は0または1で入力してください");
        }
        return true;
    }

    private static boolean isAuthority(int authority) {
        return authority == UserAccount.ADMINISTRATOR
                || authority == UserAccount.RESERVER;
    }

    public static boolean validateCapacity(int capacity) throws ValidationException {
        if (capacity <= 0) {
            throw new ValidationException("定員は1名以上で入力してください");
        }
        return true;
    }
}

package com.facility.rsv.beans;

public class UserAccount {
    private int userId;
    private String loginName;
    private String password;
    private String realName;
    private String extensionNumber;
    private String divisionName;
    private int authority;

    public static final int RESERVER = 1;

    public static final int ADMINISTRATOR = 0;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(String extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public UserAccount(int userId, String loginName, String password, String realName, String extensionNumber,
            String divisionName, int authority) {
        this.userId = userId;
        this.loginName = loginName;
        this.password = password;
        this.realName = realName;
        this.extensionNumber = extensionNumber;
        this.divisionName = divisionName;
        this.authority = authority;
    }

    public UserAccount(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

}

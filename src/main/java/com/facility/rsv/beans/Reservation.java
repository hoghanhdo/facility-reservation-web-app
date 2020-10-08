package com.facility.rsv.beans;

public class Reservation {

    private int reservationId;
    private int equipmentId;
    private int userAccountId;
    private String startDate;
    private String endDate;
    private String purpose;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Reservation(int reservationId, int equipmentId, int userAccountId,
            String startDate, String endDate, String purpose) {
        this.reservationId = reservationId;
        this.equipmentId = equipmentId;
        this.userAccountId = userAccountId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.purpose = purpose;
    }

}

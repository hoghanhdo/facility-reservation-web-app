package com.facility.rsv.beans;

public class ReservationInfo {
    private int reservationId;
    private String startDate;
    private String endDate;
    private String purpose;
    private String equipmentName;
    private String reserverName;
    private String department;
    private String extensionNumber;

    public ReservationInfo(int reservationId, String startDate, String endDate, String purpose,
            String equipmentName, String reserverName, String department, String extensionNumber) {
        this.reservationId = reservationId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.purpose = purpose;
        this.equipmentName = equipmentName;
        this.reserverName = reserverName;
        this.department = department;
        this.extensionNumber = extensionNumber;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
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

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getReserverName() {
        return reserverName;
    }

    public void setReserverName(String reserverName) {
        this.reserverName = reserverName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(String extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

}

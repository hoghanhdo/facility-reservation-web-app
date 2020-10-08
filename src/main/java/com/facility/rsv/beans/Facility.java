package com.facility.rsv.beans;

public class Facility {

    private int facilityId;
    private String facilityName;
    private int capacity;
    private String extensionNumber;

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(String extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

    public Facility(int facilityId, String facilityName, int capacity, String extensionNumber) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.capacity = capacity;
        this.extensionNumber = facilityName;
    }

}

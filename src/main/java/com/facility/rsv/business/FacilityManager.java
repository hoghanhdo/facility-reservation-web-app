package com.facility.rsv.business;

import java.util.List;

import com.facility.rsv.dataaccess.FacilityDao;
import com.facility.rsv.dataaccess.exception.DataAccessErrorException;
import com.facility.rsv.dataaccess.exception.DataIOErrorException;
import com.facility.rsv.beans.Facility;
import com.facility.rsv.business.exception.SystemErrorException;

public class FacilityManager {

    private FacilityDao facilityDao;

    public FacilityManager() {
        this.facilityDao = new FacilityDao();
    }

    public List<Facility> showAllFacilities() throws SystemErrorException{
        List<Facility> facilityList;
        try {
            facilityList =  facilityDao.showAllFacilities();
        } catch( DataIOErrorException | DataAccessErrorException e) {
            throw new SystemErrorException ("データベースアクセス関連エラー", e);
        }
        return facilityList;
    }

    public static void main(String[] args){
        FacilityManager facilityManager = new FacilityManager();
        List<Facility> facilityList;
        try{
            facilityList = facilityManager.showAllFacilities();
            for (int i=0; i<facilityList.size(); i++){
                System.out.println(facilityList.get(i).getFacilityName());
            }
        }catch (Exception e){

        }
    }

}

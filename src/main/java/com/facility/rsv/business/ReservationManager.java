package com.facility.rsv.business;

import com.facility.rsv.beans.ReservationInfo;
import com.facility.rsv.business.exception.NotMatchDataException;
import com.facility.rsv.business.exception.SystemErrorException;
import com.facility.rsv.dataaccess.ReservationDao;
import com.facility.rsv.dataaccess.exception.DataAccessErrorException;
import com.facility.rsv.dataaccess.exception.DataIOErrorException;
import com.facility.rsv.dataaccess.exception.DataNotFoundException;

import java.util.List;

public class ReservationManager {
    private ReservationDao reservationDao;

    public ReservationManager() {
        this.reservationDao = new ReservationDao();
    }

    public List<ReservationInfo> findReservation(String facilityName) throws NotMatchDataException, SystemErrorException {

        List<ReservationInfo> reservationInfoList;
        try {
            reservationInfoList = reservationDao.findReservation(facilityName);

        } catch (DataNotFoundException e) {
            throw new NotMatchDataException("該当する予約がありません。", e);
        } catch (DataAccessErrorException | DataIOErrorException e) {
            throw new SystemErrorException("該当する予約がありません。");
        }
        return reservationInfoList;

    }

    public static void main(String[] args){
        ReservationManager reservationManager = new ReservationManager();
        List<ReservationInfo> reservationInfos;
        try{
            reservationInfos = reservationManager.findReservation("応接室");
            for (int i=0; i<reservationInfos.size(); i++){
                System.out.println(reservationInfos.get(i).getReserverName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

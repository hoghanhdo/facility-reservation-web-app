package com.facility.rsv.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.facility.rsv.dataaccess.exception.DataAccessErrorException;
import com.facility.rsv.beans.Facility;
import com.facility.rsv.dataaccess.exception.DataIOErrorException;

public class FacilityDao {
    private static final String SQL_SELECT = "select * from EQUIPMENT";

    public List<Facility> showAllFacilities()
            throws DataAccessErrorException, DataIOErrorException {

        List<Facility> facilityList = new ArrayList<>();

        try {
            Class.forName(DataAccessConstants.DRIVERNAME);
            try (Connection conn = DriverManager.getConnection(DataAccessConstants.URL, DataAccessConstants.USER, DataAccessConstants.PASSWORD);
                 PreparedStatement ps = conn.prepareStatement(SQL_SELECT);
                 ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Facility facility = new Facility(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("capacity"),
                                rs.getString("extension_number"));

                        facilityList.add(facility);
                    }
            } catch (SQLException e) {
                throw new DataAccessErrorException("データベース処理関連エラー。", e);
            }
        } catch (ClassNotFoundException e) {
            throw new DataIOErrorException("データベースアクセスできません。", e);
        }
        return facilityList;
    }

    public static void main(String[] args){
        FacilityDao facilityDao = new FacilityDao();
        List<Facility> facilities;
        try {
            facilities = facilityDao.showAllFacilities();
            for (int i = 0; i< facilities.size(); i++){
                System.out.println(facilities.get(i).getFacilityName());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

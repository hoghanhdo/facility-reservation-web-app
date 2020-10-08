package com.facility.rsv.dataaccess;

import com.facility.rsv.beans.ReservationInfo;
import com.facility.rsv.dataaccess.exception.DataAccessErrorException;
import com.facility.rsv.dataaccess.exception.DataIOErrorException;
import com.facility.rsv.dataaccess.exception.DataNotFoundException;
import com.facility.rsv.utils.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.facility.rsv.dataaccess.DataAccessConstants.*;

public class ReservationDao {

    private static final String SQL_SELECT_RESERVATION = "select u.real_name, u.division_name, u.extension_number,  r.id, r.start_date, r.end_date, r.purpose , e.name " +
            "from USERACCOUNT  u " +
            "join RESERVATION r on u.id = r.useraccount_id  " +
            "join  EQUIPMENT e on r.equipment_id = e.id  " +
            "where e.name like ? ";


    public static List<ReservationInfo> findReservation(String facilityName)
            throws DataNotFoundException, DataIOErrorException, DataAccessErrorException {

        List<ReservationInfo> reservationInfoList = new ArrayList<>();

        try {
            Class.forName(DRIVERNAME);
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement ps = conn.prepareStatement(SQL_SELECT_RESERVATION)) {
                ps.setString(1, facilityName);
                System.out.println(ps);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        ReservationInfo reservationInfo = new ReservationInfo(rs.getInt("id"),
                                StringUtils.formatTimeForView(rs.getString("start_date")),
                                StringUtils.formatTimeForView(rs.getString("end_date")),
                                rs.getString("purpose"),
                                rs.getString("name"),
                                rs.getString("real_name"),
                                rs.getString("division_name"),
                                rs.getString("extension_number"));
                        reservationInfoList.add(reservationInfo);
                    }
                    if (reservationInfoList.size() != 0) {
                        return reservationInfoList;
                    } else {
                        throw new DataNotFoundException("該当する予約がありません。");
                    }
                }
            } catch (SQLException e) {
                throw new DataAccessErrorException("データベース処理関連エラー。", e);
            }
        } catch (ClassNotFoundException e) {
            throw new DataIOErrorException("データベースアクセスできません。", e);
        }

    }

}

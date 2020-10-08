package com.facility.rsv.dataaccess;

import static com.facility.rsv.dataaccess.DataAccessConstants.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.facility.rsv.beans.UserAccount;
import com.facility.rsv.dataaccess.exception.DataAccessErrorException;
import com.facility.rsv.dataaccess.exception.DataIOErrorException;
import com.facility.rsv.dataaccess.exception.DataNotFoundException;

public class UserAccountDao {

    private static final String SQL_SELECT = "select * from USERACCOUNT where LOGIN_NAME like ? and PASSWORD like ?";

    public UserAccount findUserByLoginNameAndPassword(String loginName, String password)
            throws DataNotFoundException, DataAccessErrorException, DataIOErrorException {
        UserAccount userAccount = null;
        try {
            Class.forName(DRIVERNAME);
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                try (PreparedStatement ps = conn.prepareStatement(SQL_SELECT)) {
                    ps.setString(1, loginName);
                    ps.setString(2, password);

                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            userAccount = new UserAccount(rs.getInt("id"),
                                    rs.getString("login_name"),
                                    rs.getString("password"),
                                    rs.getString("real_name"),
                                    rs.getString("extension_number"),
                                    rs.getString("division_name"),
                                    rs.getInt("authority"));
                        } else {
                            throw new DataNotFoundException("ユーザアカウントが見つかりません。");
                        }
                    }
                }
            } catch (SQLException e) {
                throw new DataAccessErrorException("データベース処理関連エラー。", e);
            }
        } catch (ClassNotFoundException e) {
            throw new DataIOErrorException("データベースアクセスできません。", e);
        }
        return userAccount;
    }

    public static void main(String[] args) {
        UserAccountDao accountDao = new UserAccountDao();
        UserAccount user;
        try {
            user = accountDao.findUserByLoginNameAndPassword("tsukimi", "password");
            System.out.println("Hello " + user.getRealName());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

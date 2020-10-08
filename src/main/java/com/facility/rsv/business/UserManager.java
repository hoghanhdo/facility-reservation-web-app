package com.facility.rsv.business;

import com.facility.rsv.beans.UserAccount;
import com.facility.rsv.dataaccess.UserAccountDao;
import com.facility.rsv.business.exception.NotMatchDataException;
import com.facility.rsv.business.exception.SystemErrorException;
import com.facility.rsv.dataaccess.exception.DataAccessErrorException;
import com.facility.rsv.dataaccess.exception.DataIOErrorException;
import com.facility.rsv.dataaccess.exception.DataNotFoundException;

public class UserManager {
    private UserAccountDao userAccountDao;

    public UserManager(){
        this.userAccountDao = new UserAccountDao();
    }

    public UserAccount findUserAccount(String loginName, String password) throws NotMatchDataException, SystemErrorException {
        try {
            return userAccountDao.findUserByLoginNameAndPassword(loginName, password);
        } catch (DataNotFoundException e) {
            throw new NotMatchDataException("ユーザアカウントが見つかりません。", e);
        } catch( DataIOErrorException | DataAccessErrorException e) {
            throw new SystemErrorException ("データベースアクセス関連エラー", e);
        }
    }

}

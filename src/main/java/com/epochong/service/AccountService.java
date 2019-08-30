package com.epochong.service;

import com.epochong.dao.AccountDao;
import com.epochong.po.User;

/**
 * @author epochong
 * @date 2019/8/3 10:38
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class AccountService {
    private AccountDao accountDao = new AccountDao();

    //用户登录
    public boolean userLogin(String userName, String password) {
        User user = accountDao.userLogin(userName,password);
        if (user == null) {
            return false;
        }
        return true;
    }
}

package com.amber.xml.service;

import com.amber.xml.dao.AccountDao;

public class AccountServiceImpl implements AccountService {

    AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transferMoney(String formOne, String toOne, Double money) {

        accountDao.send("jack", money);
//        int i = 1/0;
        accountDao.recive("amber", money);
    }
}

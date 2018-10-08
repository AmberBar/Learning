package com.amber.annotation.service;

import com.amber.annotation.dao.AccountDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * 基于注解的事务管理
 */
@Transactional
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

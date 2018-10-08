package com.amber.xml;

import com.amber.xml.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx_xml.xml")
public class AccountTest {
    @Autowired
    AccountService accountService;

    @Test
    public void test1() {
        accountService.transferMoney("jack", "amber", 100d);
    }
}

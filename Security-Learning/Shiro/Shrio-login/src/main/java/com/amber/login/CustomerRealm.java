package com.amber.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Shiro入门
 */
public class CustomerRealm {
    private static Logger logger = LoggerFactory.getLogger(CustomerRealm.class);
    public static void main(String[] args) {

        //1.获得SecurityManagerFactory
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro_customer_realm.ini");
        //2.通过工厂获得SecurityManager
        SecurityManager securityManager =  iniSecurityManagerFactory.getInstance();
        //3.把SecurityManger放置到运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        try {
            //4.通过SecurityUtis获取subject
            Subject subject =  SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("amber", "111111");
            //登陆
            subject.login(usernamePasswordToken);
            //判断是否通过验证，true代表通过验证
            if (subject.isAuthenticated()) {
                logger.info("login success");
            }
            subject.logout();
        } catch (UnknownAccountException e) {
            logger.error("username or password wrong { }", e);
        } catch (AuthenticationException e) {
            logger.error("login failed ", e);
        }
    }
}

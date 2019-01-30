package com.amber.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Shiro入门
 */
public class RolesDemo {
    static Logger logger = LoggerFactory.getLogger(RolesDemo.class);
    public static void main(String[] args) {

        //1.获得SecurityManagerFactory
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro_roles.ini");
        //2.通过工厂获得SecurityManager
        SecurityManager securityManager =  iniSecurityManagerFactory.getInstance();
        //3.把SecurityManger放置到运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        try {
            //4.通过SecurityUtis获取subject
            Subject subject =  SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("amber", "111111");

            subject.login(usernamePasswordToken);
            //判断是否是admin
            boolean isAdmin = subject.hasRole("admin");
            System.out.println(isAdmin);
            //判断有没有user:add 权限
            boolean permitted = subject.isPermitted("user:add");
            System.out.println(permitted);
            //这种check会抛UnauthorizedException异常
            //subject.checkRole("assa");
        } catch (UnknownAccountException e) {
            logger.error("ERROR incorrect username or passwod", e);
        } catch ( UnauthorizedException e) {
            logger.error("error has no perssion ", e);
        }   catch (AuthenticationException e) {
            logger.error("login failed", e);
        }
    }
}

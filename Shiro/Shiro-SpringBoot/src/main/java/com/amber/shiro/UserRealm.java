package com.amber.shiro;

import com.amber.data.po.Role;
import com.amber.data.po.User;
import com.amber.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException{
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        System.out.println("认证");
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        User user = userService.findUserByUsername(name);
        if (user == null) {
            //这里返回后会报出对应异常
            throw new AuthenticationException("account does not exist");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());
        return simpleAuthenticationInfo;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.findUserByUsername(username);
        List<Role> roles = user.getRoles();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        roles.forEach(role -> {
            String name = role.getName();
            simpleAuthorizationInfo.addRole(name);
            simpleAuthorizationInfo.addStringPermissions(role.getPermssions().stream().map(permssion -> permssion.getName()).collect(Collectors.toSet()));
        });
        System.out.println("授权");
        return simpleAuthorizationInfo;

    }
}

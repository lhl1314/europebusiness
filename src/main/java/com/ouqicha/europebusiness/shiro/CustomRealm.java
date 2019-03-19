package com.ouqicha.europebusiness.shiro;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.service.UserInfoService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //principals.getPrimaryPrincipal()获得的就是当前用户名
        if (principals == null || StringUtils.isBlank((String) principals.getPrimaryPrincipal())) {
            return null;
        }
        //将用户角色信息传入SimpleAuthorizationInfo
        return new SimpleAuthorizationInfo(userInfoService.queryUserRole((String) principals.getPrimaryPrincipal()));

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken == null||StringUtils.isBlank((String) authenticationToken.getPrincipal())) {
            return null;
        }
        //根据token中的用户名查库，获得user对象
//        AccountEntity user = userInfoService.findByMobile1((String) authenticationToken.getPrincipal());
        AccountVO user = userInfoService.findByMobile((String) authenticationToken.getPrincipal());
        if (user == null) {
            return null;
        }
        //SimpleAuthenticationInfo代表该用户的认证信息，其实就是数据库中的用户名、密码、加密密码使用的盐
        //存在数据库中的密码是对用户真是密码通过md5加盐加密得到的，保证安全，及时数据泄露，也得不到真正的用户密码
        //getName()返回该realm的名字，代表该认证信息的来源是该realm，作用不大，一般都是单realm
        //该方法返回后，上层会对token和SimpleAuthenticationInfo进行比较，首先比较Principal()，然后将token的Credentials
        //进行md5加上SimpleAuthenticationInfo中的盐加密，加密结果和SimpleAuthenticationInfo的Credentials比较
//        return new SimpleAuthenticationInfo(
//                user.getMobile(), user.getPassword(), ByteSource.Util.bytes(user.getMobile()), getName());
        return new SimpleAuthenticationInfo(
                user, user.getPassword(), getName());


    }
}

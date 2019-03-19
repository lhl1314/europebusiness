package com.ouqicha.europebusiness.service.impl;

import com.google.common.collect.Sets;
import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.AccountRoleEntity;
import com.ouqicha.europebusiness.bean.vo.AccountVO;
import com.ouqicha.europebusiness.dao.UserInfoDao;
import com.ouqicha.europebusiness.service.UserInfoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserInfoServiceImpl<E> implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    Mapper mapper;
    @Override
    public AccountVO findByMobile(String userName) {
        AccountEntity entity = userInfoDao.findByMobile(userName);
//        e = (AccountEntity)entity;
        AccountVO desc = mapper.map(entity, AccountVO.class);
//        AccountVO desc1 = transforEntity(AccountVO.class, e);
        return desc;
    }
    @Override
    public AccountEntity findByMobile1(String userName) {
        AccountEntity entity = userInfoDao.findByMobile(userName);
        //AccountVO desc = mapper.map(entity, AccountVO.class);
        return entity;
    }

    //根据用户名获得用户的所有角色
    @Override
    public Set<String> queryUserRole(String userName) {
        AccountEntity user = userInfoDao.findByMobile(userName);
        if (user == null) {
            return Collections.emptySet();
        }
        Collection<AccountRoleEntity> roles =  user.getAccountRolesById();
        List<String> roleList = new ArrayList<String>();
        for(AccountRoleEntity role : roles){
            roleList.add(role.getRoleByRoleId().getRoleName());
        }
        return Sets.newHashSet(roleList);
    }

    @Override
    public void saveAccount(AccountEntity accountEntity) throws Exception {
        userInfoDao.save(accountEntity);
    }


}

package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.UserEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserInfoDaoImp implements UserInfoDao {
    @Autowired
    private BaseDao<AccountEntity> baseDao;

//    public BaseDao<AccountEntity> getBaseDao() {
//        return baseDao;
//    }
//
//    public void setBaseDao(BaseDao<AccountEntity> baseDao) {
//        this.baseDao = baseDao;
//    }
    @Override
    public AccountEntity Login(String LoginName, String Password) {
        return null;
    }

    @Transactional
    @Override
    public AccountEntity findByEmail(String param) {
        String hql="From AccountEntity where email=?";
        return baseDao.get(hql, new Object[]{param});
    }

    @Transactional
    @Override
    public AccountEntity findByMobile(String param) {
        String hql="From AccountEntity where mobile=?";
        return baseDao.get(hql, new Object[]{param}, null);
    }

    @Override
    public Integer count(String param) {
        return null;
    }

    @Override
    public void saveOrUpdate(AccountEntity accountEntity) {

    }

    @Transactional
    @Override
    public void save(AccountEntity accountEntity) throws Exception {
        baseDao.save(accountEntity);
    }

    @Override
    public void update(AccountEntity accountEntity) {

    }

    @Override
    public AccountEntity get(Integer id) {
        return null;
    }
}

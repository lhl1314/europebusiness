package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;

public interface UserInfoDao {
    public AccountEntity Login(String LoginName, String Password);

    public AccountEntity findByEmail(String param);

    public AccountEntity findByMobile(String param);

    public Integer count(String param);

    public void saveOrUpdate(AccountEntity accountEntity);

    public void save(AccountEntity accountEntity) throws Exception;

    public void update(AccountEntity accountEntity);

    public AccountEntity get(Integer id);
}

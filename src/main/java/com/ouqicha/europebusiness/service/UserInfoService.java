package com.ouqicha.europebusiness.service;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.vo.AccountVO;

import java.util.Set;

public interface UserInfoService {

    /**
     * 根据电话号码获得 AccountVO 对象
     * @param params 电话号码
     */
    public AccountVO findByMobile(String params);

    /**
     *根据电话号码获得AccountEntity对象
     * @param params 电话号码
     * @return
     */
    public AccountEntity findByMobile1(String params);

    /**
     * 根据用户名获得用户的所有角色
     * @param userName 用户名
     */
    public Set<String> queryUserRole(String userName);

    /**
     * 保存账号信息
     * @param accountEntity
     */
    public void saveAccount(AccountEntity accountEntity) throws Exception;




//    public <T> T transforEntity(Class<T> clazz, E e);



}

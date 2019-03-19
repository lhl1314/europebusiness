package com.ouqicha.europebusiness.dao.impl;

import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.dao.BaseDao;
import com.ouqicha.europebusiness.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {

    @Autowired
    private BaseDao<CompanyEntity> baseDao;

    @Transactional
    @Override
    public List<CompanyEntity> getCompanyList(Integer page, Integer rows) {
        String hql="From CompanyEntity";
        return baseDao.find(hql, new Object[]{}, page, rows);
    }
}

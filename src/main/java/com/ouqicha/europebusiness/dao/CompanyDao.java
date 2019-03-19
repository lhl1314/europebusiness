package com.ouqicha.europebusiness.dao;

import com.ouqicha.europebusiness.bean.entity.CompanyEntity;

import java.util.List;

public interface CompanyDao {
    public List<CompanyEntity> getCompanyList(Integer page, Integer rows);
}

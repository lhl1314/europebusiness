package com.ouqicha.europebusiness.service;

import com.ouqicha.europebusiness.bean.entity.CompanyEntity;

import java.util.List;

public interface CompanyService {
    public List<CompanyEntity> getCompanyList(Integer page, Integer rows);
}

package com.ouqicha.europebusiness.service.impl;

import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.dao.CompanyDao;
import com.ouqicha.europebusiness.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;
    @Override
    public List<CompanyEntity> getCompanyList(Integer page, Integer rows){
        return companyDao.getCompanyList(page, rows);
    }
}

package com.ouqicha.europebusiness.bean.vo;

import com.ouqicha.europebusiness.bean.entity.AccountEntity;
import com.ouqicha.europebusiness.bean.entity.CompanyEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "person", schema = "europe", catalog = "")
public class PersonVO implements Serializable {
    private static final long serialVersionUID = 7609725784867829359L;
    private int id;
    private String mobile;
    private String email;
    private Integer sex;
    private String job;
    private CompanyVO company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public CompanyVO getCompany() {
        return company;
    }

    public void setCompany(CompanyVO company) {
        this.company = company;
    }
}

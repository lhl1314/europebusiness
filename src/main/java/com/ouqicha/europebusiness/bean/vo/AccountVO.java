package com.ouqicha.europebusiness.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.ouqicha.europebusiness.bean.entity.AccountRoleEntity;
import com.ouqicha.europebusiness.bean.entity.CompanyEntity;
import com.ouqicha.europebusiness.bean.entity.PersonEntity;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;


public class AccountVO implements Serializable {
    private static final long serialVersionUID = 4008904644374391242L;
    private int id;
    private String mobile;
    private String email;
    private String type;
    @JSONField(serialize = false)
    private  String password;
    @JSONField(serialize = false)
    private PersonVO person;
    @JSONField(serialize = false)
    private CompanyVO company;
    private Collection<AccountRoleVO> accountRoles;
    private String token;
    private Integer deviceType;
    private String deviceInfo;
    private Timestamp lastLoginTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public PersonVO getPerson() {
        return person;
    }

    public void setPerson(PersonVO person) {
        this.person = person;
    }

    public CompanyVO getCompany() {
        return company;
    }

    public void setCompany(CompanyVO company) {
        this.company = company;
    }

    public Collection<AccountRoleVO> getAccountRoles() {
        return accountRoles;
    }

    public void setAccountRoles(Collection<AccountRoleVO> accountRoles) {
        this.accountRoles = accountRoles;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}

package com.ouqicha.europebusiness.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "role_permission", schema = "europe", catalog = "")
public class RolePermissionEntity {
    private int id;
    private Timestamp gmtCreate;
    private Timestamp gmtUpdate;
    private Integer isDelete;
    private PermissionEntity permissionByPermissionId;
    private RoleEntity roleByRoleId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gmt_create")
    @org.hibernate.annotations.Generated(org.hibernate.annotations.GenerationTime.ALWAYS)
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_update")
    @org.hibernate.annotations.Generated(org.hibernate.annotations.GenerationTime.ALWAYS)
    public Timestamp getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Timestamp gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    @Basic
    @Column(name = "is_delete")
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePermissionEntity that = (RolePermissionEntity) o;

        if (id != that.id) return false;
        if (gmtCreate != null ? !gmtCreate.equals(that.gmtCreate) : that.gmtCreate != null) return false;
        if (gmtUpdate != null ? !gmtUpdate.equals(that.gmtUpdate) : that.gmtUpdate != null) return false;
        if (isDelete != null ? !isDelete.equals(that.isDelete) : that.isDelete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtUpdate != null ? gmtUpdate.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "permission_id", referencedColumnName = "id")
    public PermissionEntity getPermissionByPermissionId() {
        return permissionByPermissionId;
    }

    public void setPermissionByPermissionId(PermissionEntity permissionByPermissionId) {
        this.permissionByPermissionId = permissionByPermissionId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}

package com.tdkglobal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRolePK implements Serializable {
    private Long roleId;
    private String role;
    public int hashCode() {
        return (int) roleId.hashCode() + (int) role.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof UserRolePK pk)) return false;
        return Objects.equals(pk.roleId, roleId) && pk.role.equals(role);
    }

    @Override
    public String toString() {
        return "UserRolePK{" +
                "roleId=" + roleId +
                ", role='" + role + '\'' +
                '}';
    }
}

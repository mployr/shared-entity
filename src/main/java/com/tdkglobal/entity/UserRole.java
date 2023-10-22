package com.tdkglobal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@IdClass(UserRolePK.class)
public class UserRole {
    @Id
    @GeneratedValue
    private Long roleId;
    @Column(length = 32)
    @Id
    private String role;
    @Column(length = 32)
    private String access;
    public int hashCode() {
        return (int) roleId.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof UserRole pk)) return false;
        return Objects.equals(pk.roleId, roleId);
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "roleId=" + roleId +
                ", role='" + role + '\'' +
                ", access='" + access + '\'' +
                '}';
    }
}

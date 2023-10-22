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
public class UserType {
    @Id
    @GeneratedValue
    @Column(name="user_type_id", nullable = false,updatable = false )
    private Long userTypeId;
    @Column(length = 32)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserData userData;

    public int hashCode() {
        return userTypeId.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof UserType)) return false;
        UserType pk = (UserType) obj;
        return Objects.equals(pk.userTypeId, userTypeId);
    }

    @Override
    public String toString() {
        return "UserType{" +
                "userTypeId=" + userTypeId +
                ", description='" + description + '\'' +
                '}';
    }
}

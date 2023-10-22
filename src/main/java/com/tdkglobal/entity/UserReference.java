package com.tdkglobal.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserReference {
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String organization;

    @Column(length = 100)
    private String role;

    @Column(length = 14)
    private String phone;

    @Column(length = 14)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id")
    @Getter @Setter
    private UserData userData;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserReference that = (UserReference) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(organization, that.organization) && Objects.equals(role, that.role) && Objects.equals(phone, that.phone) && Objects.equals(status, that.status) && Objects.equals(userData, that.userData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, organization, role, phone, status, userData);
    }
}

package com.tdkglobal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserShift {
    @Id
    @Column(name ="UserShift_ID",updatable = false, nullable = false)
    @GeneratedValue
    private Long id;
    @Column(length = 32)
    private String preferredShiftDays;
    @Column(length = 32)
    private String PreferredShiftTime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserData userData;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserShift userShift = (UserShift) o;
        return Objects.equals(id, userShift.id) && Objects.equals(preferredShiftDays, userShift.preferredShiftDays) && Objects.equals(PreferredShiftTime, userShift.PreferredShiftTime) && Objects.equals(userData, userShift.userData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, preferredShiftDays, PreferredShiftTime, userData);
    }
}

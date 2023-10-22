package com.tdkglobal.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInterview {
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue
    private Long id;
    @Column(name = "QID")
    private int qid;
    @Column(name="QResponse")
    private String qResponse;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id")
    @Getter @Setter
    private UserData userData;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInterview that = (UserInterview) o;
        return qid == that.qid && Objects.equals(id, that.id) && Objects.equals(qResponse, that.qResponse) && Objects.equals(userData, that.userData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qid, qResponse, userData);
    }
}

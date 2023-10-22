package com.tdkglobal.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTrainings {
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue
    @Getter @Setter
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id")
    @Getter @Setter
    private UserData userData;

    @Column(length = 32)
    private String trainingTitle;

    @Getter @Setter
    @Lob
    @Column
    private Blob certificate;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTrainings that = (UserTrainings) o;
        return Objects.equals(id, that.id) && Objects.equals(userData, that.userData) && Objects.equals(trainingTitle, that.trainingTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userData, trainingTitle);
    }

}

package com.tdkglobal.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserData {
    @Id
    @GeneratedValue
    @Getter @Setter
    @Column(name="user_id",nullable = false,updatable=false)
    private Long userId;

    @Getter @Setter
    @Column(length = 32)
    private String role;

    @Getter @Setter
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userData", fetch = FetchType.LAZY)
    private Company company;

    @Getter @Setter
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userData", fetch = FetchType.LAZY)
    private UserShift userShift;

    @Getter @Setter
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userData", fetch = FetchType.LAZY)
    private UserType userType;

    @Getter @Setter
    @Column(length = 32)
    private  String firstName;

    @Getter @Setter
    @Column(length = 32)
    private String lastName;

    @Getter @Setter
    @Column(length = 32)
    private String pw;

    @Getter @Setter
    @Column(unique=true,length = 100)
    private String email;

    @Getter @Setter
    @Column(length = 14)
    private String phone;

    @Getter @Setter
    private Long userTypeId;

    @Getter @Setter
    @Lob
    private Blob photo;

    @Getter @Setter
    @Lob
    private Blob photoIdProof;

    @Getter @Setter
    @Column(length = 100)
    private String addressFirstLine;

    @Getter @Setter
    @Column(length = 100)
    private String addressSecondLine;

    @Getter @Setter
    @Column(length = 32)
    private String city;

    @Getter @Setter
    @Column(length = 32)
    private String country;

    @Getter @Setter
    @Column(length = 8)
    private String postCode;

    @Getter @Setter
    @Lob
    private Blob dBS;

    @Getter @Setter
    private Timestamp startDate;

    @Getter @Setter
    private boolean complianceStatus;

    @Getter @Setter
    @Column(length = 10)
    private String status;

    @Getter @Setter
    @Column(length = 200)
    private String complianceRemark;

    @Getter @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userData")
    private Set<UserTrainings> userTrainings = new HashSet<>();

    @Getter @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userData")
    private Set<UserReference> userReference = new HashSet<>();

    @Getter @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userData")
    private Set<UserInterview> userInterviews = new HashSet<>();

    public int hashCode() {
        return email.hashCode() + userId.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof UserData pk)) return false;
        return pk.userId.equals(userId) && pk.email.equals(email);
    }

}

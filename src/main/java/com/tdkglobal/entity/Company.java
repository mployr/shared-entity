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
public class Company {
    @Id
    @Column(name ="Company_Id", updatable = false, nullable = false)
    @GeneratedValue
    @Getter @Setter
    private Long companyId;

    @Column(length = 100)
    @Getter @Setter
    private String companyName;

    @Getter @Setter
    private int subscriptionId;

    @Getter @Setter
    private boolean toaStatus;

    @Getter @Setter
    private Timestamp registrationDate;

    @Getter @Setter
    @Lob
    private Blob signature;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserData userData;

    @Getter @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Set<Sites> sites = new HashSet<>();

    @Getter @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Set<SubscriptionStatus> subscriptionStatuses = new HashSet<>();
    public int hashCode() {
        return companyId.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Company pk)) return false;
        return pk.companyId.equals(companyId);
    }

}

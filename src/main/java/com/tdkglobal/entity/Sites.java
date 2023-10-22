package com.tdkglobal.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Sites {
    @Id
    @GeneratedValue
    @Column(name ="SITE_ID", updatable = false, nullable = false)
    @Getter @Setter
    private long siteId;

    @Getter @Setter
    @Column(length = 32)
    private String siteName;

    @Getter @Setter
    @Column(length = 100)
    private String siteAddress1;

    @Getter @Setter
    @Column(length = 100)
    private String siteAddress2;

    @Getter @Setter
    @Column(length = 32)
    private String siteCity;

    @Getter @Setter
    @Column(length = 32)
    private String siteCountry;

    @Getter @Setter
    @Column(length = 8)
    private String sitePostCode;

    @Getter @Setter
    private int patients;

    @Getter @Setter
    @Column(length = 32)
    private String facilityManager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_Id")
    @Getter @Setter
    private Company company;
    public int hashCode() {
        return (int) siteId;
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Sites pk)) return false;
        return pk.siteId == siteId;
    }

}

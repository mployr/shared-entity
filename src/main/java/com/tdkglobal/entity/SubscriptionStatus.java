package com.tdkglobal.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubscriptionStatus {
    @Id
    @GeneratedValue
    @Column(name="Subscription_Status_Id", nullable = false,updatable = false )
    private Long subscriptionStatusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SubscriptionId")
    private Subscription subscription;

    @Column
    private Timestamp subscriptionDate;

    @Column
    private Timestamp endDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionStatus that = (SubscriptionStatus) o;
        return Objects.equals(subscriptionStatusId, that.subscriptionStatusId) && Objects.equals(company, that.company) && Objects.equals(subscription, that.subscription) && Objects.equals(subscriptionDate, that.subscriptionDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionStatusId, company, subscription, subscriptionDate, endDate);
    }
}

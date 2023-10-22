package com.tdkglobal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subscription {
    @Id
    @GeneratedValue
    @Column(name="SubscriptionId", nullable = false,updatable = false )
    private Long subscriptionId;

    @Column(length = 32)
    private String subscriptionTitle;

    @Column(length = 32)
    private String parameter;

    @Column
    private String volume;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subscription")
    private Set<SubscriptionStatus> subscriptionStatuses = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(subscriptionId, that.subscriptionId) && Objects.equals(subscriptionTitle, that.subscriptionTitle) && Objects.equals(parameter, that.parameter) && Objects.equals(volume, that.volume) && Objects.equals(subscriptionStatuses, that.subscriptionStatuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionId, subscriptionTitle, parameter, volume, subscriptionStatuses);
    }
}

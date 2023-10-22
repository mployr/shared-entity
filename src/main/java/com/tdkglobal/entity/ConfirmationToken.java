package com.tdkglobal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @Id
    @UuidGenerator
    private String tokenId;
    @Column(unique=true,length = 100)
    private String email;
    private Timestamp createdDate;
    public int hashCode() {
        return (int) tokenId.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof ConfirmationToken pk)) return false;
        return pk.email.equals(email) && pk.tokenId.equals(tokenId);
    }

    @Override
    public String toString() {
        return "ConfirmationToken{" +
                "tokenId='" + tokenId + '\'' +
                ", email='" + email + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}

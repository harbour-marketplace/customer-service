package com.harbour.customer.entity;

import com.harbour.customer.entity.enums.CustomerStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;
import static org.hibernate.annotations.UuidGenerator.Style.VERSION_7;

@Entity
@Table(name = "customers", schema = "profile")
public class Customer extends AuditedEntity {

    @Id
    @GeneratedValue
    @UuidGenerator(style = VERSION_7)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Enumerated(STRING)
    @Column(name = "status", nullable = false)
    private CustomerStatus status;

    protected Customer() {
    }

    private Customer(CustomerStatus status) {
        this.status = status;
    }

    public static Customer create() {
        return new Customer(CustomerStatus.ACTIVE);
    }

    public void suspend() {
        this.status = CustomerStatus.SUSPENDED;
    }

    public void activate() {
        this.status = CustomerStatus.ACTIVE;
    }

    public UUID getId() {
        return id;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Customer that)) {
            return false;
        }
        return id != null && id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Customer.class.hashCode();
    }

}

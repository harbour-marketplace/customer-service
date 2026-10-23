package com.harbour.customer.entity;

import com.harbour.customer.entity.enums.ContactType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;
import static org.hibernate.annotations.UuidGenerator.Style.VERSION_7;

@Entity
@Table(name = "contact_details", schema = "profile")
public class ContactDetails extends AuditedEntity {

    @Id
    @GeneratedValue
    @UuidGenerator(style = VERSION_7)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Enumerated(STRING)
    @Column(name = "contact_type", nullable = false)
    private ContactType contactType;

    @Column(name = "contact_value", nullable = false)
    private String contactValue;

    @Column(name = "is_primary", nullable = false)
    private boolean primary;

    protected ContactDetails() {
    }

    public ContactDetails(Customer customer, ContactType contactType, String contactValue, boolean primary) {
        this.customer = customer;
        this.contactType = contactType;
        this.contactValue = contactValue;
        this.primary = primary;
    }

    public UUID getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getContactValue() {
        return contactValue;
    }

    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void markAsPrimary() {
        this.primary = true;
    }

    public void markAsSecondary() {
        this.primary = false;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContactDetails that)) {
            return false;
        }
        return id != null && id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        return ContactDetails.class.hashCode();
    }

}

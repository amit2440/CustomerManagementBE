package com.customermanagement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Amit Raut on 5/16/2018.
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "connectionId")
public class Connection implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Summary.class)
    private Long connectionId;

    @NotNull
    @JsonView(View.Summary.class)
    private String connectionName;

    @JsonView(View.Summary.class)
    private String connectionStatus;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    @JsonView(View.Summary.class)
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="connection")
    @JsonView(View.Summary.class)
    private Set<Payment> payments;

    @OneToOne(fetch = FetchType.EAGER,mappedBy="connection")
    //@JsonManagedReference
    @JsonView(View.Summary.class)
    private Address addresses;

    @NotNull
    @JsonView(View.Summary.class)
    private LocalDate connectionDate;

    public Address getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }

    public Long getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(Long connectionId) {
        this.connectionId = connectionId;
    }

    public String getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public LocalDate getConnectionDate() {
        return connectionDate;
    }

    public void setConnectionDate(LocalDate connectionDate) {
        this.connectionDate = connectionDate;
    }
}

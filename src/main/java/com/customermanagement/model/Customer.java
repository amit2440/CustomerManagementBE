package com.customermanagement.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Amit Raut
 */
@Entity
@Table(name = "customer")
/*@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)*/
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "customerId")
public class Customer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String lastName;

    private String userName;
/*

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
*/
    @NotNull
    private Long mobileNo;

    @Email
    @NotNull
    private String emailId;
    /*@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;*/

    @OneToMany(fetch = FetchType.EAGER,mappedBy="connectionCustomer")
     private Set<Connection> connections;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="customer")
    //@JsonManagedReference
    private Set<Address> addresses;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Set<Connection> getConnections() {
        return connections;
    }

    public void setConnections(Set<Connection> connections) {
        this.connections = connections;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}

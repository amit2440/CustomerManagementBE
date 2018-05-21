package com.customermanagement.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

/**
 * Created by Amit Raut on 5/16/2018.
 */

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "addressId")
public class Address implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Summary.class)
        private Long addressId;

        @JsonView(View.Summary.class)
        private String address;

        @JsonView(View.Summary.class)
        private String city;

        @JsonView(View.Summary.class)
        private String country;

        @JsonView(View.Summary.class)
        private Integer pinCode;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "connection")
    //@JsonBackReference
    private Connection connection;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}

package com.customermanagement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by Amit Raut on 5/16/2018.
 */

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "paymentId")
public class Payment implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String paymentId;

    @NotNull
    private String paymentStatus;

    @NotNull
    private LocalDate date;

    @NotNull
    private BigDecimal paymentAmount;

    private String paymentMethod;

    @NotNull
    private LocalDate paymentFrom;

    @NotNull
    private LocalDate paymentTo;

    @NotNull
    private String internetPlan;

    private String invoiceNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "connection_Id")
    private Connection connection;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getPaymentFrom() {
        return paymentFrom;
    }

    public void setPaymentFrom(LocalDate paymentFrom) {
        this.paymentFrom = paymentFrom;
    }

    public LocalDate getPaymentTo() {
        return paymentTo;
    }

    public void setPaymentTo(LocalDate paymentTo) {
        this.paymentTo = paymentTo;
    }

    public String getInternetPlan() {
        return internetPlan;
    }

    public void setInternetPlan(String internetPlan) {
        this.internetPlan = internetPlan;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}

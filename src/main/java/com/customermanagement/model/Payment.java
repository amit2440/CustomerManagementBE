package com.customermanagement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
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
@SequenceGenerator(name="payment_seq", initialValue=1000, allocationSize=1,sequenceName = "PAY_SEQ")
public class Payment implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="payment_seq")
    @JsonView(View.Summary.class)
    private Long paymentId;

    @NotNull
    @JsonView(View.Summary.class)
    private String paymentStatus;

    @NotNull
    @JsonView(View.Summary.class)
    private LocalDate date;

    @NotNull
    @JsonView(View.Summary.class)
    private BigDecimal paymentAmount;

    @JsonView(View.Summary.class)
    private String paymentMethod;

    @NotNull
    @JsonView(View.Summary.class)
    private LocalDate paymentFrom;

    @NotNull
    @JsonView(View.Summary.class)
    private LocalDate paymentTo;

    @NotNull
    @JsonView(View.Summary.class)
    private String internetPlan;

    @JsonView(View.Summary.class)
    private String invoiceNo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "connection_Id")
    private Connection connection;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
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

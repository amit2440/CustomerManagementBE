package com.customermanagement.repository;

import com.customermanagement.model.Connection;
import com.customermanagement.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by P10433805 on 5/18/2018.
 */
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    @Query("select max(invoiceNo) from Payment")
    public String findMaxInvoiceNo();

    @Modifying
    @Query("update Payment set invoiceNo =:invoiceNo, paymentMethod =:paymentMethod, paymentAmount=:paymentAmount, paymentStatus=:paymentStatus, internetPlan =:internetPlan ,date=:date where paymentId =:paymentId")
    public Integer updatePayment(@Param("invoiceNo") String invoiceNo,
                                 @Param("paymentMethod") String paymentMethod,
                                 @Param("paymentAmount")BigDecimal paymentAmount,
                                 @Param("paymentStatus") String paymentStatus,
                                 @Param("internetPlan") String internetPlan,
                                 @Param("paymentId") Long paymentId,
                                 @Param("date") LocalDate date);
}

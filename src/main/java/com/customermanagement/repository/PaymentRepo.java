package com.customermanagement.repository;

import com.customermanagement.model.Connection;
import com.customermanagement.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by P10433805 on 5/18/2018.
 */
public interface PaymentRepo extends JpaRepository<Payment, Long> {
}

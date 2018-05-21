package com.customermanagement.repository;

import com.customermanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Amit Raut on 16/05/2017
 */

@Repository
public interface CustManagementRepo extends JpaRepository<Customer, Long> {

    public Optional<List<Customer>> findByMobileNo(Long mobileNo);
}

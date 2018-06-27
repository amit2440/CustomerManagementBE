package com.customermanagement.repository;

import com.customermanagement.model.Address;
import com.customermanagement.model.Connection;
import com.customermanagement.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by P10433805 on 6/27/2018.
 */
@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {


}

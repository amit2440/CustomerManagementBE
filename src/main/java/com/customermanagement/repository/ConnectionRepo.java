package com.customermanagement.repository;

import com.customermanagement.model.Connection;
import com.customermanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Amit Raut on 5/18/2018.
 */
@Repository
public interface ConnectionRepo  extends JpaRepository<Connection, Long> {
}

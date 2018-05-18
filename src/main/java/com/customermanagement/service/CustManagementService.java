package com.customermanagement.service;

import com.customermanagement.model.Connection;
import com.customermanagement.model.Customer;
import com.customermanagement.repository.ConnectionRepo;
import com.customermanagement.repository.CustManagementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Amit Raut on 5/18/2018.
 */

@Service
public class CustManagementService {

    @Autowired
    CustManagementRepo custManagementRepo;

    @Autowired
    ConnectionRepo connectionRepo;

    public List<Customer> getAllCustomers(){
        return custManagementRepo.findAll();
    }

    public List<Connection> getAllConnections(){
        return connectionRepo.findAll();
    }
}

package com.customermanagement.service;

import com.customermanagement.model.Connection;
import com.customermanagement.model.Customer;
import com.customermanagement.model.Payment;
import com.customermanagement.repository.ConnectionRepo;
import com.customermanagement.repository.CustManagementRepo;
import com.customermanagement.repository.PaymentRepo;
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

    @Autowired
    PaymentRepo paymentRepo;

    public List<Customer> getAllCustomers(){
        return custManagementRepo.findAll();
    }

    public List<Connection> getAllConnections(){
        return connectionRepo.findAll();
    }

    public List<Payment> getAllPayments(){
        return paymentRepo.findAll();
    }

    public boolean createCustomer(Customer customer) {
        try {
            if (custManagementRepo.findByMobileNo(customer.getMobileNo()).isPresent()) {
                return false;
            }
            custManagementRepo.save(customer);
            return true;
        }catch (Exception e) {
            throw e;
        }
    }

    public void createConnection(Connection conn) {
        connectionRepo.save(conn);
    }




}

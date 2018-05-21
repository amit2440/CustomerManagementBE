package com.customermanagement.controller;

import com.customermanagement.exception.ResourceNotFoundException;
import com.customermanagement.model.Connection;
import com.customermanagement.model.Customer;
import com.customermanagement.model.Payment;
import com.customermanagement.model.View;
import com.customermanagement.repository.CustManagementRepo;
import com.customermanagement.service.CustManagementService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Amit Raut
 */
@RestController
@RequestMapping("/custManagement")
public class CustManagementController {

    @Autowired
    CustManagementService custManagementService;

    @GetMapping("/allCustomers")
    public List<Customer> getAllCustomers() {
        return custManagementService.getAllCustomers();
    }

    @GetMapping("/allConnections")
    @JsonView(View.Summary.class)
    public List<Connection> getAllConnections() {
        return custManagementService.getAllConnections();
    }

    @GetMapping("/allPayments")
    public List<Payment> getAllPayments() {
        return custManagementService.getAllPayments();
    }


/*
    @PostMapping("/notes")
    public Customer createNote(@Valid @RequestBody Customer customer) {
        return custManagementRepo.save(customer);
    }

    @GetMapping("/notes/{id}")
    public Customer getNoteById(@PathVariable(value = "id") Long noteId) {
        return custManagementRepo.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", noteId));
    }

    @PutMapping("/notes/{id}")
    public Customer updateNote(@PathVariable(value = "id") Long noteId,
                               @Valid @RequestBody Customer customerDetails) {

        Customer customer = custManagementRepo.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", noteId));

        customer.setTitle(customerDetails.getTitle());
        customer.setContent(customerDetails.getContent());

        Customer updatedCustomer = custManagementRepo.save(customer);
        return updatedCustomer;
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Customer customer = custManagementRepo.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", noteId));

        custManagementRepo.delete(customer);

        return ResponseEntity.ok().build();
    }*/
}

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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Amit Raut
 */
@RestController
@RequestMapping("/custManagement")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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

    @Transactional
    @PostMapping(value="/createCustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  createCustomer(@RequestBody Customer customer){
        try {
            if (custManagementService.createCustomer(customer))
                return ResponseEntity.ok().build();
            throw new RuntimeException("User with same mobile no already exists");
        }catch(Exception e) {
            throw e;
        }
    }

    @Transactional
    @PostMapping(value="/createConnection", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  createConnection(@RequestBody Connection conn){
        conn.getAddresses().setConnection(conn);
        custManagementService.createConnection(conn);
                return ResponseEntity.ok().build();


    }

    @Transactional
    @PostMapping(value="/addPayment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  addPayment(@RequestBody Payment payment){
        custManagementService.addPayment(payment);
        return ResponseEntity.ok().build();

    }

    @Transactional
    @PostMapping("/profile/uploadpicture")
    public ResponseEntity < String > handleFileUpload(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
           // fileservice.store(file);
            File convFile = new File(file.getOriginalFilename());
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
            custManagementService.sendEmail(convFile);
            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Fail to upload Profile Picture" + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
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

    @GetMapping("/getMaxInvoiceNo")
    public Payment getMaxInvoiceNo() {
        Payment p = new Payment();
        p.setInvoiceNo(custManagementService.findMaxInvoiceNo());
        return p;
    }

    @Transactional
    @PostMapping(value="/updatePayment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  updatePayment(@RequestBody Payment payment){
        //conn.getAddresses().setConnection(conn);
       // custManagementService.createConnection(conn);
        custManagementService.updatePayment(payment);
        return ResponseEntity.ok().build();


    }
}

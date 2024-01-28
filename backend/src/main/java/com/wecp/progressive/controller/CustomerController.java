package com.wecp.progressive.controller;


import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.CustomerServiceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;
    
    @GetMapping("/customers")
    public ResponseEntity<List<Customers>> getAllCustomers() throws SQLException {
        return new ResponseEntity<List<Customers>>(customerService.getAllCustomers(), HttpStatus.OK);
    }
    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customers> getCustomerById(int customerId) throws SQLException {
        
        return new ResponseEntity<Customers>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
    @PostMapping("/customers")
     public ResponseEntity<Integer> addCustomer(Customers customers) throws SQLException {
        return new ResponseEntity<Integer>(customerService.addCustomer(customers), HttpStatus.OK);
    }
    @PutMapping("/customers/{customerId}")
     public ResponseEntity<Void> updateCustomer(int customerId, Customers customers) throws SQLException {
        customerService.updateCustomer(customers);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<Void> deleteCustomer(int customerId) throws SQLException {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<Transactions>> getAllTransactionsByCustomerId(int cutomerId) {
       // return new ResponseEntity<List<Transactions>>(customerService.getA, null);
       return null;
    }
}

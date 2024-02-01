package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.exception.AccountNotFoundException;
import com.wecp.progressive.service.AccountServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountServiceImplJpa accountServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Accounts>> getAllAccounts() throws SQLException {
        List<Accounts> list = accountServiceImplJpa.getAllAccounts();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Accounts> getAccountById(int accountId) throws SQLException, AccountNotFoundException {
        Accounts accounts = accountServiceImplJpa.getAccountById(accountId);
        return new ResponseEntity<Accounts>(accounts, HttpStatus.OK);
    }

    @GetMapping("/user/{customerId}")
    public ResponseEntity<List<Accounts>> getAccountsByUser(@PathVariable int customerId) throws SQLException {
        return new ResponseEntity<>(accountServiceImplJpa.getAccountsByUser(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> addAccount(Accounts accounts) throws SQLException {
        int id = accountServiceImplJpa.addAccount(accounts);
        return new ResponseEntity<>(id,HttpStatus.CREATED);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<Void> updateAccount(int accountId, Accounts accounts) throws SQLException {
        accountServiceImplJpa.updateAccount(accounts);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(int accountId) throws SQLException {
        accountServiceImplJpa.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
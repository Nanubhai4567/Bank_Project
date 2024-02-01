package com.wecp.progressive.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.exception.AccountNotFoundException;
import com.wecp.progressive.repository.AccountRepository;

@Service
public class AccountServiceImplJpa implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    private List<Accounts> list = new ArrayList<>();

    

    public AccountServiceImplJpa(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        return accountRepository.findAll();
    }

    @Override
    public List<Accounts> getAccountsByUser(int userId) throws SQLException {
        //return accountRepository.findByAccountsByUser();
        return accountRepository.findByCustomerId(userId);
    }

    @Override
    public Accounts getAccountById(int accountId) throws AccountNotFoundException ,SQLException {
        Accounts accounts = accountRepository.findById(accountId).orElse(new Accounts());
        if(accounts.getAccountId() == null){
            throw new AccountNotFoundException("Account not found.");
        }
        return accounts;
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        return accountRepository.save(accounts).getAccountId();
    }

    @Override
    public void updateAccount(Accounts accounts) throws SQLException {
        // accountRepository.findById(accounts.getAccountId()).map(a -> {
        //     a.setBalance(accounts.getBalance());
        //     a.setCustomerId(accounts.getCustomerId());
        //     return a;
        // });
        accountRepository.save(accounts);
    }

    @Override
    public void deleteAccount(int accountId) throws SQLException {
        accountRepository.deleteById(accountId);
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        return accountRepository.findByOrderByBalance();
    }

    @Override
    public List<Accounts> getAllAccountsFromArrayList() {
        return list;
    }

    @Override
    public List<Accounts> addAccountToArrayList(Accounts accounts) {
        list.add(accounts);
        return list;
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalanceFromArrayList() {
        List<Accounts> sortedList = list;
        Collections.sort(sortedList);
        return sortedList;
    }

    @Override
    public void emptyArrayList() {
        list = new ArrayList<>();
    }
    
}
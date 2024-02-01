package com.wecp.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Accounts;


@Repository
public interface AccountRepository extends JpaRepository<Accounts,Integer> {
    public List<Accounts> findByCustomerId(int customerId);
    public List<Accounts> findByOrderByBalance();
    //public List<Accounts> findByAccountsByUser();
}
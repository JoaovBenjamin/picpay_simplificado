package com.example.picpay_project.repository;

import com.example.picpay_project.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrasactionRepository extends JpaRepository<Transaction, Long> {
}

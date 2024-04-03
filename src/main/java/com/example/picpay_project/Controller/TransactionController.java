package com.example.picpay_project.Controller;

import com.example.picpay_project.domain.transaction.Transaction;
import com.example.picpay_project.dto.TransactionDTO;
import com.example.picpay_project.service.TrasactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TrasactionService trasactionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception{
        Transaction newTransaction = trasactionService.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction,HttpStatus.CREATED);
    }
}

package com.example.picpay_project.service;

import com.example.picpay_project.domain.transaction.Transaction;
import com.example.picpay_project.domain.users.User;
import com.example.picpay_project.dto.TransactionDTO;
import com.example.picpay_project.repository.TrasactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TrasactionService {
    @Autowired
    private TrasactionRepository repository;
    @Autowired
    private  UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notificationService;

    public Transaction createTransaction(TransactionDTO transaction) throws Exception{
        User sender = userService.findUserById(transaction.senderId());
        User receiver = userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

//        boolean isAuthorized = authorizeTransaction(sender, transaction.value());
//        if (!isAuthorized){
//            throw new Exception("Transação não autorizada");
//        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        repository.save(newTransaction);
        userService.saveUser(sender);
        userService.saveUser(receiver);

//        this.notificationService.sendNotification(sender,"Transação realizada com sucesso");
//        this.notificationService.sendNotification(receiver,"Transação recebida");

        return newTransaction;
    }

//    public boolean authorizeTransaction(User sender, BigDecimal value){
//        var url = "https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc";
//        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity(url, Map.class);
//        if (authorizationResponse.getStatusCode() == HttpStatus.OK){
//            String message = (String) authorizationResponse.getBody().get("message");
//            return "Autorizado".equalsIgnoreCase(message);
//        }
//        return false;
//    }
}

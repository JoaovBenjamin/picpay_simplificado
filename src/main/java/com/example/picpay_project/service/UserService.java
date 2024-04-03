package com.example.picpay_project.service;

import com.example.picpay_project.domain.users.User;
import com.example.picpay_project.domain.users.UserType;
import com.example.picpay_project.dto.UserDTO;
import com.example.picpay_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception{
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuario do tipo lojista não está autorizado a fazer essa transação");
        }
        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }
    }

    public User findUserById(long id) throws Exception{
        return repository.findById(id)
                                    .orElseThrow(() ->new Exception("Usuario não encontrado"));
    }



    public User createUser(UserDTO data){
        User newUser = new User(data);
        return repository.save(newUser);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }
    public User saveUser(User newUser){
        return repository.save(newUser);
    }
}

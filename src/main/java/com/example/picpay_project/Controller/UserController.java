package com.example.picpay_project.Controller;

import com.example.picpay_project.domain.users.User;
import com.example.picpay_project.dto.UserDTO;
import com.example.picpay_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO data){
        User newUser = userService.createUser(data);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}

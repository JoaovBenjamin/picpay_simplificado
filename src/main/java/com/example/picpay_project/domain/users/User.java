package com.example.picpay_project.domain.users;

import com.example.picpay_project.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity(name="users")
@Table(name ="users")
@Data
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType;


    public User(UserDTO data){
        this.balance=data.balance();
        this.document=data.document();
        this.email= data.email();
        this.firstName= data.firstName();
        this.lastName= data.lastName();
        this.password= data.password();
        this.userType=data.userType();
    }

}

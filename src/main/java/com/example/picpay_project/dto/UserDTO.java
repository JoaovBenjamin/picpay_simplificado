package com.example.picpay_project.dto;

import com.example.picpay_project.domain.users.UserType;

import java.math.BigDecimal;

public record UserDTO (String firstName, String lastName, String document, String email, String password, BigDecimal balance, UserType userType){}

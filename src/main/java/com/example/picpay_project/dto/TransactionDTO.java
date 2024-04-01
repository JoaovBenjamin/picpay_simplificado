package com.example.picpay_project.dto;

import java.math.BigDecimal;

public record TransactionDTO(long senderId, long receiverId, BigDecimal value){}

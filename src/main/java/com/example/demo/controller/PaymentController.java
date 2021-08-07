package com.example.demo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.service.*;

@RestController
@RequestMapping("/payment")
public class PaymentController{
    
    @Autowired
    PaymentService paymentService;
    
    @GetMapping()
    public ArrayList<Payment> getPayments(){
        return this.paymentService.getPayments();
    }
}
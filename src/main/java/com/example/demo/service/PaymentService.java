package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.pojo.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;

import org.springframework.beans.factory.annotation.*;

@Service
public class PaymentService{

    @Autowired
    PaymentRepository paymentRepository;

    public ArrayList<Payment> getPayments(){
        return (ArrayList<Payment>) paymentRepository.findAll();
    }

}

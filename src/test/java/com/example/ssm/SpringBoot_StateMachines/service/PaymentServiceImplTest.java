package com.example.ssm.SpringBoot_StateMachines.service;

import com.example.ssm.SpringBoot_StateMachines.domain.Payment;
import com.example.ssm.SpringBoot_StateMachines.domain.PaymentEvent;
import com.example.ssm.SpringBoot_StateMachines.domain.PaymentState;
import com.example.ssm.SpringBoot_StateMachines.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentServiceImplTest {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentRepository paymentRepository;

    Payment payment;

    @BeforeEach
    void setUp() {
        payment = Payment.builder().amount(new BigDecimal("12.99")).build();
    }

    @Transactional
    @Test
    void preAuth() {
        Payment savedPayment = paymentService.newPayment(payment);

        System.out.println(savedPayment.getState());
        StateMachine<PaymentState, PaymentEvent> sm = paymentService.preAuth(savedPayment.getId());

        Payment preAuthPayment = paymentRepository.getById(savedPayment.getId());

        System.out.println(sm.getState().getId());
        System.out.println(preAuthPayment);
    }
}
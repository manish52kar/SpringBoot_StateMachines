package com.example.ssm.SpringBoot_StateMachines.service;

import com.example.ssm.SpringBoot_StateMachines.domain.Payment;
import com.example.ssm.SpringBoot_StateMachines.domain.PaymentEvent;
import com.example.ssm.SpringBoot_StateMachines.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

public interface PaymentService {

    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);
}

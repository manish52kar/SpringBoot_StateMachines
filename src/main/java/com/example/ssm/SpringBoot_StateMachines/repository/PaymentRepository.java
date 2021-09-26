package com.example.ssm.SpringBoot_StateMachines.repository;

import com.example.ssm.SpringBoot_StateMachines.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}

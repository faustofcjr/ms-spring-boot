package com.yesiv.hrworker.services;

import org.springframework.stereotype.Service;

import com.yesiv.hrworker.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workId, int days) {
		return new Payment("Bob", 200.0, days);
	}
}

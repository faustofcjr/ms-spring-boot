package com.yesiv.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesiv.payroll.entities.Payment;
import com.yesiv.payroll.entities.Worker;
import com.yesiv.payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;	

	public Payment getPayment(Long workId, int days) {
		Worker worker = workerFeignClient.findById(workId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}

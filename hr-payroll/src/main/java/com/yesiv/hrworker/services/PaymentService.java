package com.yesiv.hrworker.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yesiv.hrworker.entities.Payment;
import com.yesiv.hrworker.entities.Worker;

@Service
public class PaymentService {

	@Value("${hr-worker.host}")
	private String workerHost;

	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(Long workId, int days) {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("id", String.valueOf(workId));
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, parameters);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}

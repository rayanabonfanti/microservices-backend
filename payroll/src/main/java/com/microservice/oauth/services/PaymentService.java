package com.microservice.oauth.services;

import com.microservice.oauth.entities.Payment;
import com.microservice.oauth.entities.Worker;
import com.microservice.oauth.feignclients.WorkerFeignClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	private static Logger logger = LoggerFactory.getLogger(PaymentService.class);
	@Autowired
	private WorkerFeignClients workerFeignClients;

	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClients.findById(workerId).getBody();
		logger.info("WORKER = " + worker);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}

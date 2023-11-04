package com.microservice.payroll.feignclients;

import com.microservice.payroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(
		name = "microservice-worker",
		path = "/workers")
public interface WorkerFeignClients {

	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);

}
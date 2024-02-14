package com.microservice.oauth.feignclients;

import com.microservice.oauth.models.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "microservice-user", path = "/users")
public interface UserFeignClient {

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email);
}

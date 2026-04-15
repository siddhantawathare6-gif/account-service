package com.bank.account.service.client;

import com.bank.account.dto.client.CardDto;
import jakarta.validation.constraints.Pattern;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("card")
public interface CardFeignClient {

    @GetMapping("/api/card")
    public ResponseEntity<CardDto> fetchCardDetails(@RequestParam String mobileNumber) ;

}

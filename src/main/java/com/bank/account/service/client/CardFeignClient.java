package com.bank.account.service.client;

import com.bank.account.dto.client.CardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("card")
public interface CardFeignClient {

    @GetMapping("/api/card")
    public ResponseEntity<CardDto> fetchCardDetails(@RequestHeader("easybank-correlation-id") String correlationId,
                                                    @RequestParam String mobileNumber);

}

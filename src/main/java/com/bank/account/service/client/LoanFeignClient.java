package com.bank.account.service.client;

import com.bank.account.dto.client.LoanDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "loan", fallback = LoanFallback.class)
public interface LoanFeignClient {

    @GetMapping("/api/loan")
    public ResponseEntity<LoanDto> fetchLoanDetails(@RequestHeader("easybank-correlation-id") String correlationId,
                                                    @RequestParam String mobileNumber);


}

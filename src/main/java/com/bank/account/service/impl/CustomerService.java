package com.bank.account.service.impl;

import com.bank.account.dto.AccountDto;
import com.bank.account.dto.CustomerDetailsDto;
import com.bank.account.dto.client.CardDto;
import com.bank.account.dto.client.LoanDto;
import com.bank.account.entity.Account;
import com.bank.account.entity.Customer;
import com.bank.account.exception.ResourceNotFoundException;
import com.bank.account.mapper.AccountMapper;
import com.bank.account.mapper.CustomerMapper;
import com.bank.account.repository.AccountRepository;
import com.bank.account.repository.CustomerRepository;
import com.bank.account.service.ICustomerService;
import com.bank.account.service.client.CardFeignClient;
import com.bank.account.service.client.LoanFeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final CardFeignClient cardFeignClient;
    private final LoanFeignClient loanFeignClient;

    public CustomerService(AccountRepository accountRepository, CustomerRepository customerRepository, CardFeignClient cardFeignClient, LoanFeignClient loanFeignClient) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.cardFeignClient = cardFeignClient;
        this.loanFeignClient = loanFeignClient;
    }

    @Override
    public CustomerDetailsDto fetchCustomerDetaila(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        Account account = accountRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("account", "customerId", customer.getCustomerId().toString()));
        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountDto(AccountMapper.mapToAccountDto(account, new AccountDto()));
        ResponseEntity<LoanDto> loanDto = loanFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        if (null!=loanDto){
            customerDetailsDto.setLoanDto(loanDto.getBody());
        }
        ResponseEntity<CardDto> cardDto = cardFeignClient.fetchCardDetails(correlationId, mobileNumber);
        if (null!=cardDto){
            customerDetailsDto.setCardDto(cardDto.getBody());
        }
        return customerDetailsDto;
    }
}

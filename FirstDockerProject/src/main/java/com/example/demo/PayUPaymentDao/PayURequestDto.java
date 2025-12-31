package com.example.demo.PayUPaymentDao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayURequestDto {
    private String txnid;
    private String amount;
    private String productinfo;
    private String firstname;
    private String email;
    private String phone;
    
    
    
    
    
    
}

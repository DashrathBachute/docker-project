package com.example.demo.PayUPaymentConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "payu")
@Data
public class PayUConfig {
    private String merchantKey;
    private String merchantSalt;
    private String paymentUrl;
    private String successUrl;
    private String failureUrl;
}

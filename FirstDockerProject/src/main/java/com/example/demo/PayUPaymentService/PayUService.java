package com.example.demo.PayUPaymentService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.PayUPaymenrUtility.PayUHashUtil;
import com.example.demo.PayUPaymentConfig.PayUConfig;
import com.example.demo.PayUPaymentDao.PayURequestDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PayUService {

    private final PayUConfig config;
    private final PayUHashUtil hashUtil;

    public Map<String, String> createPayment(PayURequestDto dto) {
    	
    	
//    	hash = sha512(key|txnid|amount|productinfo|firstname|email|||||||||||salt)


        String hashString = config.getMerchantKey() + "|" +
                dto.getTxnid() + "|" +
                dto.getAmount() + "|" +
                dto.getProductinfo() + "|" +
                dto.getFirstname() + "|" +
                dto.getEmail() +
                "|||||||||||" +
                config.getMerchantSalt();

        String hash = hashUtil.generateHash(hashString);

        Map<String, String> params = new HashMap<>();
        params.put("key", config.getMerchantKey());
        params.put("txnid", dto.getTxnid());
        params.put("amount", dto.getAmount());
        params.put("productinfo", dto.getProductinfo());
        params.put("firstname", dto.getFirstname());
        params.put("email", dto.getEmail());
        params.put("phone", dto.getPhone());
        params.put("surl", config.getSuccessUrl());
        params.put("furl", config.getFailureUrl());
        params.put("hash", hash);

        return params;
    }
    
    
//    sha512(salt|status|||||||||||email|firstname|productinfo|amount|txnid|key)

    
    public boolean verifyResponseHash(Map<String, String> response, PayUConfig config) {

        String hashSequence = config.getMerchantSalt() + "|" +
                response.get("status") +
                "|||||||||||" +
                response.get("email") + "|" +
                response.get("firstname") + "|" +
                response.get("productinfo") + "|" +
                response.get("amount") + "|" +
                response.get("txnid") + "|" +
                config.getMerchantKey();

        String calculatedHash = hashUtil.generateHash(hashSequence);
        return calculatedHash.equals(response.get("hash"));
    }
    
    
    
    
//    <form method="post" action="https://test.payu.in/_payment">
//    <input type="hidden" name="key" value="xxxx">
//    <input type="hidden" name="txnid" value="txn123">
//    <input type="hidden" name="amount" value="100">
//    <input type="hidden" name="productinfo" value="Test Product">
//    <input type="hidden" name="firstname" value="Dashrath">
//    <input type="hidden" name="email" value="test@mail.com">
//    <input type="hidden" name="hash" value="generated_hash">
//    <button type="submit">Pay Now</button>
//  </form>


}


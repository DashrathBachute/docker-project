package com.example.demo.PayUPaymentController;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.PayUPaymentDao.PayURequestDto;
import com.example.demo.PayUPaymentService.PayUService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payu")
@RequiredArgsConstructor
public class PayUController {

    private final PayUService payUService;

    @PostMapping("/create-payment")
    public Map<String, String> createPayment(@RequestBody PayURequestDto dto) {
        return payUService.createPayment(dto);
    }

    @PostMapping("/success")
    public String paymentSuccess(@RequestParam Map<String, String> response) {
        // Verify hash here
        return "Payment Successful";
    }

    @PostMapping("/failure")
    public String paymentFailure(@RequestParam Map<String, String> response) {
        return "Payment Failed";
    }
}

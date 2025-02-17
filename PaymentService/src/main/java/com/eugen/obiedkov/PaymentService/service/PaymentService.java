package com.eugen.obiedkov.PaymentService.service;

import com.eugen.obiedkov.PaymentService.model.PaymentRequest;
import com.eugen.obiedkov.PaymentService.model.PaymentResponse;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(Long orderId);
}

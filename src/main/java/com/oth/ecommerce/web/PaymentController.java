package com.oth.ecommerce.web;

import com.oth.ecommerce.dao.OrderRepository;
import com.oth.ecommerce.dao.PaymentRepository;
import com.oth.ecommerce.entities.Order;
import com.oth.ecommerce.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@CrossOrigin("*")
@RestController
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/payment")
    public void PayerCommande(@RequestBody Payment payment){
        Payment pay=new Payment();
        pay.setCardType(payment.getCardType());
        pay.setCardNumber(payment.getCardNumber());
        pay.setDatePayment(new Date());
        pay.setOrder(payment.getOrder());
        pay=paymentRepository.save(pay);

        Order order=orderRepository.findById(pay.getOrder().getId()).get();
        order.setPayment(pay);
        orderRepository.save(order);
    }
}

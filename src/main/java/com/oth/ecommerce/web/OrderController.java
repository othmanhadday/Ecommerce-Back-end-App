package com.oth.ecommerce.web;

import com.oth.ecommerce.dao.*;
import com.oth.ecommerce.entities.Client;
import com.oth.ecommerce.entities.Order;
import com.oth.ecommerce.entities.OrderItem;
import com.oth.ecommerce.entities.Product;
import com.oth.ecommerce.metier.OrderForm;
import com.oth.ecommerce.metier.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin("*")
@RestController
public class OrderController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @PostMapping("/orders")
    public Order saveOrder(@RequestBody OrderForm orderForm){
        Client client=orderForm.addClientToBd();
        client=clientRepository.save(client);

        Order order =orderForm.addOrdertoBd(client);
        order=orderRepository.save(order);
        double total=0;
        for (OrderProduct p:orderForm.getProducts()){
            Product product=productRepository.findById(p.getId()).get();

            OrderItem orderItem=orderForm.addOrderItemToBd(order,product,p.getQuantity(),product.getCurrentPrice());

            orderItem=orderItemRepository.save(orderItem);
            total+=orderItem.getPrice()*orderItem.getQuantity();
        }
        order.setTotalAmount(total);
        return orderRepository.save(order);
    }
}

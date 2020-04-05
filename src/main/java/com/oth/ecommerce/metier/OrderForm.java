package com.oth.ecommerce.metier;

import com.oth.ecommerce.entities.Client;
import com.oth.ecommerce.entities.Order;
import com.oth.ecommerce.entities.OrderItem;
import com.oth.ecommerce.entities.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class OrderForm {
    private Client client=new Client();
    private List<OrderProduct>products=new ArrayList<>();

    public List<OrderProduct> getProducts() {
        return products;
    }

    public Client addClientToBd(){
        Client client = new Client();
        client.setName(this.client.getName());
        client.setEmail(this.client.getEmail());
        client.setAddress(this.client.getAddress());
        client.setPhoneNumber(this.client.getPhoneNumber());
        client.setUsername(this.client.getUsername());
        return client;
    }

    public Order addOrdertoBd(Client client){
        Order order=new Order();
        order.setDate(new Date());
        order.setClient(client);
        return order;
    }

    public OrderItem addOrderItemToBd(Order order,Product product,int quantity,double price){
        OrderItem orderItem=new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        orderItem.setPrice(price);
        return orderItem;
    }


}

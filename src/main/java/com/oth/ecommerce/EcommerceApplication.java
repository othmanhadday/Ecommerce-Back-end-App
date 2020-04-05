package com.oth.ecommerce;

import com.oth.ecommerce.dao.*;
import com.oth.ecommerce.entities.*;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Product.class,Category.class);
        categoryRepository.save(new Category("Ordinateur",""));
        categoryRepository.save(new Category("Imprimentes",""));
        categoryRepository.save(new Category("smart phone",""));

        Random rnd = new Random();
        categoryRepository.findAll().forEach(c->{
            for (int i = 0; i <10 ; i++) {
                Product p = new Product();
                p.setName(RandomString.make(18));
                p.setCurrentPrice(rnd.nextInt(1000));
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setPhotoName("unknown.png");
                p.setCategory(c);
                productRepository.save(p);
            }
        });

       /* Category c1=new Category("Ordinateur","");
        categoryRepository.save(c1);
        Category c2=new Category("Imprimentes","");
        categoryRepository.save(c2);
        Category c3=new Category("smart phone","");
        categoryRepository.save(c3);

        Product p1 =new Product();
        p1.setName("ppppp");
        p1.setCurrentPrice(12);
        p1.setPhotoName("unknown.png");
        p1.setCategory(c1);
        productRepository.save(p1);

        Product p2 =new Product();
        p2.setName("sssssss");
        p2.setCurrentPrice(122);
        p2.setPhotoName("unknown.png");
        p2.setCategory(c2);
        productRepository.save(p2);

        Product p3 =new Product();
        p3.setName("aaaaa");
        p3.setCurrentPrice(1992);
        p3.setPhotoName("unknown.png");
        p3.setCategory(c3);
        productRepository.save(p3);

        Client client=new Client();
        client.setName("othm");
        client.setAddress("sssss");
        client.setEmail("ddd@ddd");
        client.setPhoneNumber("ddddddddddd");
        client.setUsername("dddd");
        clientRepository.save(client);

        Order order =new Order();
        order.setClient(client);
        order.setTotalAmount(11111);
        order.setDate(new Date());
        orderRepository.save(order);

        OrderItem oi=new OrderItem();
        oi.setOrder(order);
        oi.setProduct(p1);
        oi.setPrice(p1.getCurrentPrice());
        oi.setQuantity(p1.getQuantity());
        orderItemRepository.save(oi);

        OrderItem oi1=new OrderItem();
        oi1.setOrder(order);
        oi1.setProduct(p2);
        oi1.setPrice(p2.getCurrentPrice());
        oi1.setQuantity(p2.getQuantity());
        orderItemRepository.save(oi1);

        OrderItem oi2=new OrderItem();
        oi2.setOrder(order);
        oi2.setProduct(p3);
        oi2.setPrice(p3.getCurrentPrice());
        oi2.setQuantity(p3.getQuantity());
        orderItemRepository.save(oi2);*/




    }
}

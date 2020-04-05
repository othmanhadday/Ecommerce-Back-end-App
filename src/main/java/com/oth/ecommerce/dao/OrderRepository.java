package com.oth.ecommerce.dao;

import com.oth.ecommerce.entities.Client;
import com.oth.ecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order,Long> {


    /* @RestResource(path="/productsByKeyword")
    @Query("select p from Product p where p.name = :x")
    public List<Product> chercher(@Param("x") String mc);*/

    @RestResource(path="/orderOfClient")
    @Query(value = "select DISTINCT o from Order o " +
            "JOIN Client c on o.client = c " +
            //           "JOIN Payment p on p.order = o " +
//            "JOIN OrderItem oi on oi.order = o " +
//            "JOIN Product pr on pr = oi.product " +
            "WHERE c.username = :username"
    )
    public List<Order> orderOfClient(@Param("username") String username);

    @RestResource(path = "/allOrders")
    @Query(value = "select DISTINCT o from Order o " +
            "JOIN Client c on o.client = c "
    )
    public List<Order> allOrders();
}

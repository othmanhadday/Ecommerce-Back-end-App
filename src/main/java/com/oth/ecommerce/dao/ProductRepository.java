package com.oth.ecommerce.dao;

import com.oth.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {

    @RestResource(path="/selectedProducts")
    public List<Product> findBySelectedIsTrue();
    /**------------------- FindBy without Query ----------------- */
    @RestResource(path="/productsByKeyword")
    public List<Product> findByNameContains(@Param("mc") String mc);
    /**-------- FindBy using query----------*/
   /* @RestResource(path="/productsByKeyword")
    @Query("select p from Product p where p.name = :x")
    public List<Product> chercher(@Param("x") String mc);*/
    /**------------------- FindBy promotion product ----------------- */
    @RestResource(path="/promoProducts")
    public List<Product> findByPromotionIsTrue();
    /**------------------- FindBy promotion product ----------------- */
    @RestResource(path="/dispoProducts")
    public List<Product> findByAvailableIsTrue();

}

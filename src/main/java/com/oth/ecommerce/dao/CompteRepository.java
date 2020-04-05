package com.oth.ecommerce.dao;

import com.oth.ecommerce.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long> {
}

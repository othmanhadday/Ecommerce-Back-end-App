package com.oth.ecommerce.web;

import com.oth.ecommerce.dao.ProductRepository;
import com.oth.ecommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@CrossOrigin("*")
public class CatalogueRestController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/photoProduct/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
        Product p = productRepository.findById(id).get();
        return Files.readAllBytes(Paths.get("F:/project/ecom/product/" + p.getPhotoName()));
    }

    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhotoProduct(MultipartFile file, @PathVariable Long id) throws Exception {
        Product p = productRepository.findById(id).get();
        p.setPhotoName(file.getOriginalFilename());
        Files.write(Paths.get("F:/project/ecom/product/" + p.getPhotoName()), file.getBytes());
        productRepository.save(p);
    }
}

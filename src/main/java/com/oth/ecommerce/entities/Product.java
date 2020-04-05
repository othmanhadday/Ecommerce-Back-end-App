package com.oth.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double currentPrice;
    private boolean promotion;
    private boolean selected;
    private boolean available;
    private String photoName;
    @ManyToOne
    private Category category;
    @Transient
    private int quantity =1;

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public boolean isSelected() {
        return selected;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getPhotoName() {
        return photoName;
    }

    public Category getCategory() {
        return category;
    }
}

package org.example.mongodbdome.model;

import javax.persistence.*;

/**
 * @author Faim
 * @create 2024/6/7 16:59
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

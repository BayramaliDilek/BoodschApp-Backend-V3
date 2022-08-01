package nl.novi.eindopdracht.boodschappbackendv3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    public Long id;
    @Column(name = "product_name")
    public String productName;
    @Column(name = "product_type")
    public String productType;
    @Column(
            name = "product_description",
            length = 1000
    )
    public String description;
    @Column(
            name = "product_ingredients",
            length = 1000
    )
    public String ingredients;
    @Column(name = "product_price")
    public Float price;

    @Column(name = "product_quantity")
    public Float quantity;

    @OneToOne
    FileUploadResponse picture;

    @ManyToOne
    private DeliveryRequest productList;


    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public Float getPrice() {
        return price;
    }

    public Float getQuantity() {
        return quantity;
    }

    public FileUploadResponse getPicture() {
        return picture;
    }

    public void setPicture(FileUploadResponse picture) {
        this.picture = picture;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public DeliveryRequest getProductList() {
        return productList;
    }

    public void setProductList(DeliveryRequest productList) {
        this.productList = productList;
    }
}


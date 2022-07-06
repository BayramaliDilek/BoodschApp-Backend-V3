package nl.novi.eindopdracht.boodschappbackendv3.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {


    @Id
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






    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}


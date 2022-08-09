package nl.novi.eindopdracht.boodschappbackendv3.models;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Table(name = "products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    public Long id;
    @Column(name = "product_name",
            length = 1000)
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
    public double price;

    @OneToOne
    FileUploadResponse picture;


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

    public double getPrice() {
        return price;
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

    public void setPrice(double price) {
        this.price = price;
    }

}


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

    @OneToOne
    FileUploadResponse file;





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

    public FileUploadResponse getFile() {
        return file;
    }

    public void setFile(FileUploadResponse file) {
        this.file = file;
    }


}


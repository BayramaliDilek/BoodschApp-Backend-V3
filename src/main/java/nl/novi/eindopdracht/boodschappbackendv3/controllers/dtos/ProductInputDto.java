package nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos;

//import nl.novi.eindopdracht.boodschappbackendv3.models.FileUploadResponse;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;


public class ProductInputDto {

    public Long id;

    public String productName;

    public String productType;

    public String description;

    public String ingredients;

    public Float price;

//    public FileUploadResponse image;

    public Product toProduct() {

        var product = new Product();

        product.setId(id);
        product.setProductName(productName);
        product.setProductType(productType);
        product.setDescription(description);
        product.setIngredients(ingredients);
        product.setPrice(price);


        return product;
    }

}

//product.setPicture(image);
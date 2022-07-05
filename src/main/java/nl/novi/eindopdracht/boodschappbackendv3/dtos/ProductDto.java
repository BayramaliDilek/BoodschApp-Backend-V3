package nl.novi.eindopdracht.boodschappbackendv3.dtos;


import nl.novi.eindopdracht.boodschappbackendv3.models.Product;

public class ProductDto {

    public Long id;
    public String productName;
    public String productType;
    public String description;
    public String ingredients;
    public Float price;

    public static ProductDto fromProduct(Product product) {

        var dto = new ProductDto();

        dto.id = product.getId();

        dto.productName = product.getProductName();

        dto.productType = product.getProductType();

        dto.description = product.getDescription();

        dto.ingredients = product.getIngredients();

        dto.price = product.getPrice();

        return dto;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

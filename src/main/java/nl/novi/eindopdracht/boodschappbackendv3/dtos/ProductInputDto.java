package nl.novi.eindopdracht.boodschappbackendv3.dtos;
import lombok.Data;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;

@Data
public class ProductInputDto {

    public Long id;
    public String productName;
    public String productType;
    public String description;
    public String ingredients;
    public Float price;


    public Product toProduct() {

        var product = new Product();

        product.setProductName(productName);
        product.setProductType(productType);
        product.setDescription(description);
        product.setIngredients(ingredients);
        product.setPrice(price);

        return product;
    }

}

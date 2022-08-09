package nl.novi.eindopdracht.boodschappbackendv3.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    @DisplayName("Should set the ingredients")
    void setIngredientsShouldSetTheIngredients() {
        Product product = new Product();
        product.setIngredients("ingredients");
        assertEquals("ingredients", product.getIngredients());
    }

    @Test
    @DisplayName("Should set the price")
    void setPrice() {
        Product product = new Product();
        product.setPrice(10.0);
        assertEquals(10.0, product.getPrice());
    }

    @Test
    @DisplayName("Should set the description")
    void setDescriptionShouldSetTheDescription() {
        Product product = new Product();
        product.setDescription("description");
        assertEquals("description", product.getDescription());
    }

    @Test
    @DisplayName("Should set the product type")
    void setProductType() {
        Product product = new Product();
        product.setProductType("test");
        assertEquals("test", product.getProductType());
    }

    @Test
    @DisplayName("Should set the product name")
    void setProductName() {
        Product product = new Product();
        product.setProductName("test");
        assertEquals("test", product.getProductName());
    }

    @Test
    @DisplayName("Should set the id")
    void setIdShouldSetTheId() {
        Product product = new Product();
        product.setId(1L);
        assertEquals(1L, product.getId());
    }

    @Test
    @DisplayName("Should set the picture")
    void setPictureShouldSetThePicture() {
        Product product = new Product();
        FileUploadResponse picture = new FileUploadResponse("fileName", "contentType", "url");

        product.setPicture(picture);

        assertEquals(picture, product.getPicture());
    }

    @Test
    @DisplayName("Should return the picture of the product")
    void getPictureShouldReturnThePictureOfTheProduct() {
        Product product = new Product();
        FileUploadResponse picture = new FileUploadResponse("fileName", "contentType", "url");
        product.setPicture(picture);

        assertEquals(picture, product.getPicture());
    }

    @Test
    @DisplayName("Should return the price of the product")
    void getPriceShouldReturnThePriceOfTheProduct() {
        Product product = new Product();
        product.setPrice(10.0);
        assertEquals(10.0, product.getPrice());
    }

    @Test
    @DisplayName("Should return the ingredients of the product")
    void getIngredientsShouldReturnTheIngredientsOfTheProduct() {
        Product product = new Product();
        product.setIngredients("ingredients");
        assertEquals("ingredients", product.getIngredients());
    }

    @Test
    @DisplayName("Should return the description of the product")
    void getDescriptionShouldReturnTheDescriptionOfTheProduct() {
        Product product = new Product();
        product.setDescription("This is a description");
        assertEquals("This is a description", product.getDescription());
    }

    @Test
    @DisplayName("Should return the product type")
    void getProductTypeShouldReturnTheProductType() {
        Product product = new Product();
        product.setProductType("Cake");
        assertEquals("Cake", product.getProductType());
    }

    @Test
    @DisplayName("Should return the id of the product")
    void getIdShouldReturnTheIdOfTheProduct() {
        Product product = new Product();
        product.setId(1L);
        assertEquals(1L, product.getId());
    }

    @Test
    @DisplayName("Should return the product name")
    void getProductNameShouldReturnTheProductName() {
        Product product = new Product();
        product.setProductName("test");
        assertEquals("test", product.getProductName());
    }
}
package nl.novi.eindopdracht.boodschappbackendv3.controllers;

import nl.novi.eindopdracht.boodschappbackendv3.dtos.ProductDto;
import nl.novi.eindopdracht.boodschappbackendv3.dtos.ProductInputDto;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController controller;

    @Test
    @DisplayName("Should return all products when no parameters are passed")
    void getProductsWhenNoParametersArePassed() {
        var product = new Product();
        product.setId(1L);
        product.setProductName("Test");
        product.setProductType("Test");
        product.setDescription("Test");
        product.setIngredients("Test");
        product.setPrice(1.0);

        var products = List.of(product);

        when(productService.getProducts()).thenReturn(products);

        var result = controller.getProducts(null, null);

        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Should create a product when the product is valid")
    void createProductWhenProductIsValid() {
        ProductInputDto productInputDto = new ProductInputDto();
        productInputDto.setProductName("test");
        productInputDto.setProductType("test");
        productInputDto.setDescription("test");
        productInputDto.setIngredients("test");
        productInputDto.setPrice(1f);

        Product product = new Product();
        product.setProductName("test");
        product.setProductType("test");
        product.setDescription("test");
        product.setIngredients("test");
        product.setPrice(1f);

        when(productService.createProduct(any())).thenReturn(product);

        ProductDto result = controller.createProduct(productInputDto);

        assertEquals(productInputDto.getProductName(), result.getProductName());
    }

    @Test
    @DisplayName("Should throw an exception when the product is invalid")
    void createProductWhenProductIsInvalidThenThrowException() {
        ProductInputDto productInputDto = new ProductInputDto();
        productInputDto.setProductName("");
        productInputDto.setProductType("");
        productInputDto.setDescription("");
        productInputDto.setIngredients("");
        productInputDto.setPrice(0f);

        assertThrows(
                NullPointerException.class,
                () -> controller.createProduct(productInputDto));
    }
}
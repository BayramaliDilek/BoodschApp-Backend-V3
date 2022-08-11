package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.exceptions.RecordNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    @DisplayName("Should return the product when the product exists")
    void getProductWhenProductExists() {
        Product product = new Product();
        product.setId(1L);
        product.setProductName("test");
        product.setProductType("test");
        product.setDescription("test");
        product.setIngredients("test");
        product.setPrice(1.0);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product result = productService.getProduct(1L);

        assertEquals(product, result);
    }

    @Test
    @DisplayName("Should throw an exception when the product does not exist")
    void getProductWhenProductDoesNotExistThenThrowException() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RecordNotFoundException.class, () -> productService.getProduct(1L));

        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Should returns all products")
    void getProductsShouldReturnsAllProducts() {
        Product product = new Product();
        product.setId(1L);
        product.setProductName("test");
        product.setProductType("test");
        product.setDescription("test");
        product.setIngredients("test");
        product.setPrice(1.0);

        when(productRepository.findAll()).thenReturn(List.of(product));

        List<Product> products = productService.getProducts();

        assertNotNull(products);
        assertFalse(products.isEmpty());
        assertEquals(1, products.size());

        verify(productRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should returns a list of products when the product type is found")
    void findProductListByTypeWhenProductTypeIsFoundThenReturnsAListOfProducts() {
        String productType = "fruit";
        Product product = new Product();
        product.setProductType(productType);

        when(productRepository.findByProductTypeContainingIgnoreCase(productType))
                .thenReturn(List.of(product));

        var result = productService.findProductListByType(productType);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(productType, result.get(0).getProductType());
    }

    @Test
    @DisplayName("Should throws an exception when the product type is not found")
    void findProductListByTypeWhenProductTypeIsNotFoundThenThrowsException() {
        String productType = "Fruit";

        assertThrows(
                RecordNotFoundException.class,
                () -> productService.findProductListByType(productType));

        verify(productRepository, times(1)).findByProductTypeContainingIgnoreCase(productType);
    }

    @Test
    @DisplayName("Should delete the product when the product exists")
    void deleteProductWhenProductExists() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setProductName("test");

        productRepository.delete(product1);

        productService.deleteProduct(1L);

        verify(productRepository).delete(product1);

    }

    @Test
    @DisplayName("Should update the product when the product exists")
    void updateProductWhenProductExists() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setProductName("test");
        product1.setProductType("test");
        product1.setDescription("test");
        product1.setIngredients("test");
        product1.setPrice(1);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));

        product1.setProductName("BaylaFruit");
        productService.updateProduct(product1);

        verify(productRepository).save(product1);

        assertThat(product1.getId()).isEqualTo(1);
        assertThat(product1.getProductName()).isEqualTo("BaylaFruit");

    }

    @Test
    @DisplayName("Should throw an exception when the product does not exist")
    void updateProductWhenProductDoesNotExistThenThrowException() {
        Product product = new Product();
        product.setId(1L);
        product.setProductName("test");
        product.setProductType("test");
        product.setDescription("test");
        product.setIngredients("test");

        when(productRepository.findById(1L)).thenReturn(null);

        // Act & Assert
        assertThrows(
                NullPointerException.class,
                () -> {
                    productService.updateProduct(product);
                });
    }

    @Test
    @DisplayName("Should create a product when the product is valid")
    void createProductWhenProductIsValid() {
        Product product = new Product();
        product.setId(1L);
        product.setProductName("test");
        product.setProductType("test");
        product.setDescription("test");
        product.setIngredients("test");
        product.setPrice(1.0);

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.createProduct(product);

        assertEquals(product, result);
    }
}
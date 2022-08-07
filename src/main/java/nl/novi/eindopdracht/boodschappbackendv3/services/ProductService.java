package nl.novi.eindopdracht.boodschappbackendv3.services;


import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ProductService {

    List<Product> getProducts();

    List<Product> findProductListByName(String productName);

    List<Product> findProductListByType(String productType);

    Product getProduct(Long id);

    Product createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Long id);

    void assignPictureToProduct(String fileName, Long id);


}

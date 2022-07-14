package nl.novi.eindopdracht.boodschappbackendv3.services;


import nl.novi.eindopdracht.boodschappbackendv3.exceptions.RecordNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface ProductService {

    List<Product> getProducts();

    List<Product> findProductListByName(String productName);

    List<Product> findProductListByType(String productType);

    Product getProduct(Long id);

    Product saveProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(String productName);

    void assignPictureToProduct(String Filename, Long id);

}

package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.exceptions.RecordNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }


    @Override
    public Product getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new RecordNotFoundException("Product niet gevonden");
        }
    }

    @Override
    public List<Product> findProductListByName(String productName) {
        var optionalProductList = productRepository.findByProductNameContainingIgnoreCase(productName);

        if (optionalProductList.isEmpty()) {
            throw new RecordNotFoundException("geen product gevonden met de naam" + productName);
        }

        return optionalProductList;
    }

    @Override
    public List<Product> findProductListByType(String productType) {
        var optionalProductList = productRepository.findByProductTypeContainingIgnoreCase(productType);

        if (optionalProductList.isEmpty()) {
            throw new RecordNotFoundException("geen product(en) gevonden");
        }

        return optionalProductList;
    }


}

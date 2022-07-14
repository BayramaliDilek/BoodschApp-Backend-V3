package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.exceptions.RecordNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.FileUploadRepository;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final FileUploadRepository fileUploadRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              FileUploadRepository fileUploadRepository) {
        this.productRepository = productRepository;
        this.fileUploadRepository = fileUploadRepository;
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

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {

        Optional<Product> optionalProduct = productRepository.findById(product.getId());

        if (optionalProduct.isEmpty()) {
            throw new RecordNotFoundException("product niet gevonden..");
        } else {

            Product product1 = optionalProduct.get();
            product1.setId(product.getId());
            product1.setProductName(product.getProductName());
            product1.setProductType(product.getProductType());
            product1.setDescription(product.getDescription());
            product1.setIngredients(product.getIngredients());
            product1.setPrice(product.getPrice());

            productRepository.save(product1);

//            product1.setFileUploadResponse(prod);

        }
    }

    @Override
    public void deleteProduct(String productName) {
        productRepository.deleteById(productName);
    }


    @Override
    public void assignPictureToProduct(String Filename, Long id) {

        var optionalProduct = productRepository.findById(id);

        var optionalPicture = fileUploadRepository.findById(Filename);

        if (optionalProduct.isPresent() && optionalPicture.isPresent()) {

            var product = optionalProduct.get();

            var picture = optionalPicture.get();

            product.setFile(picture);

            productRepository.save(product);

        } else {

            throw new RecordNotFoundException();

        }

    }


}

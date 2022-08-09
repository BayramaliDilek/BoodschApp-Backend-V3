package nl.novi.eindopdracht.boodschappbackendv3.services;

import nl.novi.eindopdracht.boodschappbackendv3.exceptions.RecordNotFoundException;
import nl.novi.eindopdracht.boodschappbackendv3.models.FileUploadResponse;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.FileUploadRepository;
import nl.novi.eindopdracht.boodschappbackendv3.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    private PhotoService photoService;

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
    public Product createProduct(Product product) {

        product.setId(product.getId());
        product.setProductName(product.getProductName());
        product.setProductType(product.getProductType());
        product.setDescription(product.getDescription());
        product.setIngredients(product.getIngredients());

//        double doubleValue = product.getPrice();
//        BigDecimal bigDecimalDouble = new BigDecimal(doubleValue);
//        BigDecimal bigDecimalWithScale = bigDecimalDouble.setScale(2, RoundingMode.HALF_UP);

        product.setPrice(product.getPrice());

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


        }
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


    @Override
    public void assignPictureToProduct(String fileName, Long id) {

        var optionalProduct = productRepository.findById(id);
        var optionalPicture = fileUploadRepository.findByFileName(fileName);

        if (optionalProduct.isPresent() && optionalPicture.isPresent()) {
            var product = optionalProduct.get();
            var picture = optionalPicture.get();

            product.setPicture(picture);

            productRepository.save(product);

        } else {

            throw new RecordNotFoundException();

        }

    }


}

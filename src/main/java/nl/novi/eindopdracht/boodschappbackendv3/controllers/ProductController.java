package nl.novi.eindopdracht.boodschappbackendv3.controllers;


import nl.novi.eindopdracht.boodschappbackendv3.dtos.ProductDto;
import nl.novi.eindopdracht.boodschappbackendv3.dtos.ProductInputDto;
import nl.novi.eindopdracht.boodschappbackendv3.models.FileUploadResponse;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("products")
public class ProductController {


    private final ProductService productService;

    private final PhotoController photoController;

    @Autowired
    public ProductController(ProductService productService, PhotoController photoController) {
        this.productService = productService;
        this.photoController = photoController;
    }


    @GetMapping
    @Transactional
    public List<ProductDto> getProducts(@RequestParam(value = "productName", required = false, defaultValue = "")String productName,
                                        @RequestParam(value = "productType", required = false, defaultValue = "")String productType) {

        var dtos = new ArrayList<ProductDto>();
        List<Product> productList;

        if (productName == null && productType == null) {

            productList = productService.getProducts();
        } else if (productName != null && productType == null) {

            productList = productService.findProductListByName(productName);

        } else {

            productList = productService.findProductListByType(productType);

        }

        var products = productService.getProducts();
        for (Product product : products) {
            dtos.add(ProductDto.fromProduct(product));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable("id") Long id) {
        var product = productService.getProduct(id);

        return ProductDto.fromProduct(product);
    }

    @PostMapping
    public ProductDto saveProduct(@RequestBody ProductInputDto dto){
        var product = productService.saveProduct(dto.toProduct());

        return ProductDto.fromProduct(product);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id,
                                    @RequestBody Product product) {
        productService.updateProduct(product);

        return ProductDto.fromProduct(product);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProduct(
            @PathVariable("id") String productName) {
        productService.deleteProduct(productName);
    }

    @PostMapping("/{id}/picture")
    public void assignPictureToProduct(@PathVariable("id") Long id,
                                       @RequestBody MultipartFile file){
        FileUploadResponse picture = photoController.singleFileUpload(file);

        productService.assignPictureToProduct(picture.getFileName(), id);
    }



}

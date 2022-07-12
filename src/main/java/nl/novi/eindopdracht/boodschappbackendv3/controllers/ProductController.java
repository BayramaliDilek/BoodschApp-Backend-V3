package nl.novi.eindopdracht.boodschappbackendv3.controllers;


import nl.novi.eindopdracht.boodschappbackendv3.dtos.ProductDto;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("products")
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Transactional
    @GetMapping
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


}

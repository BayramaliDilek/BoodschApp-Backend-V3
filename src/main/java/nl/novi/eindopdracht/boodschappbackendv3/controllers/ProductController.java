package nl.novi.eindopdracht.boodschappbackendv3.controllers;


import nl.novi.eindopdracht.boodschappbackendv3.dtos.ProductDto;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<ProductDto> getProducts(){

        var dtos = new ArrayList<ProductDto>();
        var products = productService.getProducts();
        for (Product product : products) {
            dtos.add(ProductDto.fromProduct(product));
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable("id")Long id) {
        var product = productService.getProduct(id);

        return ProductDto.fromProduct(product);
    }


}

package nl.novi.eindopdracht.boodschappbackendv3.controllers;


import nl.novi.eindopdracht.boodschappbackendv3.dtos.ProductDto;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("products")
public class ProductController {

//
//    private ProductService productService;
//
//    @Autowired
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    public List<ProductDto> getProducts(){
//
//        var dtos = new ArrayList<ProductDto>();
//        var products = productService.getProducts();
//        for (Product product : products) {
//            dtos.add(ProductDto.fromProduct(product));
//        }
//        return dtos;
//    }


}

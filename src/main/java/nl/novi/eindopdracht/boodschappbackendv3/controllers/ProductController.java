package nl.novi.eindopdracht.boodschappbackendv3.controllers;


import nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos.ProductDto;
import nl.novi.eindopdracht.boodschappbackendv3.controllers.dtos.ProductInputDto;
import nl.novi.eindopdracht.boodschappbackendv3.models.Product;
import nl.novi.eindopdracht.boodschappbackendv3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/create")
    public ProductDto createProduct(@RequestBody ProductInputDto dto){
        var product = productService.createProduct(dto.toProduct());

        return ProductDto.fromProduct(product);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id,
                                    @RequestBody Product product) {
        productService.updateProduct(product);

        return ProductDto.fromProduct(product);
    }

//    @DeleteMapping(path = "{id}")
//    public void deleteProduct(
//            @PathVariable("id") Long id) {
//        productService.deleteProduct(id);
//    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {

        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }



    @PutMapping("product/{id}/picture/{fileName}")
    public void assignPictureToProduct(@PathVariable("id") Long productId,
                                       @PathVariable("fileName") String fileName){

        productService.assignPictureToProduct(fileName, productId);
    }

    @PutMapping("/{id}/picture")
    public void uploadPictureToProduct(@PathVariable("id") Long productId,
                                       @RequestBody MultipartFile file){

        photoController.singleFileUpload(file);
        productService.assignPictureToProduct(file.getOriginalFilename(), productId);
    }
}

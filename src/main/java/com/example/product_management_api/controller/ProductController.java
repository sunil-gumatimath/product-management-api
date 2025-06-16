package com.example.product_management_api.controller;

import com.example.product_management_api.dtos.request.ProductRequest;
import com.example.product_management_api.dtos.response.ProductResponse;
import com.example.product_management_api.service.ProductService;
import com.example.product_management_api.utility.ResponseStructure;
import com.example.product_management_api.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseStructure<ProductResponse>> addProduct(@Valid @RequestBody ProductRequest productRequest){
        ProductResponse product = productService.createProduct(productRequest);
        return RestResponseBuilder.success("Product Created Successfully", product, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<ProductResponse>>findProduct(@PathVariable Long id){
        ProductResponse product = productService.getProduct(id);
        return RestResponseBuilder.success("Product found successfully",product,HttpStatus.OK);
    }


}

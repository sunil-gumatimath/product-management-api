package com.example.product_management_api.service;

import com.example.product_management_api.dtos.request.ProductRequest;
import com.example.product_management_api.dtos.response.ProductResponse;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse getProduct(Long id);
}

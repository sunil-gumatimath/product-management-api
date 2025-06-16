package com.example.product_management_api.service.serviceImpl;

import com.example.product_management_api.dtos.request.ProductRequest;
import com.example.product_management_api.dtos.response.ProductResponse;
import com.example.product_management_api.entity.Product;
import com.example.product_management_api.mappers.ProductMapper;
import com.example.product_management_api.repositories.ProductRepository;
import com.example.product_management_api.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        if (productRequest == null) {
            throw new IllegalArgumentException("Product request cannot be null");
        }
        Product product = productMapper.toEntity(productRequest);
        Product savedProduct = productRepository.save(product);
        return productMapper.toResponse(savedProduct);
    }

    @Override
    public ProductResponse getProduct(Long id) {
        var product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));

        return productMapper.toResponse(product);
    }



}

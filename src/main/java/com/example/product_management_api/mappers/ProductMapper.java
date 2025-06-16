package com.example.product_management_api.mappers;

import com.example.product_management_api.dtos.request.ProductRequest;
import com.example.product_management_api.dtos.response.ProductResponse;
import com.example.product_management_api.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    Product toEntity(ProductRequest request);

    ProductResponse toResponse(Product product);

    ProductRequest toDto(Product product);
}

package com.example.product_management_api.dtos.response;

import java.time.LocalDateTime;

public record ProductResponse(
    Long id,
    String name,
    String description,
    Double price,
    String category,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}

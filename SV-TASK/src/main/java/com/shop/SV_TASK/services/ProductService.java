package com.shop.SV_TASK.services;

import com.shop.SV_TASK.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long productId);

    void deleteProductById(Long productId);
}
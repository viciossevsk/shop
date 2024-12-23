package com.shop.SV_TASK.service;

import com.shop.SV_TASK.domain.Product;
import com.shop.SV_TASK.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    void save(Product product);

    void saveWeb(Product product);

    List<ProductDto> getAllProducts();

    List<Product> getAll();

    ProductDto getProductById(Long productId);

    void deleteProductById(Long productId);
}
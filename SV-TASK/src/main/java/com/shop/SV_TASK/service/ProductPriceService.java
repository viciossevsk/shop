package com.shop.SV_TASK.service;

import com.shop.SV_TASK.dto.ProductPriceDto;

import java.util.List;

public interface ProductPriceService {
    ProductPriceDto createProductPrice(ProductPriceDto productPriceDto);

    List<ProductPriceDto> getAllProductPrices();

    ProductPriceDto getProductPriceById(Long productPriceId);

    void deleteProductPriceById(Long productPriceId);
}

package com.shop.SV_TASK.service;

import com.shop.SV_TASK.dto.ProductPriceDto;
import com.shop.SV_TASK.dto.ProductPriceShortDto;

import java.util.List;

public interface ProductPriceService {
    ProductPriceDto createProductPrice(ProductPriceShortDto productPriceShortDto);

    List<ProductPriceDto> getAllProductPrices();

    ProductPriceDto getProductPriceById(Long productPriceId);

    void deleteProductPriceById(Long productPriceId);
}

package com.shop.SV_TASK.controller;

import com.shop.SV_TASK.dto.ProductPriceDto;
import com.shop.SV_TASK.dto.ProductPriceShortDto;
import com.shop.SV_TASK.service.ProductPriceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/productPrice")
public class ProductPriceController {

    private final  ProductPriceService productPriceService;

    @PostMapping
    public ProductPriceDto createProductPrice(@Valid @RequestBody ProductPriceShortDto productPriceShortDto) {
        return productPriceService.createProductPrice(productPriceShortDto);
    }

    @GetMapping
    public List<ProductPriceDto> getAllProductPrices() {
        return  productPriceService.getAllProductPrices();
    }

    @GetMapping("/{id}")
    ProductPriceDto getProductPriceById(@PathVariable("id") Long id) {
        return  productPriceService.getProductPriceById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductPriceById(@PathVariable("id") Long id){
        productPriceService.deleteProductPriceById(id);
    }



}

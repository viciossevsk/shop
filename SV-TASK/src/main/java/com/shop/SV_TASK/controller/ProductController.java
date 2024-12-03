package com.shop.SV_TASK.controller;

import com.shop.SV_TASK.dto.ProductDto;
import com.shop.SV_TASK.dto.ProductPriceDto;
import com.shop.SV_TASK.service.ProductService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
//@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping(path = "/product")
public class ProductController {

  private final  ProductService productService;

@PostMapping
public ProductDto createProduct(@Valid @RequestBody ProductDto productDto){
    log.info("controller");
    return productService.createProduct(productDto);
}

@GetMapping
    public List<ProductDto> getAllProducts() {
    return  productService.getAllProducts();
}


}

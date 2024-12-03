package com.shop.SV_TASK.controller;

import com.shop.SV_TASK.dto.ProductDto;
import com.shop.SV_TASK.service.ProductService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping(path = "/product")
public class ProductController {

ProductService productService;

    @GetMapping
    public String createProduct(){
        return "productService.createProduct(productDto)";


//@GetMapping
//public String createProduct(@Valid @RequestBody ProductDto productDto){
//    return "productService.createProduct(productDto)";
}




}

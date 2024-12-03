package com.shop.SV_TASK.mapper;


import com.shop.SV_TASK.domain.Product;
import com.shop.SV_TASK.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toProductDto(Product product);

    Product toProduct(ProductDto productDto);
}

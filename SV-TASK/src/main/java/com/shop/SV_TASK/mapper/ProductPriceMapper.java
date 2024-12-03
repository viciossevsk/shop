package com.shop.SV_TASK.mapper;

import com.shop.SV_TASK.domain.ProductPrice;
import com.shop.SV_TASK.dto.ProductPriceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPriceMapper {

    ProductPriceDto toProductPriceDto(ProductPrice productPrice);

    ProductPrice toProductPrice(ProductPriceDto productPriceDto);
}

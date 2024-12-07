package com.shop.SV_TASK.mapper;

import com.shop.SV_TASK.domain.ProductPrice;
import com.shop.SV_TASK.domain.Supply;
import com.shop.SV_TASK.dto.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {Supply.class})
public interface SupplyMapper {

    default SupplyDto toSupplyDto(Supply supply) {
        return SupplyDto.builder()
                .id(supply.getId())
                .num(supply.getNum())
                .dateTime(supply.getDateTime())
                .weight(supply.getWeight())
                .productPriceDto(new ProductPriceDto(supply.getProductPrice().getId(),
                                                     supply.getProductPrice().getPrice(),
                                                     supply.getProductPrice().getPeriod_from(),
                                                     supply.getProductPrice().getPeriod_to(),
                                                     new ProductDto(supply.getProductPrice().getProduct().getId(),
                                                                    supply.getProductPrice().getProduct().getName()),
                                                     new SupplierDto(supply.getProductPrice().getSupplier().getId(),
                                                                     supply.getProductPrice().getSupplier().getName())))
                .build();
    }

    default Supply toSupply(SupplyShortDto supplyShortDto, ProductPrice productPrice) {
        return Supply.builder()
                .num(supplyShortDto.getNum())
                .dateTime(supplyShortDto.getDateTime())
                .weight(supplyShortDto.getWeight())
                .productPrice(productPrice)
                .build();
    }
}

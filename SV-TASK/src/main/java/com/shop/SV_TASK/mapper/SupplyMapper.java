package com.shop.SV_TASK.mapper;

import com.shop.SV_TASK.domain.ProductPrice;
import com.shop.SV_TASK.domain.Supply;
import com.shop.SV_TASK.dto.*;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {Supply.class})
public interface SupplyMapper {

    default SupplyDto toSupplyDto(Supply supply) {
        return SupplyDto.builder()
                .id(supply.getId())
                .num(supply.getNum())
                .dateTime(supply.getDateTime())
                .weight(supply.getWeight())
                .productPriceDtoSet(productPricesToProductPriceDtoSet(supply.getProductPrices()))
                .build();
    }

    default Supply toSupply(SupplyShortDto supplyShortDto, Set<ProductPrice> productPriceSet) {
        return Supply.builder()
                .num(supplyShortDto.getNum())
                .dateTime(supplyShortDto.getDateTime())
                .weight(supplyShortDto.getWeight())
                .productPrices(productPriceSet)
                .build();
    }

    Set<ProductPriceDto> productPricesToProductPriceDtoSet(Set<ProductPrice> productPrices);

    //Set<ProductPrice>

}

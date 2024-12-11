package com.shop.SV_TASK.mapper;

import com.shop.SV_TASK.domain.Product;
import com.shop.SV_TASK.domain.ProductPrice;
import com.shop.SV_TASK.domain.Supplier;
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
                .productPriceDtoSet(productPricesToProductPriceDtoSet(supply.getProductPrices()))
                .build();
    }

    default Supply toSupply(SupplyShortDto supplyShortDto, Set<ProductPrice> productPriceSet) {
        return Supply.builder()
                .num(supplyShortDto.getNum())
                .dateTime(supplyShortDto.getDateTime())
                .productPrices(productPriceSet)
                .build();
    }

    Set<ProductPriceDto> productPricesToProductPriceDtoSet(Set<ProductPrice> productPrices);

    default ProductPriceDto productPriceToProductPriceDto(ProductPrice productPrice) {
        return ProductPriceDto.builder()
                .id(productPrice.getId())
                .price(productPrice.getPrice())
                .period_from(productPrice.getPeriod_from())
                .period_to(productPrice.getPeriod_to())
                .productDto(productToProductDto(productPrice.getProduct()))
                .supplierDto(supplierToSupplierDto(productPrice.getSupplier()))
                .build();
    }

    SupplierDto supplierToSupplierDto(Supplier supplier);

    ProductDto productToProductDto(Product product);



}

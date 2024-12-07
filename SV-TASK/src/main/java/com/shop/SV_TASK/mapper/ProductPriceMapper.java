package com.shop.SV_TASK.mapper;

import com.shop.SV_TASK.domain.Product;
import com.shop.SV_TASK.domain.ProductPrice;
import com.shop.SV_TASK.domain.Supplier;
import com.shop.SV_TASK.dto.ProductDto;
import com.shop.SV_TASK.dto.ProductPriceDto;
import com.shop.SV_TASK.dto.ProductPriceShortDto;
import com.shop.SV_TASK.dto.SupplierDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {Product.class, Supplier.class})
public interface ProductPriceMapper {

    default ProductPriceDto toProductPriceDto(ProductPrice productPrice) {
    return ProductPriceDto.builder()
            .id(productPrice.getId())
            .price(productPrice.getPrice())
            .period_from(productPrice.getPeriod_from())
            .period_to(productPrice.getPeriod_to())
            .productDto(new ProductDto(productPrice.getProduct().getId(),
                                       productPrice.getProduct().getName()))
            .supplierDto(new SupplierDto(productPrice.getSupplier().getId(),
                                         productPrice.getSupplier().getName()))
            .build();
    }

    default ProductPrice toProductPrice(ProductPriceShortDto productPriceShortDto, Product product, Supplier supplier) {
        return ProductPrice.builder()
                .price(productPriceShortDto.getPrice())
                .period_from(productPriceShortDto.getPeriod_from())
                .period_to(productPriceShortDto.getPeriod_to())
                .product(product)
                .supplier(supplier)
                .build();
    }

}
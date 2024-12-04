package com.shop.SV_TASK.mapper;

import com.shop.SV_TASK.domain.Product;
import com.shop.SV_TASK.domain.ProductPrice;
import com.shop.SV_TASK.domain.Supplier;
import com.shop.SV_TASK.domain.Supply;
import com.shop.SV_TASK.dto.SupplyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductPrice.class})
public interface SupplyMapper {

    SupplyDto toSupplyDto(Supply supply);

    Supply toSupply(SupplyDto supplyDto);
}

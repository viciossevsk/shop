package com.shop.SV_TASK.mappers;

import com.shop.SV_TASK.domain.Supply;
import com.shop.SV_TASK.dto.SupplyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplyMapper {

    SupplyDto toSupplyDto(Supply supply);

    Supply toSupply(SupplyDto supplyDto);
}

package com.shop.SV_TASK.mappers;

import com.shop.SV_TASK.domain.Supplier;
import com.shop.SV_TASK.dto.SupplierDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    SupplierDto toSupplierDto(Supplier supplier);

    Supplier toSupplier(SupplierDto supplierDto);
}

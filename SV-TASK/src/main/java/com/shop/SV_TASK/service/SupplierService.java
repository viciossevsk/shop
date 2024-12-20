package com.shop.SV_TASK.service;

import com.shop.SV_TASK.domain.Supplier;
import com.shop.SV_TASK.dto.SupplierDto;

import java.util.List;

public interface SupplierService {
    SupplierDto createSupplier(SupplierDto supplierDto);

    void save(Supplier supplier);

    List<SupplierDto> getAllSuppliers();

    SupplierDto getSupplierById(Long supplierId);

    void deleteSupplierById(Long supplierId);
}

package com.shop.SV_TASK.service;

import com.shop.SV_TASK.dto.SupplierDto;

import java.util.List;

public interface SupplierService {
    SupplierDto createSupplier(SupplierDto supplierDto);

    List<SupplierDto> getAllSuppliers();

    SupplierDto getSupplierById(Long supplierId);

    void deleteSupplierById(Long supplierId);
}

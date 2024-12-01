package com.shop.SV_TASK.services;

import com.shop.SV_TASK.dto.SupplyDto;

import java.util.List;

public interface SupplyService {
    SupplyDto createSupply(SupplyDto supplyDto);

    List<SupplyDto> getAllSupplies();

    SupplyDto getSupplyById(Long supplyId);

    void deleteSupplyById(Long supplyId);
}

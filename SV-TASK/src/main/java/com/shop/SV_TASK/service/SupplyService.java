package com.shop.SV_TASK.service;

import com.shop.SV_TASK.dto.SupplyDto;
import com.shop.SV_TASK.dto.SupplyShortDto;

import java.util.List;

public interface SupplyService {
    SupplyDto createSupply(SupplyShortDto supplyShortDto);

    List<SupplyDto> getAllSupplies();

    SupplyDto getSupplyById(Long supplyId);

    void deleteSupplyById(Long supplyId);
}

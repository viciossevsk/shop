package com.shop.SV_TASK.controller;

import com.shop.SV_TASK.dto.SupplyDto;
import com.shop.SV_TASK.dto.SupplyShortDto;
import com.shop.SV_TASK.service.SupplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/supply")
public class SupplyController {

    private final SupplyService supplyService;

    @PostMapping
    public SupplyDto createSupply(@Valid @RequestBody SupplyShortDto supplyShortDto) {
        return supplyService.createSupply(supplyShortDto);
    }

    @GetMapping
    public List<SupplyDto> getAllSupplies() {
        return  supplyService.getAllSupplies();
    }

    @GetMapping("/{id}")
    SupplyDto getSupplyById(@PathVariable("id") Long id) {
        return  supplyService.getSupplyById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplyById(@PathVariable("id") Long id){
        supplyService.deleteSupplyById(id);
    }
}

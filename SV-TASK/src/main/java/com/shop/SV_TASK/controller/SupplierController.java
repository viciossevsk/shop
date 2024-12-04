package com.shop.SV_TASK.controller;

import com.shop.SV_TASK.dto.SupplierDto;
import com.shop.SV_TASK.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
//@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping(path = "/supplier")
public class SupplierController {


    private final SupplierService supplierService;

    @PostMapping
    public SupplierDto createSupplier(@Valid @RequestBody SupplierDto supplierDto){
        return supplierService.createSupplier(supplierDto);
    }

    @GetMapping
    public List<SupplierDto> getAllSuppliers() {
        return  supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    SupplierDto getSupplierById(@Valid @PathVariable("id") Long id) {
        return  supplierService.getSupplierById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplierById(@Valid @PathVariable("id") Long id){
        supplierService.deleteSupplierById(id);
    }
}


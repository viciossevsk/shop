package com.shop.SV_TASK.service;

import com.shop.SV_TASK.domain.Supplier;
import com.shop.SV_TASK.dto.SupplierDto;
import com.shop.SV_TASK.exception.EntityNotFoundException;
import com.shop.SV_TASK.exception.ValidationException;
import com.shop.SV_TASK.mapper.SupplierMapper;
import com.shop.SV_TASK.repository.SupplierRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.shop.SV_TASK.otherFunction.AddvansedFunctions.MISTAKEN_SUPPLIER_ID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SupplierServiceImpl implements SupplierService {

    SupplierRepository supplierRepository;
    SupplierMapper supplierMapper;

    @Override
    @Transactional
    public SupplierDto createSupplier(SupplierDto supplierDto) {
        validate(supplierDto);
        Supplier supplier = supplierMapper.toSupplier(supplierDto);
        return supplierMapper.toSupplierDto(supplierRepository.save(supplier));
    }

    @Override
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SupplierDto> getAllSuppliers() {
        return supplierRepository.findAll().stream().map(supplierMapper::toSupplierDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public SupplierDto getSupplierById(Long supplierId) {
        return supplierMapper.toSupplierDto(supplierRepository.findById(supplierId)
                                                    .orElseThrow(() -> new EntityNotFoundException(String.format(MISTAKEN_SUPPLIER_ID, supplierId))));
    }

    @Override
    @Transactional
    public void deleteSupplierById(Long supplierId) {
        supplierRepository.deleteById(supplierId);
    }

    private void validate(SupplierDto supplierDto) {
        if ((supplierDto.getName() == null) || (supplierDto.getName().isEmpty())) {
            throw new ValidationException("Supplier name invalid");
        }

        List<Supplier> suppliers = supplierRepository.findAllByName(supplierDto.getName());

        if (!suppliers.isEmpty()) {
            throw new ValidationException("Supplier with these name already exists");

        }
    }
}

package com.shop.SV_TASK.service;

import com.shop.SV_TASK.domain.Supplier;
import com.shop.SV_TASK.dto.SupplierDto;
import com.shop.SV_TASK.exception.EntityNotFoundException;
import com.shop.SV_TASK.exception.ValidationException;
import com.shop.SV_TASK.mapper.SupplierMapper;
import com.shop.SV_TASK.repository.SupplierRepository;
import com.vaadin.flow.component.notification.Notification;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.shop.SV_TASK.otherFunction.AddvansedFunctions.MISTAKEN_SUPPLIER_ID;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SupplierServiceImpl implements SupplierService {

    SupplierRepository supplierRepository;
    SupplierMapper supplierMapper;

    @Override
    public void saveWeb(Supplier supplier) {
        validate(supplier);
        supplierRepository.save(supplier);
    }

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
    public List<Supplier> getAll() {
        return new ArrayList<>(supplierRepository.findAll());
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

    private void validate(Supplier supplier) {
        log.info("validate");
        if ((supplier.getName() == null) || (supplier.getName().isEmpty())) {
            showErrorNotification("Supplier name invalid");
        }

        List<Supplier> suppliers = supplierRepository.findAllByName(supplier.getName());

        if (!suppliers.isEmpty()) {
            showErrorNotification("Supplier with these name already exists");
        }
    }

    private void showErrorNotification (String message){
        Notification notification = Notification.show(message, 3000, Notification.Position.BOTTOM_CENTER);
        notification.setThemeName("error");
        throw new ValidationException(message);
    }
}

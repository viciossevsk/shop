package com.shop.SV_TASK.service;

import com.shop.SV_TASK.domain.Product;
import com.shop.SV_TASK.domain.ProductPrice;
import com.shop.SV_TASK.domain.Supplier;
import com.shop.SV_TASK.dto.ProductPriceDto;
import com.shop.SV_TASK.dto.ProductPriceShortDto;
import com.shop.SV_TASK.exception.EntityNotFoundException;
import com.shop.SV_TASK.exception.ValidationException;
import com.shop.SV_TASK.mapper.ProductPriceMapper;
import com.shop.SV_TASK.repository.ProductPriceRepository;
import com.shop.SV_TASK.repository.ProductRepository;
import com.shop.SV_TASK.repository.SupplierRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.shop.SV_TASK.otherFunction.AddvansedFunctions.*;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductPriceServiceImpl implements ProductPriceService{

    ProductPriceRepository productPriceRepository;
    ProductRepository productRepository;
    SupplierRepository supplierRepository;
    ProductPriceMapper productPriceMapper;

    @Override
    @Transactional
    public ProductPriceDto createProductPrice(ProductPriceShortDto productPriceShortDto) {
        log.info(stringToGreenColor(productPriceShortDto.toString()));
        Product product = productRepository.findById(productPriceShortDto.getProductId())
                .orElseThrow(() -> new EntityNotFoundException(String.format(MISTAKEN_PRODUCT_ID,productPriceShortDto.getProductId())));
        Supplier supplier = supplierRepository.findById(productPriceShortDto.getSupplierId())
                .orElseThrow(() -> new EntityNotFoundException(String.format(MISTAKEN_SUPPLIER_ID,productPriceShortDto.getSupplierId())));
        validate(productPriceShortDto);
        ProductPrice productPrice = productPriceMapper.toProductPrice(productPriceShortDto, product, supplier);
        log.info(stringToGreenColor(productPrice.toString()));
        return productPriceMapper.toProductPriceDto(productPriceRepository.save(productPrice));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductPriceDto> getAllProductPrices() {
        return productPriceRepository.findAll().stream().map(productPriceMapper::toProductPriceDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductPriceDto getProductPriceById(Long productPriceId) {
        return productPriceMapper.toProductPriceDto(productPriceRepository.findById(productPriceId)
                                                .orElseThrow(() -> new EntityNotFoundException(String.format(MISTAKEN_PRODUCT_PRICE_ID, productPriceId))));
    }

    @Override
    @Transactional
    public void deleteProductPriceById(Long productPriceId) {
        productPriceRepository.deleteById(productPriceId);
    }

    private void validate(ProductPriceShortDto productPriceShortDto) {
       Optional<ProductPrice> productPrice = productPriceRepository.findDoubleProductPrice(
               productPriceShortDto.getProductId(),
               productPriceShortDto.getSupplierId(),
               productPriceShortDto.getPrice(),
               productPriceShortDto.getPeriod_from(),
               productPriceShortDto.getPeriod_to()
       );

        if (productPrice.isPresent()) {
            throw new ValidationException("Product price with these parameters already exists");
        }


    }
}

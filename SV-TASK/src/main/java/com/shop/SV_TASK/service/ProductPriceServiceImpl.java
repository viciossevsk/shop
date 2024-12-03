package com.shop.SV_TASK.service;

import com.shop.SV_TASK.domain.ProductPrice;
import com.shop.SV_TASK.dto.ProductPriceDto;
import com.shop.SV_TASK.exception.EntityNotFoundException;
import com.shop.SV_TASK.exception.ValidationException;
import com.shop.SV_TASK.mapper.ProductPriceMapper;
import com.shop.SV_TASK.repository.ProductPriceRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.shop.SV_TASK.otherFunction.AddvansedFunctions.*;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductPriceServiceImpl implements ProductPriceService{

    ProductPriceRepository productPriceRepository;
    ProductPriceMapper productPriceMapper;

    @Override
    @Transactional
    public ProductPriceDto createProductPrice(ProductPriceDto productPriceDto) {
        validate(productPriceDto);
        ProductPrice productPrice = productPriceMapper.toProductPrice(productPriceDto);
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

    private void validate(ProductPriceDto productPriceDto) {
       Optional<ProductPrice> productPrice = productPriceRepository.findDoubleProductPrice(
               productPriceDto.getProductId(),
               productPriceDto.getSupplierId(),
               productPriceDto.getPrice(),
               productPriceDto.getPeriod_from(),
               productPriceDto.getPeriod_to()
       );

        if (productPrice.isPresent()) {
            throw new ValidationException("Product price with these parameters already exists");
        }


    }
}

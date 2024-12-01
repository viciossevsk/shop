package com.shop.SV_TASK.services;

import com.shop.SV_TASK.domain.Supply;
import com.shop.SV_TASK.dto.ProductPriceDto;
import com.shop.SV_TASK.dto.SupplyDto;
import com.shop.SV_TASK.exceptions.EntityNotFoundException;
import com.shop.SV_TASK.exceptions.ValidationException;
import com.shop.SV_TASK.mappers.ProductPriceMapper;
import com.shop.SV_TASK.repositories.ProductPriceRepository;
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
        return null;
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

    }

    private void validate(ProductPriceDto productPriceDto) {
        int num = supplyDto.getNum();
        Optional<Supply> supply = supplyRepository.findSupplyByNum(num);
        if (supply.isPresent()) {
            throw new ValidationException(String.format(MISTAKEN_VALID_SUPPLY_NUM, num));
        }
        if (!productPriceRepository.existsById(supplyDto.getProductPriceId())) {
            throw new EntityNotFoundException(String.format(MISTAKEN_PRODUCT_PRICE_ID, supplyDto.getProductPriceId()));
        }
    }
}

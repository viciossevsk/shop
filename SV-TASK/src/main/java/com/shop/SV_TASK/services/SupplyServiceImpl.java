package com.shop.SV_TASK.services;

import com.shop.SV_TASK.domain.ProductPrice;
import com.shop.SV_TASK.domain.Supply;
import com.shop.SV_TASK.dto.SupplyDto;
import com.shop.SV_TASK.exceptions.EntityNotFoundException;
import com.shop.SV_TASK.exceptions.ValidationException;
import com.shop.SV_TASK.mappers.SupplyMapper;
import com.shop.SV_TASK.repositories.ProductPriceRepository;
import com.shop.SV_TASK.repositories.SupplyRepository;
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
public class SupplyServiceImpl implements SupplyService{

    SupplyRepository supplyRepository;
    SupplyMapper supplyMapper;
    ProductPriceRepository productPriceRepository;

    @Override
    @Transactional
    public SupplyDto createSupply(SupplyDto supplyDto) {
        validate(supplyDto);

        ProductPrice productPrice = productPriceRepository.findById(supplyDto.getProductPriceId())
                .orElseThrow(() ->  new EntityNotFoundException(String.format(MISTAKEN_PRODUCT_PRICE_ID, supplyDto.getProductPriceId())));
        Supply supply = supplyMapper.toSupply(supplyDto);
        supply.setProductPrice(productPrice);
        supplyRepository.save(supply);
        return supplyMapper.toSupplyDto(supplyRepository.findById(supply.getId()).orElseThrow(() -> new EntityNotFoundException(String.format(MISTAKEN_SUPPLY_ID, supply.getId()))));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SupplyDto> getAllSupplies() {
        return supplyRepository.findAll().stream().map(supplyMapper::toSupplyDto).collect(Collectors.toList());
    }


    @Override
    @Transactional(readOnly = true)
    public SupplyDto getSupplyById(Long supplyId) {
        return supplyMapper.toSupplyDto(supplyRepository.findById(supplyId)
                                                .orElseThrow(() -> new EntityNotFoundException(String.format(MISTAKEN_SUPPLY_ID, supplyId))));
    }

    @Override
    @Transactional
    public void deleteSupplyById(Long supplyId) {
        supplyRepository.deleteById(supplyId);
    }

    private void validate(SupplyDto supplyDto) {
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

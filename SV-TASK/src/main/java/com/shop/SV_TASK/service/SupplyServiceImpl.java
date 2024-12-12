package com.shop.SV_TASK.service;

import com.shop.SV_TASK.domain.ProductPrice;
import com.shop.SV_TASK.domain.Supply;
import com.shop.SV_TASK.dto.SupplyDto;
import com.shop.SV_TASK.dto.SupplyShortDto;
import com.shop.SV_TASK.exception.EntityNotFoundException;
import com.shop.SV_TASK.exception.ValidationException;
import com.shop.SV_TASK.mapper.SupplyMapper;
import com.shop.SV_TASK.repository.ProductPriceRepository;
import com.shop.SV_TASK.repository.SupplyRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.shop.SV_TASK.otherFunction.AddvansedFunctions.*;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SupplyServiceImpl implements SupplyService{

    SupplyRepository supplyRepository;
    SupplyMapper supplyMapper;
    ProductPriceRepository productPriceRepository;

    @Override
    @Transactional
    public SupplyDto createSupply(SupplyShortDto supplyShortDto) {
        log.info(stringToGreenColor(supplyShortDto.toString()));
        validate(supplyShortDto);
        Set<ProductPrice> productPriceSet = productPriceRepository.findAllProductPriceByIds(supplyShortDto.getProductPricesIds());
        Supply supply = supplyMapper.toSupply(supplyShortDto, productPriceSet);
        log.info(stringToGreenColor(supply.toString()));
        return supplyMapper.toSupplyDto(supplyRepository.save(supply));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SupplyDto> getAllSupplies() {
      List<SupplyDto> supplyDtoList = supplyRepository.findAll().stream().map(supplyMapper::toSupplyDto).collect(Collectors.toList());
        return supplyDtoList;
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

    private void validate(SupplyShortDto supplyShortDto) {
        int num = supplyShortDto.getNum();
        Optional<Supply> supply = supplyRepository.findSupplyByNum(num);
        if (supply.isPresent()) {
            throw new ValidationException(String.format(MISTAKEN_VALID_SUPPLY_NUM, num));
        }

        for (Long id : supplyShortDto.getProductPricesIds()) {
            if (!productPriceRepository.existsById(id)) {
                throw new EntityNotFoundException(String.format(MISTAKEN_PRODUCT_PRICE_ID, id));
            }
        }
    }
}

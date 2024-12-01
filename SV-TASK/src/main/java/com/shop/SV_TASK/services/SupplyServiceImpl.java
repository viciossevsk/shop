package com.shop.SV_TASK.services;

import com.shop.SV_TASK.domain.ProductPrice;
import com.shop.SV_TASK.domain.Supply;
import com.shop.SV_TASK.dto.SupplyDto;
import com.shop.SV_TASK.exceptions.ValidationException;
import com.shop.SV_TASK.mappers.SupplyMapper;
import com.shop.SV_TASK.repositories.ProductPriceRepository;
import com.shop.SV_TASK.repositories.SupplyRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.shop.SV_TASK.otherFunction.AddvansedFunctions.MISTAKEN_VALID_SUPPLY_NUM;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SupplyServiceImpl implements SupplyService{

    SupplyRepository supplyRepository;
    SupplyMapper supplyMapper;
    ProductPriceRepository productPriceRepository;

    @Override
    public SupplyDto createSupply(SupplyDto supplyDto) {
        return null;
    }

    @Override
    public List<SupplyDto> getAllSupplies() {
        return List.of();
    }

    @Override
    public SupplyDto getSupplyById(Long supplyId) {
        return null;
    }

    @Override
    public void deleteSupplyById(Long supplyId) {

    }

    private void validate(SupplyDto supplyDto) {
        int num = supplyDto.getNum();
        Optional<Supply> supply = supplyRepository.findSupplyBySnum(num);
        if (supply.isPresent()) {
            throw new ValidationException(String.format(MISTAKEN_VALID_SUPPLY_NUM, num));
        }
//        if (!productPriceRepository.existsById(supplyDto.get)) {
//            throw new EntityNotFoundException(String.format(MISTAKEN_ITEM_ID, bookingDto.getItemId()));
//        }
    }
}

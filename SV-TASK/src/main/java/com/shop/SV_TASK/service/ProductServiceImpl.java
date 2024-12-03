package com.shop.SV_TASK.service;

import com.shop.SV_TASK.domain.Product;
import com.shop.SV_TASK.dto.ProductDto;
import com.shop.SV_TASK.exception.EntityNotFoundException;
import com.shop.SV_TASK.exception.ValidationException;
import com.shop.SV_TASK.mapper.ProductMapper;
import com.shop.SV_TASK.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.shop.SV_TASK.otherFunction.AddvansedFunctions.MISTAKEN_PRODUCT_ID;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    ProductMapper productMapper;

    @Override
    @Transactional
    public ProductDto createProduct(ProductDto productDto) {
        log.info("service");
        validate(productDto);
        Product product = productMapper.toProduct(productDto);
        return productMapper.toProductDto(productRepository.save(product));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::toProductDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto getProductById(Long productId) {
        return productMapper.toProductDto(productRepository.findById(productId)
                                                  .orElseThrow(() -> new EntityNotFoundException(String.format(MISTAKEN_PRODUCT_ID, productId))));
    }

    @Override
    @Transactional
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }

    private void validate(ProductDto productDto) {
        log.info("validate");
        if ((productDto.getName() == null) || (productDto.getName().isEmpty())) {
            throw new ValidationException("Product name invalid");
        }

        List<Product> products = productRepository.findAllByName(productDto.getName());

        if (!products.isEmpty()) {
            throw new ValidationException("Product with these name already exists");
        }
    }
}

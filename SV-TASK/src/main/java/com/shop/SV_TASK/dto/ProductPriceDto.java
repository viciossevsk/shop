package com.shop.SV_TASK.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shop.SV_TASK.domain.Product;
import com.shop.SV_TASK.domain.Supplier;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductPriceDto {
    Long id;
    @Positive(message = "Value must be Long and positive")
    private Long price;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    LocalDate period_from;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    LocalDate period_to;
    ProductDto productDto;
    SupplierDto supplierDto;
}

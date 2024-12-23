package com.shop.SV_TASK.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * DTO для возврата пользователю, вместо ид возвращаем объекты полностью
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductPriceDto {
    Long id;
    @Positive(message = "Value must be Long and positive")
    @NotNull
    float price;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    LocalDate period_from;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    LocalDate period_to;
    ProductDto productDto;
    SupplierDto supplierDto;
}

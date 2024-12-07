package com.shop.SV_TASK.dto;

import com.shop.SV_TASK.controller.ProductController;
import com.shop.SV_TASK.controller.SupplierController;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
/**
 * DTO для получения данных от пользователя, получаем ид Product и Supplier
 **/
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductPriceShortDto {
    Long id;
    @NotNull(groups = ProductController.class)
    Long productId;
    @NotNull(groups = SupplierController.class)
    Long supplierId;
    @Positive(message = "Value must be Long and positive")
    @NotNull
    float price;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    LocalDate period_from;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    LocalDate period_to;
}

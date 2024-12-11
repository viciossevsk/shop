package com.shop.SV_TASK.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO для получения данных от пользователя, получаем ид productPrice
 **/
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupplyShortDto {
    @NotNull
    private Set<Long> productPricesIds;
    @NotNull
    @Positive(message = "Value must be positive")
    int num;
    @DateTimeFormat(pattern = "YYYY-MM-DDTHH:mm:ss")
    LocalDateTime dateTime;
    @NotNull
    @Positive(message = "Value must be positive")
    float weight;
}

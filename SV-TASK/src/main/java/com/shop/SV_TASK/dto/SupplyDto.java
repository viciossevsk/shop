package com.shop.SV_TASK.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * DTO для возврата пользователю, вместо ид productPrice возвращаем объект полностью
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SupplyDto {
    Long id;
    @Size(max = 5)
    @NotNull
    @Positive(message = "Value must be positive")
    int num;
    @DateTimeFormat(pattern = "YYYY-MM-DDTHH:mm:ss")
    LocalDateTime supply_dateTime;
    @Size(max = 3)
    @NotBlank(message = "Supply weight must be specified")
    @Positive(message = "Value must be positive")
    float weight;
    ProductPriceDto productPriceDto;

}

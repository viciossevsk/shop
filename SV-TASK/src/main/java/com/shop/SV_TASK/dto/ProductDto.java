package com.shop.SV_TASK.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shop.SV_TASK.domain.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {
    Long id;
    @Size(max = 20)
    @NotBlank(message = "Product name must be specified")
    String name;
}

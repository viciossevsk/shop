package com.shop.SV_TASK.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = @Index(name = "product_price_index", columnList = "id, period_from, period_to", unique = true))
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductPrice {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    float price;

    LocalDate period_from;

    LocalDate period_to;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;
}

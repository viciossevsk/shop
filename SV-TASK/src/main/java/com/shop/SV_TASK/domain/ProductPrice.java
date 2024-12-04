package com.shop.SV_TASK.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "PRODUCTPRICES", indexes = @Index(name = "product_price_index", columnList = "id, period_from, period_to", unique = true))
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductPrice {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    float price;
    @Column(name = "period_from", nullable = false)
    LocalDate period_from;
    @Column(name = "period_to", nullable = false)
    LocalDate period_to;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product product;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    Supplier supplier;
    @OneToMany
    List<Supply> supplies = new ArrayList<>();
}

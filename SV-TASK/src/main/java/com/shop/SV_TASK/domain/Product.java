package com.shop.SV_TASK.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    Supplier supplier;

    @OneToMany
    Set<ProductPrice> productPrices = new HashSet<>();


}

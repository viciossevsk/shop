package com.shop.SV_TASK.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SUPPLIERS")
@ToString
//@EqualsAndHashCode
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Supplier {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    Set<ProductPrice> productPrices = new HashSet<>();
}

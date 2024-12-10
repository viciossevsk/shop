package com.shop.SV_TASK.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "SUPPLIES")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Supply {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "num", nullable = false)
    int num;
    @Column(name = "date_time", nullable = false)
    LocalDateTime dateTime;
    @Column(name = "weight", nullable = false)
    float weight;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "productPrice_supply",
            joinColumns = @JoinColumn(name = "supply_id"),
            inverseJoinColumns = @JoinColumn(name = "productPrice_id"))


    Set<ProductPrice> productPrices = new HashSet<>();

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "productprice_id", referencedColumnName = "id")
//    ProductPrice productPrice;

}

package com.shop.SV_TASK.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SUPPLIES")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Supply {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int num;

    LocalDateTime supply_dateTime;

    float weight;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "productprice_id", referencedColumnName = "id")
    ProductPrice productPrice;

}

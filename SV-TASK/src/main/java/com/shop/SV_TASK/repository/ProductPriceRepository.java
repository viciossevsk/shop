package com.shop.SV_TASK.repository;

import com.shop.SV_TASK.domain.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {

    @Query(
            "select pr" +
                    " from ProductPrice pr" +
                    " join pr.product" +
                    " join pr.supplier" +
                    " join pr.price" +
                    " join pr.period_from" +
                    " join pr.period_to" +
                    " where pr.product = :productId" +
                    " and pr.supplier = :supplierId" +
                    " and pr.price = :price" +
                    " and pr.period_from = :period_from" +
                    " and pr.period_to = :period_to"
    )
    Optional<ProductPrice> findDoubleProductPrice(@Param("productId") Long productId,
                                                 @Param("supplierId") Long supplierId,
                                                 @Param("price") float price,
                                                 @Param("period_from") LocalDate period_from,
                                                 @Param("period_to") LocalDate period_to
    );

}
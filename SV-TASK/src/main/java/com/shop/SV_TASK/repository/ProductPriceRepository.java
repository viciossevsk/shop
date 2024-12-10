package com.shop.SV_TASK.repository;

import com.shop.SV_TASK.domain.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {

    @Transactional(readOnly = true)
    @Query(
            "select pr from ProductPrice pr " +
                    "where pr.product.id = :productId " +
                    "and pr.supplier.id = :supplierId " +
                    "and pr.price = :price " +
                    "and pr.period_from = :period_from " +
                    "and pr.period_to = :period_to"
    )
    Optional<ProductPrice> findDoubleProductPrice(@Param("productId") Long productId,
                                                  @Param("supplierId") Long supplierId,
                                                  @Param("price") float price,
                                                  @Param("period_from") LocalDate period_from,
                                                  @Param("period_to") LocalDate period_to
    );

    @Transactional(readOnly = true)
    @Query("select pr from ProductPrice pr " +
            "join fetch pr.product " +
            "join fetch pr.supplier " +
            "where pr.id in :productPricesIds " +
            "order by pr.id")
    Set<ProductPrice> findAllProductPriceByIds(@Param("productPricesIds") Set<Long> productPricesIds);
}

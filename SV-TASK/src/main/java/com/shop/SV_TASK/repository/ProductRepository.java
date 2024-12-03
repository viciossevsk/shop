package com.shop.SV_TASK.repository;

import com.shop.SV_TASK.domain.Product;
import com.shop.SV_TASK.domain.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByName(String name);

//    @Query(
//            "select p" +
//                    " from Product p" +
//                    " join p.name" +
//                    " where p.name = :name"
//    )
//    Optional<Product> findDoubleProduct(@Param("name") String name);
}

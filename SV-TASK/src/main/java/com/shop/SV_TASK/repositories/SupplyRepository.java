package com.shop.SV_TASK.repositories;

import com.shop.SV_TASK.domain.Supply;
import com.shop.SV_TASK.dto.SupplyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {
    Optional<Supply> findSupplyBySnum(Integer snum);

//    @Query(
//            "select new ru.practicum.shareit.item.dto.CommentDto(c.id, c.text, c.authorName, c.created, c.item.id)" +
//                    " from Comment as c" +
//                    " where c.id = ?1"
//    )
//    SupplyDto findSupplyDtoByNumber(Long id);
}

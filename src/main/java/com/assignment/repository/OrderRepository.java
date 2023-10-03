package com.assignment.repository;

import com.assignment.entites.ShopOrder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository  extends JpaRepository<ShopOrder, Integer> {
    Optional<ShopOrder> findByOrderId(Long id );

    @Query("FROM  ShopOrder s WHERE s.shopId = :shopId ")
    List<ShopOrder> listByShopId(Long shopId);
    @Transactional
    @Modifying
    @Query("UPDATE ShopOrder    SET status= :status WHERE  orderId = :id " )
    void updateStatus(Long id, String status );
}

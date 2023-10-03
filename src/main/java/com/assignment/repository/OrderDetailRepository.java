package com.assignment.repository;

import com.assignment.entites.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
    Optional<OrderDetail> findById(Long id);
    List<OrderDetail> findByOrderId(Long id);
}

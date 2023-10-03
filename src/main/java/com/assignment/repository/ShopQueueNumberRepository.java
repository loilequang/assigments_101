package com.assignment.repository;

import com.assignment.entites.ShopQueueNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopQueueNumberRepository extends JpaRepository<ShopQueueNumber,Integer> {
}

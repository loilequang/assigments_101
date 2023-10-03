package com.assignment.repository;

import com.assignment.entites.ShopConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopConfigRepository extends JpaRepository<ShopConfig,Integer> {
}

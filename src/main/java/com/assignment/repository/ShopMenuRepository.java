package com.assignment.repository;

import com.assignment.entites.ShopMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopMenuRepository extends JpaRepository<ShopMenu, Integer> {
    @Query("FROM ShopMenu sm WHERE sm.mId = :id ")
    public Optional<ShopMenu> findByMId(Long id);

}

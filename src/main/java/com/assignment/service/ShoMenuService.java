package com.assignment.service;

import com.assignment.entites.ShopMenu;
import com.assignment.repository.ShopMenuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoMenuService {
    @Autowired
    ShopMenuRepository shopMenuRepository;
    @Transactional
    public ShopMenu createNew(Integer shopId, String title, Integer price){
        ShopMenu shopMenu = new ShopMenu();
        shopMenu.setShopId(shopId);
        shopMenu.setTitle(title);
        shopMenu.setIsActive(true);
        shopMenu.setPrice(price);
        return  shopMenuRepository.save(shopMenu);
    }
}

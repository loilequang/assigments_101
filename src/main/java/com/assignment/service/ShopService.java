package com.assignment.service;

import com.assignment.entites.Shop;
import com.assignment.repository.ShopRepository;
import com.assignment.request.shop.NewShopReq;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    ShopRepository shopRepository;

    @Transactional
    public Shop createShop(NewShopReq newShopReq){
        Shop newShop = new Shop();
        newShop.setName(newShopReq.getName());
        newShop.setContactName(newShopReq.getContactName());
        return  shopRepository.saveAndFlush(newShop);
    }
}

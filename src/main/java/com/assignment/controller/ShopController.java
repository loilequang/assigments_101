package com.assignment.controller;

import com.assignment.entites.Shop;
import com.assignment.request.shop.MenuItemReq;
import com.assignment.request.shop.NewShopConfigReq;
import com.assignment.request.shop.NewShopReq;
import com.assignment.service.ShoMenuService;
import com.assignment.service.ShopConfigService;
import com.assignment.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopConfigService shopConfigService;
 @Autowired
    ShoMenuService shoMenuService;
    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody NewShopReq newShopReq){
        Shop newShop = shopService.createShop(newShopReq);
        return ResponseEntity.ok(newShop);
    }
    @PostMapping("/config")
    public ResponseEntity configShop(@RequestBody NewShopConfigReq newShopReq){
         shopConfigService.createConfig(newShopReq);
        return ResponseEntity.ok("");
    }
    @PostMapping("/addMenu")
    public ResponseEntity addNewMenuItem(@RequestBody MenuItemReq req){
        shoMenuService.createNew(req.getShopId(),req.getTitle(),req.getPrice());
        return ResponseEntity.ok("Success");
    }
}

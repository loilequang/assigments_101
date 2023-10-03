package com.assignment.service;

import com.assignment.entites.ShopConfig;
import com.assignment.repository.ShopConfigRepository;
import com.assignment.request.shop.NewShopConfigReq;
import com.assignment.utils.DateUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopConfigService {
    @Autowired
    ShopConfigRepository shopConfigRepository;

    @Transactional
    public void createConfig(NewShopConfigReq conf) {
        ShopConfig shopConfig = new ShopConfig();
        shopConfig.setShopId(conf.getShopId());
        shopConfig.setLocation(conf.getLocation());
        shopConfig.setQueueNumber(conf.getQueueNumber());
        shopConfig.setQueueNumberMaxItem(conf.getQueueNumberMaxItem());
        shopConfig.setOpenTime(DateUtils.getTime(conf.getOpenTime()));
        shopConfig.setCloseTime(DateUtils.getTime(conf.getCloseTime()));
        shopConfigRepository.save(shopConfig);
    }
}

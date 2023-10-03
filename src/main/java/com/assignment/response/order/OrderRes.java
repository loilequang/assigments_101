package com.assignment.response.order;

import com.assignment.entites.ShopOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRes {
    private Integer Id;
    private String orderCode;
    private Integer shopId;
    private Integer queueId ;
    private ZonedDateTime orderAt ;// timestamp with time zone,
    private String address ;
    private String customerName ;
    private String status ;
    public static  OrderRes fromEntity(ShopOrder entity){
        OrderRes orderRes = new OrderRes();
        orderRes.setId(entity.getOrderId());
        orderRes.setShopId(entity.getShopId());
        orderRes.setOrderCode(entity.getOrderCode());
        orderRes.setQueueId(entity.getQueueId());
        orderRes.setOrderAt(entity.getOrderAt());
        orderRes.setAddress(entity.getAddress());
        orderRes.setCustomerName(entity.getCustomerName());
        orderRes.setStatus(entity.getStatus());
        return  orderRes;
    }
}

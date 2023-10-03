package com.assignment.response.order;

import com.assignment.entites.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemRes {
    private Integer id;
    private Integer orderId;
    private Long mId;
    private Integer quantity;
    private Integer amount;
    public static OrderItemRes fromEntity(OrderDetail detail){
        OrderItemRes itemRes = new OrderItemRes();
        itemRes.setId(detail.getId());
        itemRes.setOrderId(detail.getOrderId());
        itemRes.setMId(detail.getMId());
        itemRes.setQuantity(detail.getQuantity());
        itemRes.setAmount(detail.getAmount());
        return itemRes;
    }
}

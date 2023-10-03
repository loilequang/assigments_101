package com.assignment.request.order;

import com.assignment.valid.FieldNotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailReq {
    @FieldNotNull(fieldName ="orderId")
    Long orderId;
    List<OrderItemReq> items;
}

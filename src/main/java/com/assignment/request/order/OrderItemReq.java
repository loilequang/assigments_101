package com.assignment.request.order;

import com.assignment.valid.NumberMax;
import com.assignment.valid.NumberMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemReq {

    @NumberMin(fieldName = "menuId",min = 0 )
    private long menuId;
    @NumberMin(fieldName = "quantity",min = 0 )
    @NumberMax(fieldName = "quantity",max = 10 )
    private int quantity;
}

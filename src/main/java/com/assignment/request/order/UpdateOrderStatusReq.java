package com.assignment.request.order;

import com.assignment.valid.FieldNotNull;
import com.assignment.valid.NumberMin;
import com.assignment.valid.StringMaxLength;
import com.assignment.valid.StringNotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateOrderStatusReq {

    @FieldNotNull(fieldName = "orderId")
    @NumberMin(fieldName = "orderId", min = 0 )
    Long orderId;
    @StringNotNull(fieldName = "orderStatus")
    @StringMaxLength(fieldName = "orderStatus", max = 10)
    String orderStatus;
}

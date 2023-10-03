package com.assignment.request.order;

import com.assignment.valid.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewOrderReq {
    @FieldNotNull(fieldName = "shopId")
    @NumberMin(fieldName = "shopId", min = 0 )
    private Integer shopId;

    @FieldNotNull(fieldName = "queueId")
    @NumberMin(fieldName = "queueId", min = 0 )
    private Integer queueId ;

    @StringNotNull(fieldName = "address")
    @StringMinLength(fieldName = "address",min = 8 )
    @StringMaxLength(fieldName = "address", max = 100 )
    private String address ;

    @StringNotNull(fieldName = "customerName")
    @StringMinLength(fieldName = "customerName",min = 8 )
    @StringMaxLength(fieldName = "customerName", max = 100 )
    private String customerName ;
}

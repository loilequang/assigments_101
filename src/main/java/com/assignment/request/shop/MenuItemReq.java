package com.assignment.request.shop;

import com.assignment.valid.FieldNotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuItemReq {
    @FieldNotNull(fieldName = "shopId")
    Integer shopId;
    @FieldNotNull(fieldName = "title")
    String title;
    @FieldNotNull(fieldName = "price")
    Integer price;
}

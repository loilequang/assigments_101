package com.assignment.request.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewShopConfigReq {
    private Integer configId;
    private Integer shopId ;
    private String location ;
    private Long  openTime ;
    private Long closeTime ;
    private Integer queueNumber;
    private Integer queueNumberMaxItem ;
}

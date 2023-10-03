package com.assignment.controller;

import com.assignment.constants.ApiErrorCode;
import com.assignment.error.ApiException;
import com.assignment.request.order.NewOrderReq;
import com.assignment.request.order.OrderDetailReq;
import com.assignment.request.order.UpdateOrderStatusReq;
import com.assignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public String createOrder(@RequestBody NewOrderReq req) {
        return orderService.createOrder(req);
    }

    @PostMapping("/setOrderDetail")
    public String setOrderDetail(@RequestBody OrderDetailReq req) {
        orderService.setOrderDetail(req);
        return "Success";
    }

    @GetMapping("/listByShop/{shopId}")
    public ResponseEntity listOrderByShop(@PathVariable Long shopId){
        if(shopId == null){
            throw  new ApiException(ApiErrorCode.NUMBER_INCORRECT_VALUE, "ShopId") ;
        }
        return  ResponseEntity.ok(orderService.getOrdersByShopId(shopId));
    }
    @GetMapping("/{id}")
    public ResponseEntity getOrderDetail(@PathVariable Long id)
    {
        if(id == null){
            throw  new ApiException(ApiErrorCode.NUMBER_INCORRECT_VALUE, "OrderId") ;
        }
        return ResponseEntity.ok (orderService.getOrderDetail(id));
    }
    @PutMapping
    public ResponseEntity setOrderStatus(@RequestBody UpdateOrderStatusReq req){
        orderService.changeStatus(req.getOrderId(),req.getOrderStatus());
        return ResponseEntity.ok("Success");
    }

}

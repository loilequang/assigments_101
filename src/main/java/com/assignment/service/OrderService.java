package com.assignment.service;

import com.assignment.constants.ApiErrorCode;
import com.assignment.constants.OrderStatus;
import com.assignment.entites.OrderDetail;
import com.assignment.entites.ShopMenu;
import com.assignment.entites.ShopOrder;
import com.assignment.error.ApiException;
import com.assignment.repository.OrderDetailRepository;
import com.assignment.repository.OrderRepository;
import com.assignment.repository.ShopMenuRepository;
import com.assignment.request.order.NewOrderReq;
import com.assignment.request.order.OrderDetailReq;
import com.assignment.response.order.OrderDetailRes;
import com.assignment.response.order.OrderItemRes;
import com.assignment.response.order.OrderRes;
import com.assignment.utils.DateUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    ShopMenuRepository shopMenuRepository;

    @Transactional
    public String createOrder(NewOrderReq orderReq) {
        ShopOrder shopOrder = new ShopOrder();
        Long time = System.currentTimeMillis();
        shopOrder.setOrderCode("Order_" + time);
        shopOrder.setShopId(orderReq.getShopId());
        shopOrder.setAddress(orderReq.getAddress());
        shopOrder.setQueueId(orderReq.getQueueId());
        shopOrder.setCustomerName(orderReq.getCustomerName());
        shopOrder.setOrderAt(DateUtils.getTime(time));
        shopOrder.setStatus(OrderStatus.NEW.getValue());
        orderRepository.save(shopOrder);
        return shopOrder.getOrderCode();
    }

    @Transactional
    public void setOrderDetail(OrderDetailReq orderDetail) {
        Optional<ShopOrder> opOrder = orderRepository.findByOrderId(orderDetail.getOrderId());
        if (opOrder.isEmpty()) {
            throw new ApiException(ApiErrorCode.NUMBER_INCORRECT_VALUE, "OrderID");
        }
        Integer orderId = opOrder.get().getOrderId();
        if (orderDetail.getItems() != null && orderDetail.getItems().size() > 0) {
            orderDetail.getItems().stream().forEach(p -> {
                OrderDetail item = new OrderDetail();
                item.setOrderId(orderId);
                item.setQuantity(p.getQuantity());
                Optional<ShopMenu> opMenu = shopMenuRepository.findByMId(p.getMenuId());
                item.setMId(p.getMenuId());
                item.setAmount(opMenu.get().getPrice());
                orderDetailRepository.save(item);
            });
        }
    }
    public List<OrderRes> getOrdersByShopId(Long shopId)
    {
       List<ShopOrder> list = orderRepository.listByShopId(shopId);
       if(list ==null || list.size() < 1){
           return Collections.emptyList();
       }
       return list.stream().map(OrderRes::fromEntity).toList();
    }
    public OrderDetailRes getOrderDetail(Long orderId){
        Optional<ShopOrder> opShopOrder = orderRepository.findByOrderId(orderId);
        if(opShopOrder.isEmpty()){
            throw new ApiException(ApiErrorCode.NUMBER_INCORRECT_VALUE, "OrderId");
        }
        OrderRes orderRes = OrderRes.fromEntity(opShopOrder.get());
        OrderDetailRes res = new OrderDetailRes();
        res.setInfo(orderRes);
        List<OrderDetail> listItem =  orderDetailRepository.findByOrderId(orderId);
        if(listItem ==null || listItem.size() < 1 ){
            res.setItems(Collections.emptyList());
            return res;
        }
        List<OrderItemRes> listItemRes = listItem.stream().map(OrderItemRes::fromEntity).toList();

        res.setItems(listItemRes);
        return  res;
    }
    public void changeStatus(Long id, String status){
        orderRepository.updateStatus(id, status);
    }
}

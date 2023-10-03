package com.assignment.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "ShopOrder")
@Table(name = "order", schema = "shop")
public class ShopOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
    @SequenceGenerator(name="order_generator", sequenceName = "order_seq")

    @Column(name = "order_id")
    private Integer orderId        ;
    @Column(name = "order_code")
    private String orderCode;
    @Column(name = "shop_id")
    private Integer shopId;
    @Column(name = "queue_id")
    private Integer queueId ;
    @Column(name = "order_at", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime orderAt ;// timestamp with time zone,
    @Column(name = "address")
    private String address ;
    @Column(name = "customer_name")
    private String customerName ;
    @Column(name = "status")
    private String status ;
}

package com.assignment.entites;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "Order")
@Table(name = "order_detail", schema = "shop")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_detail_generator")
    @SequenceGenerator(name="order_detail_generator", sequenceName = "order_detail_seq")
    @Column(name = "id")
    private Integer id   ;
    @Column(name = "order_id")
    private Integer orderId   ;
    @Column(name = "m_id")
    private Long mId   ;
    @Column(name = "quantity")
    private Integer quantity   ;
    @Column(name = "amount")
    private Integer amount   ;
}

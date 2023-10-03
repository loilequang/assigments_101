package com.assignment.entites;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "ShopQueueNumber")
@Table(name = "shop_queue_number", schema = "shop")
public class ShopQueueNumber {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_queue_number_generator")
    @SequenceGenerator(name="shop_queue_number_generator", sequenceName = "shop_queue_number_seq")

    @Column(name = "id")
    private Integer id;
    @Column(name = "shop_id")
    private Integer shopId;
    @Column(name = "queue_id")
    private Integer queueId;
    @Column(name = "order_number")
    private Integer orderNumber;
}

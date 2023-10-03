package com.assignment.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "ShopConfig")
@Table(name = "shop_config", schema = "shop")
public class ShopConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_config_generator")
    @SequenceGenerator(name="shop_config_generator", sequenceName = "shop_config_seq")

    @Column(name="config_id")
    private Integer configId;
    @Column(name="shop_id")
    private Integer shopId ;
    @Column(name="location")
    private String location ;

    @Column(name = "open_time", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime openTime ;// timestamp with time zone,

    @Column(name = "close_time", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime closeTime ;// timestamp with time zone,

    @Column(name="queue_number")
    private Integer queueNumber;
    @Column(name="queue_number_max_item")
    private Integer queueNumberMaxItem ;
}

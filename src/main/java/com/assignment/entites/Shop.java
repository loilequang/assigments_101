package com.assignment.entites;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "shop")
@Table(name = "coffee_shop", schema = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coffee_shop_generator")
    @SequenceGenerator(name="coffee_shop_generator", sequenceName = "coffee_shop")
    @Column(name= "shop_id")
    private Integer shopId ;
    @Column(name= "name")
    private String name      ;
    @Column(name= "contact_name")
    private String contactName ;
}

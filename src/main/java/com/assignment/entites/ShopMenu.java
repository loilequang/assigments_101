package com.assignment.entites;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "ShopMenu")
@Table(name = "shop_menu", schema = "shop")
public class ShopMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_menu_generator")
    @SequenceGenerator(name="shop_menu_generator", sequenceName = "shop_menu_seq")
    @Column(name = "m_id")
    private Integer mId;

    @Column(name = "shop_id")
    private Integer shopId;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    @Column(name = "is_active")
    private Boolean isActive;
}

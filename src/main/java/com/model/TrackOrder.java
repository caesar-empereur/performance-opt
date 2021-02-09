package com.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/2/8.
 */
@Data
@Entity
@Table(name = "t_track_order")
public class TrackOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackNo;

    private String buyerId;
    private String buyerName;
    private String buyerPhone;

    private String sellerId;
    private String sellerName;
    private String sellerPhone;

    private Integer totalPrice;

    private String sourceAddress;
    private String destAddress;

    private LocalDate date;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}

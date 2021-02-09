package com.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/2/8.
 */
@Data
@Entity
@Table(name = "t_track_order_sku")
public class TrackOrderSku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackNo;

    private String skuCode;

    private String skuName = "iphone xs";

    private Integer skuPrice = 5000;

    private String skuPhoto = "srcnwuineyruw-photo";

    private String skuSpec = "128G";

    private String skuDesc = "iphone";

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}

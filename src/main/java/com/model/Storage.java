package com.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/4/28.
 */
@Data
@Entity
@Table(name = "t_storage")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count;

    private String skuCode;

    private Integer version;

}

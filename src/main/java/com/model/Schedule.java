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
@Table(name = "t_schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private LocalDate date;

    private String shiftId;

    private LocalDateTime planCheckinTime;

    private LocalDateTime planCheckoutTime;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}

package com.view;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/2/24.
 */
@Data
public class AttendanceLogCheckView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private LocalDate date;

    private String scheduleId;

    private LocalDateTime checkinTime;

    private LocalDateTime checkoutTime;

    private Integer checkinStatus;

    private Integer checkoutStatus;

    private String checkinPhoto;

    private String checkoutPhoto;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    private Integer totalHour;
    private Integer clearHour;
    private Integer lateHour;
    private Integer earlyHour;
}

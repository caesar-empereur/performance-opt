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
@Table(name = "t_attendance_log")
public class AttendanceLog extends CommonField{

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

    private String companyId = "deg47c74b54573";

    private String companyName = "深圳派亚劳务公司";

    private String orgCode = "SZ0000";

    private String orgName = "深圳西部硅谷仓库";

    private String groupId = "e85v8457834n5834";

    private String groupName = "分拣组";
}

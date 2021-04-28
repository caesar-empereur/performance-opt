package com.service;

import com.alibaba.fastjson.JSON;
import com.model.AttendanceCheck;
import com.model.AttendanceLog;
import com.model.Schedule;
import com.repository.AttendanceCheckRepository;
import com.repository.AttendanceLogRepository;
import com.repository.ScheduleRepository;
import com.view.AttendanceLogCheckView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/2/24.
 */
@Service
@Slf4j
public class AttendanceLogServiceImpl implements AttendanceLogService{

    @Resource
    private AttendanceLogRepository attendanceLogRepository;

    @Resource
    private ScheduleRepository scheduleRepository;

    @Resource
    private AttendanceCheckRepository attendanceCheckRepository;

    @Override
    public Page<Map<String, Object>> pageQuery(Pageable pageable) {
        Integer start =  pageable.getPageSize() * (pageable.getPageNumber()-1);
        Integer end = start + pageable.getPageSize();

        Long startTime = System.currentTimeMillis();
        Long count = attendanceLogRepository.countTotal();
        log.info(" count 耗时：" + (System.currentTimeMillis()-startTime)/1000F);
        List<Map<String, Object>> mapList = attendanceLogRepository.queryList(start.longValue(), end.longValue());
        log.info(" select 耗时：" + (System.currentTimeMillis()-startTime)/1000F);
        return new PageImpl<>(mapList, pageable, count);
    }

    @Override
    @Transactional
    public void save() {

        Long start = System.currentTimeMillis();
        LocalDate date = LocalDate.of(2021, 2, 3);
        Map<String, Object> existed = attendanceLogRepository.queryOne(date, "607273f294d44cf399e01a8dd1a2151a");
        attendanceLogRepository.queryOne(date, "607273f294d44cf399e01a8dd1a2151a");

//        log.info("查询时间：" + (System.currentTimeMillis()-start)/1000F);
        System.out.println("查询时间：" + (System.currentTimeMillis()-start)/1000F);
        String code = UUID.randomUUID().toString().replace("-", "");
        Schedule schedule = new Schedule();
        schedule.setCode(code);
        schedule.setDate(date);
        schedule.setShiftId(UUID.randomUUID().toString());
        schedule.setPlanCheckinTime(LocalDateTime.now());
        schedule.setPlanCheckoutTime(LocalDateTime.now());
        schedule.setCreateTime(LocalDateTime.now());
        schedule.setUpdateTime(LocalDateTime.now());

        AttendanceLog attendanceLog = new AttendanceLog();
        attendanceLog.setCode(code);
        attendanceLog.setDate(date);
        attendanceLog.setCheckinPhoto("checkin-photo");
        attendanceLog.setCheckoutPhoto("checkout-photo");
        attendanceLog.setCheckinStatus(1);
        attendanceLog.setCheckoutStatus(6);
        attendanceLog.setCheckinTime(LocalDateTime.now());
        attendanceLog.setCheckoutTime(LocalDateTime.now());
        attendanceLog.setCreateTime(LocalDateTime.now());
        attendanceLog.setUpdateTime(LocalDateTime.now());

        AttendanceCheck attendanceCheck = new AttendanceCheck();
        attendanceCheck.setCode(code);
        attendanceCheck.setDate(date);
        attendanceCheck.setTotalHour(8);
        attendanceCheck.setClearHour(8);
        attendanceCheck.setLateHour(8);
        attendanceCheck.setEarlyHour(8);
        attendanceCheck.setCreateTime(LocalDateTime.now());
        attendanceCheck.setUpdateTime(LocalDateTime.now());

        scheduleRepository.save(schedule);
        attendanceLogRepository.save(attendanceLog);
        attendanceCheckRepository.save(attendanceCheck);
//        log.info("插入时间：" + (System.currentTimeMillis()-start)/1000F);
        System.out.println("插入时间：" + (System.currentTimeMillis()-start)/1000F);
    }
}

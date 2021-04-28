package com.controller;

import com.model.AttendanceCheck;
import com.model.AttendanceLog;
import com.model.Schedule;
import com.repository.AttendanceCheckRepository;
import com.repository.AttendanceLogRepository;
import com.repository.ScheduleRepository;
import com.service.AttendanceLogService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/3/3.
 */
@Api(value = "造数据接口")
@RestController
@RequestMapping("/create-data")
@Slf4j
public class CreateDataController {

    @Resource
    private AttendanceLogService attendanceLogService;

    @Resource
    private ScheduleRepository scheduleRepository;

    @Resource
    private AttendanceLogRepository attendanceLogRepository;

    @Resource
    private AttendanceCheckRepository attendanceCheckRepository;

    private static final ExecutorService
            EXECUTOR_SERVICE = Executors.newFixedThreadPool(4);

    //    private LocalDate LOCAL_DATE = LocalDate.now();
    private LocalDate LOCAL_DATE = LocalDate.of(2020, 10, 1);

    private AtomicInteger count = new AtomicInteger(1);

    @GetMapping("/create-data/normal")
    public void create(){
        for (int i=0; i<4; i++){
            EXECUTOR_SERVICE.submit(()->{
                while (true){
                    createDateTask();
                }
            });
        }
    }

    @GetMapping("/create-data/one")
    public void createOne(){
        createDateTask();
    }

    private void createDateTask(){
        List<Schedule> schedules = new ArrayList<>();
        List<AttendanceLog> attendanceLogs = new ArrayList<>();
        List<AttendanceCheck> attendanceChecks = new ArrayList<>();
        LocalDate date = LOCAL_DATE.minusDays(count.incrementAndGet());

        for (int i = 0; i < 500; i++){

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

            schedules.add(schedule);
            attendanceLogs.add(attendanceLog);
            attendanceChecks.add(attendanceCheck);
        }

        scheduleRepository.saveAll(schedules);
        attendanceLogRepository.saveAll(attendanceLogs);
        attendanceCheckRepository.saveAll(attendanceChecks);
    }
}

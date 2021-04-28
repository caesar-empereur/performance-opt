package com.controller;

import com.model.AttendanceCheck;
import com.model.AttendanceLog;
import com.model.Schedule;
import com.repository.AttendanceCheckRepository;
import com.repository.AttendanceLogRepository;
import com.repository.ScheduleRepository;
import com.service.AttendanceLogService;
import com.view.AttendanceLogCheckView;
import com.view.PageRequestView;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/2/8.
 */
@Api(value = "考勤相关接口")
@RestController
@RequestMapping("/attendance")
@Slf4j
public class AttendanceLogController {

    @Resource
    private AttendanceLogService attendanceLogService;

    @Resource
    private ScheduleRepository scheduleRepository;

    @Resource
    private AttendanceLogRepository attendanceLogRepository;

    @Resource
    private AttendanceCheckRepository attendanceCheckRepository;

    @GetMapping("/list")
    public void list(){

    }

    @GetMapping("/select-one")
    public void selectOne(){
        LocalDate date = LocalDate.of(2021, 2, 3);
        Map<String, Object> existed = attendanceLogRepository.queryOne(date, "607273f294d44cf399e01a8dd1a2151a");
        log.info("查询结果：" + existed.size());
    }

    @GetMapping("/page")
    public Page<Map<String, Object>> page(@ModelAttribute PageRequestView pageRequest){
        return attendanceLogService.pageQuery(PageRequest.of(pageRequest.getPageNo(), pageRequest.getPageSize()));
    }

    @GetMapping("/save")
    public void saveOne(){
        attendanceLogService.save();
    }

}

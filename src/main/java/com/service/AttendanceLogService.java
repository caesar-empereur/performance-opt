package com.service;

import com.view.AttendanceLogCheckView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/2/24.
 */
public interface AttendanceLogService {

    Page<Map<String, Object>> pageQuery(Pageable pageable);

    void save();
}
